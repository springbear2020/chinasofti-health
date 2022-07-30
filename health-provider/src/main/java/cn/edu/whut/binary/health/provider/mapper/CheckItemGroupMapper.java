package cn.edu.whut.binary.health.provider.mapper;

import cn.edu.whut.binary.health.common.pojo.CheckItem;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 检查组与检查项（多对多）
 *
 * @author Spring-_-Bear
 * @datetime 2022-07-19 11:36 Tuesday
 */
@Repository
public interface CheckItemGroupMapper {
    /**
     * 批量保存检查项 ID（一个检查组对应多个检查项）
     *
     * @param checkGroupId    检查组 ID
     * @param checkItemIdList 检查项 ID 列表
     * @return 新增加的行数
     */
    int saveCheckItemIdListBatch(@Param("checkGroupId") Integer checkGroupId, @Param("checkItemIdList") List<Integer> checkItemIdList);

    /**
     * 删除检查组所对应的检查项
     */
    @Delete("delete from t_checkgroup_checkitem where checkgroup_id = #{checkGroupId}")
    void deleteCheckItemsOfCheckGroup(@Param("checkGroupId") Integer checkGroupId);

    /**
     * 根据检查组 ID 查询其对应的检查项 ID 集合（一个检查组对应多个检查项）
     *
     * @return 检查组对应的检查项的 ID 集合
     */
    @Select("select checkitem_id from t_checkgroup_checkitem where checkgroup_id = #{checkGroupId}")
    List<Integer> getCheckItemIdsOfCheckGroup(@Param("checkGroupId") Integer checkGroupId);

    /**
     * 根据检查项 ID 查询其对应的检查组数量
     *
     * @return 当前检查项关联的检查组的数量
     */
    @Select("select count(*) from t_checkgroup_checkitem where checkitem_id = #{checkItemId}")
    int getCheckGroupNumsByCheckItem(@Param("checkItemId") Integer checkItemId);

    /**
     * 查询检查组下的所有检查项信息（一个检查组对应多个检查项）
     */
    @Select("select * from t_checkitem where id in (select checkitem_id from t_checkgroup_checkitem where checkgroup_id = #{checkGroupId})")
    List<CheckItem> getCheckItemsOfCheckGroup(@Param("checkGroupId") Integer checkGroupId);
}
