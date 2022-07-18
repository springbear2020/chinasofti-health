package cn.edu.whut.binary.health.provider.service.impl;

import cn.edu.whut.binary.health.api.service.CheckItemService;
import cn.edu.whut.binary.health.common.constant.MessageConstant;
import cn.edu.whut.binary.health.common.entity.PageQueryBean;
import cn.edu.whut.binary.health.common.pojo.CheckItem;
import cn.edu.whut.binary.health.provider.mapper.CheckItemMapper;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-16 17:40 Saturday
 */
@Service(interfaceClass = CheckItemService.class)
@org.springframework.stereotype.Service
public class CheckItemServiceImpl implements CheckItemService {
    @Autowired
    private CheckItemMapper checkItemMapper;

    @Override
    public boolean saveCheckItem(CheckItem checkItem) {
        return this.checkItemMapper.saveCheckItem(checkItem) == 1;
    }

    @Override
    public PageInfo<CheckItem> getCheckItemPageData(PageQueryBean pageQueryBean) {
        PageHelper.startPage(pageQueryBean.getCurrentPage(), pageQueryBean.getPageSize());
        List<CheckItem> checkItemList = checkItemMapper.getCheckItemByCodeOrName(pageQueryBean.getCondition());
        return new PageInfo<>(checkItemList, PageQueryBean.PAGE_NUMS);
    }

    @Override
    public boolean deleteCheckItemById(Integer checkItemId) {
        // 检查当前检查项与检查组的关联关系，若存在关联则当前检查项不能删除
        if (checkItemMapper.getCheckGroupNumsByCheckItem(checkItemId) > 0) {
            throw new RuntimeException(MessageConstant.CHECK_ITEM_GROUP_RELATION_EXISTS);
        }
        return checkItemMapper.deleteCheckItemById(checkItemId) == 1;
    }

    @Override
    public CheckItem getCheckItemById(Integer checkItemId) {
        return checkItemMapper.getCheckItemById(checkItemId);
    }

    @Override
    public boolean updateCheckItemById(CheckItem checkItem) {
        return checkItemMapper.updateCheckItemById(checkItem) == 1;
    }
}
