package cn.edu.whut.binary.health.provider.mapper;

import cn.edu.whut.binary.health.common.pojo.CheckGroup;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-19 11:13 Tuesday
 */
@Repository
public interface CheckGroupMapper {

    /**
     * 保存检查组
     *
     * @return 1 - 保存成功
     */
    @Insert("insert into t_checkgroup(id, code, name, helpCode, sex, remark, attention) values (null,#{code},#{name},#{helpCode},#{sex},#{remark},#{attention})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    int saveCheckGroup(CheckGroup checkGroup);

    /**
     * 根据检查组编码、名称或助记码查询检查组信息，如果条件为 null 或者为空串 "" 则查询所有数据
     */
    List<CheckGroup> getCheckGroupByCodeOrNameOrHelpCode(@Param("condition") String condition);

    /**
     * 通过 ID 删除检查组
     *
     * @return 1 - 删除成功
     */
    @Delete("delete from t_checkgroup where id = #{checkGroupId}")
    int deleteCheckGroupId(@Param("checkGroupId") Integer checkGroupId);

    /**
     * 根据 ID 更新检查组
     *
     * @return 1 - 更新成功
     */
    int updateCheckGroupById(CheckGroup checkGroup);

    /**
     * 查询所有检查组
     */
    @Select("select * from t_checkgroup")
    List<CheckGroup> getAllCheckGroups();

    /**
     * 根据检查组 ID 查询其对应的套餐数量
     *
     * @return 当前检查组关联的套餐的数量
     */
    @Select("select count(*) from t_setmeal_checkgroup where checkgroup_id = #{checkGroupId}")
    int getCheckGroupNumsOfSetMeal(@Param("checkGroupId") Integer checkGroupId);
}
