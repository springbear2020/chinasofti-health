package cn.edu.whut.binary.health.provider.mapper;

import cn.edu.whut.binary.health.common.pojo.CheckGroup;
import cn.edu.whut.binary.health.common.pojo.SetMeal;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-22 08:55 Friday
 */
@Repository
public interface SetMealMapper {
    /**
     * 根据套餐编码、名称或助记码查询检查组信息，如果条件为 null 或者为空串 "" 则查询所有数据
     */
    List<SetMeal> getSetMealByCodeOrNameOrHelpCode(@Param("condition") String condition);

    /**
     * 保存套餐，并返回自增主键
     */
    @Insert("insert into t_setmeal(id, name, code, helpCode, sex, age, price, remark, attention, img) " +
            "values (null,#{name},#{code},#{helpCode},#{sex},#{age},#{price},#{remark},#{attention},#{img})")
    @Options(useGeneratedKeys = true, keyColumn = "id")
    int saveSetMeal(SetMeal setMeal);

    /**
     * 通过 ID 删除套餐
     *
     * @return 1 - 删除成功
     */
    @Delete("delete from t_setmeal where id = #{setMealId}")
    int deleteSetMealId(@Param("setMealId") Integer setMealId);

    /**
     * 根据 ID 更新套餐
     *
     * @return 1 - 更新成功
     */
    int updateSetMealById(SetMeal setMeal);

    /**
     * 查询所有套餐
     */
    @Select("select * from t_setmeal")
    List<SetMeal> getAllSetMeals();

    /**
     * 根据 ID 查询套餐
     */
    @Select("select * from t_setmeal where id = #{setMealId}")
    SetMeal getSetMealById(@Param("setMealId") Integer setMealId);

    /**
     * 查询套餐详情（包含套餐下的检查组、检查组下的检查项）
     */
    @Select("select * from t_setmeal where  id = #{setMealId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "checkGroups", javaType = List.class, column = "id", many = @Many(select = "cn.edu.whut.binary.health.provider.mapper.SetMealCheckGroupMapper.getCheckGroupsDetails", fetchType = FetchType.LAZY))
    })
    SetMeal getSetMealDetails(@Param("setMealId") Integer setMealId);
}
