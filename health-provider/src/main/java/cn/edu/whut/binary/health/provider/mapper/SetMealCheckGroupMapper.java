package cn.edu.whut.binary.health.provider.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-22 10:45 Friday
 */
@Repository
public interface SetMealCheckGroupMapper {
    /**
     * 批量插入检查组 ID（一个套餐对应多个检查组）
     *
     * @param setMealId        套餐 ID
     * @param checkGroupIdList 检查组 ID 列表
     * @return 新增加的行数
     */
    int saveCheckGroupIdListBatch(@Param("setMealId") Integer setMealId, @Param("checkGroupIdList") List<Integer> checkGroupIdList);

    /**
     * 根据套餐 ID 查询其对应的检查组信息（一个套餐对应多个检查组）
     *
     * @return 套餐对应的检查组的 ID 集合
     */
    @Select("select checkgroup_id from t_setmeal_checkgroup where setmeal_id = #{setMealId}")
    List<Integer> getCheckGroupIdsOfSetMeal(@Param("setMealId") Integer setMealId);

    /**
     * 删除套餐所对应的检查组
     */
    @Delete("delete from t_setmeal_checkgroup where setmeal_id = #{setMealId}")
    void deleteCheckGroupsOfSetMeal(@Param("setMealId") Integer setMealId);

    /**
     * 根据检查组 ID 查询其对应的套餐数量
     *
     * @return 当前检查组关联的套餐的数量
     */
    @Select("select count(*) from t_setmeal_checkgroup where checkgroup_id = #{checkGroupId}")
    int getCheckGroupNumsOfSetMeal(@Param("checkGroupId") Integer checkGroupId);
}
