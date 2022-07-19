package cn.edu.whut.binary.health.provider.service.impl;

import cn.edu.whut.binary.health.api.service.CheckGroupService;
import cn.edu.whut.binary.health.common.entity.PageQueryBean;
import cn.edu.whut.binary.health.common.pojo.CheckGroup;
import cn.edu.whut.binary.health.provider.mapper.CheckGroupMapper;
import cn.edu.whut.binary.health.provider.mapper.CheckItemGroupMapper;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-19 11:24 Tuesday
 */
@Service(interfaceClass = CheckGroupService.class)
@org.springframework.stereotype.Service
public class CheckGroupServiceImpl implements CheckGroupService {
    @Autowired
    private CheckGroupMapper checkGroupMapper;
    @Autowired
    private CheckItemGroupMapper checkItemGroupMapper;

    @Override
    public boolean saveCheckGroup(CheckGroup checkGroup, List<Integer> checkItemIdList) {
        // 检查组保存失败，直接返回 false
        if (checkGroupMapper.saveCheckGroup(checkGroup) != 1) {
            return false;
        }

        // 向检查组与检查项的关系表中批量插入当前检查组所关联的检查项
        if (checkItemIdList != null && checkItemIdList.size() > 0) {
            // 获取自增主键的值
            int checkGroupId = checkGroup.getId();
            // 批量保存检查组对应的检查项（一个检查组对应多个检查项）
            return checkItemGroupMapper.saveCheckItemIdListBatch(checkGroupId, checkItemIdList) > 0;
        }
        return true;
    }

    @Override
    public PageInfo<CheckGroup> getCheckGroupPageData(PageQueryBean pageQueryBean) {
        PageHelper.startPage(pageQueryBean.getCurrentPage(), pageQueryBean.getPageSize());
        List<CheckGroup> CheckGroupList = checkGroupMapper.getCheckGroupByCodeOrNameOrHelpCode(pageQueryBean.getCondition());
        return new PageInfo<>(CheckGroupList, PageQueryBean.PAGE_NUMS);
    }

    @Override
    public boolean deleteCheckGroupById(Integer checkGroupId) {
        return checkGroupMapper.deleteCheckGroupId(checkGroupId) == 1;
    }

    @Override
    public List<Integer> getCheckItemIdsOfCheckGroup(Integer checkGroupId) {
        return checkItemGroupMapper.getCheckItemIdsOfCheckGroup(checkGroupId);
    }

    @Override
    public boolean updateCheckGroup(CheckGroup checkGroup, List<Integer> checkItemIdList) {
        // 更新检查组，更新失败则直接返回 false
        if (checkGroupMapper.updateCheckGroupById(checkGroup) != 1) {
            return false;
        }
        // 删除旧的检查组对应的检查项 ID 集合，忽略返回值
        checkItemGroupMapper.deleteCheckItemsOfCheckGroup(checkGroup.getId());
        // 插入新的检查组所对应检查项 ID 集合
        if (checkItemIdList != null && checkItemIdList.size() > 0) {
            return checkItemGroupMapper.saveCheckItemIdListBatch(checkGroup.getId(), checkItemIdList) > 0;
        }
        return true;
    }
}
