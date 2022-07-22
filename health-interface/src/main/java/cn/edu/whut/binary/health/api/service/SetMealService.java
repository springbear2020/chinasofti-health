package cn.edu.whut.binary.health.api.service;

import cn.edu.whut.binary.health.common.entity.PageQueryBean;
import cn.edu.whut.binary.health.common.pojo.SetMeal;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-22 08:53 Friday
 */
public interface SetMealService {
    /**
     * 获取套餐分页数据
     *
     * @param pageQueryBean 分页查询条件，包含了当前页码、每页数量、查询条件
     */
    PageInfo<SetMeal> getSetMealPageData(PageQueryBean pageQueryBean);

    /**
     * 保存套餐，并维护套餐与检查组的多对多关系
     *
     * @param setMeal          套餐
     * @param checkGroupIdList 套餐关联的检查组的 ID
     */
    boolean saveSetMeal(SetMeal setMeal, List<Integer> checkGroupIdList);

    /**
     * 通过 ID 删除套餐
     *
     * @return true - 删除成功
     */
    boolean deleteSetMealById(Integer setMealId);

    /**
     * 根据套餐 ID 查询其对应的检查组信息（一个套餐对应多个检查组）
     *
     * @return 套餐对应的检查组的 ID 集合
     */
    List<Integer> getCheckGroupIdsOfSetMeal(Integer setMealId);

    /**
     * 更新套餐信息，并更新套餐所对应的检查组
     *
     * @param setMeal          新的套餐信息
     * @param checkGroupIdList 新套餐所对应的新检查组的 ID 集合
     * @return true - 更新成功
     */
    boolean updateSetMeal(SetMeal setMeal, List<Integer> checkGroupIdList);
}
