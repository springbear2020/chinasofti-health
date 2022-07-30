package cn.edu.whut.binary.health.provider.mapper;

import cn.edu.whut.binary.health.common.pojo.CheckGroup;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
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
     * 根据套餐 ID 查询其对应的检查组 ID 集合（一个套餐对应多个检查组）
     *
     * @return 套餐对应的检查组的 ID 集合
     */
    @Select("select checkgroup_id from t_setmeal_checkgroup where setmeal_id = #{setMealId}")
    List<Integer> getCheckGroupIdsOfSetMeal(@Param("setMealId") Integer setMealId);

    /**
     * 删除套餐所关联的检查组
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

    /**
     * 查询套餐下所有的检查组信息（一个套餐对应多个检查组）
     */
    @Select("select * from t_checkgroup where id in (select  checkgroup_id from t_setmeal_checkgroup where setmeal_id = #{setMealId})")
    List<CheckGroup> getCheckGroupsOfSetMeal(@Param("setMealId") Integer setMealId);

    /**
     * 查询套餐下所有的检查组，并获取检查组关联的检查项信息（一个套餐对应多个检查组、一个检查组对应多个检查项）
     */
    @Select("select * from t_checkgroup where id in (select checkgroup_id from t_setmeal_checkgroup where setmeal_id = #{setMealId})")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "checkItems", javaType = List.class, column = "id", many = @Many(select = "cn.edu.whut.binary.health.provider.mapper.CheckItemGroupMapper.getCheckItemsOfCheckGroup", fetchType = FetchType.LAZY))
    })
    List<CheckGroup> getCheckGroupsDetails(@Param("setMealId") Integer setMealId);
}
