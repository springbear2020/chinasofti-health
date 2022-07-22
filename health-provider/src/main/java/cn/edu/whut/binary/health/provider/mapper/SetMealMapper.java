package cn.edu.whut.binary.health.provider.mapper;

import cn.edu.whut.binary.health.common.pojo.SetMeal;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
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
}
