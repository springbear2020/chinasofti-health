package cn.edu.whut.binary.health.provider.service.impl;

import cn.edu.whut.binary.health.api.service.SetMealService;
import cn.edu.whut.binary.health.common.entity.PageQueryBean;
import cn.edu.whut.binary.health.common.pojo.SetMeal;
import cn.edu.whut.binary.health.provider.mapper.SetMealCheckGroupMapper;
import cn.edu.whut.binary.health.provider.mapper.SetMealMapper;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-22 09:00 Friday
 */
@Service(interfaceClass = SetMealService.class)
@org.springframework.stereotype.Service
public class SetMealServiceImpl implements SetMealService {
    @Autowired
    private SetMealMapper setMealMapper;
    @Autowired
    private SetMealCheckGroupMapper setMealCheckGroupMapper;

    @Override
    public PageInfo<SetMeal> getSetMealPageData(PageQueryBean pageQueryBean) {
        PageHelper.startPage(pageQueryBean.getCurrentPage(), pageQueryBean.getPageSize());
        List<SetMeal> setMealList = setMealMapper.getSetMealByCodeOrNameOrHelpCode(pageQueryBean.getCondition());
        return new PageInfo<>(setMealList, PageQueryBean.PAGE_NUMS);
    }

    @Override
    public boolean saveSetMeal(SetMeal setMeal, List<Integer> checkGroupIdList) {
        // 套餐保存失败，直接返回 false
        if (setMealMapper.saveSetMeal(setMeal) != 1) {
            return false;
        }

        // 向套餐与检查组的关系表中批量插入当前套餐所关联的检查组
        if (checkGroupIdList != null && checkGroupIdList.size() > 0) {
            // 获取自增主键的值
            int setMealId = setMeal.getId();
            // 批量保存套餐对应的检查组（一个套餐对应多个检查组）
            return setMealCheckGroupMapper.saveCheckGroupIdListBatch(setMealId, checkGroupIdList) > 0;
        }
        return false;
    }

    @Override
    public boolean deleteSetMealById(Integer setMealId) {
        // 删除套餐信息，删除失败直接返回 false
        if (setMealMapper.deleteSetMealId(setMealId) != 1) {
            return false;
        }
        // 删除套餐对应的检查组关联信息
        setMealCheckGroupMapper.deleteCheckGroupsOfSetMeal(setMealId);
        return true;
    }

    @Override
    public List<Integer> getCheckGroupIdsOfSetMeal(Integer setMealId) {
        return setMealCheckGroupMapper.getCheckGroupIdsOfSetMeal(setMealId);
    }

    @Override
    public boolean updateSetMeal(SetMeal setMeal, List<Integer> checkGroupIdList) {
        // 更新套餐，更新失败则直接返回 false
        if (setMealMapper.updateSetMealById(setMeal) != 1) {
            return false;
        }
        // 删除旧的套餐对应的检查组 ID 集合，忽略返回值
        setMealCheckGroupMapper.deleteCheckGroupsOfSetMeal(setMeal.getId());
        // 插入新的套餐所对应检查组 ID 集合
        if (checkGroupIdList != null && checkGroupIdList.size() > 0) {
            return setMealCheckGroupMapper.saveCheckGroupIdListBatch(setMeal.getId(), checkGroupIdList) > 0;
        }
        return false;
    }
}
