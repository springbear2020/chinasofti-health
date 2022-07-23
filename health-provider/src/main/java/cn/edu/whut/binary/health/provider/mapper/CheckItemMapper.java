package cn.edu.whut.binary.health.provider.mapper;

import cn.edu.whut.binary.health.common.pojo.CheckItem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-16 17:42 Saturday
 */
@Repository
public interface CheckItemMapper {
    /**
     * 保存检查项
     *
     * @return 1 - 保存成功
     */
    @Insert("insert into t_checkitem(code,name,sex,age,price,type,attention,remark) " +
            "values(#{code},#{name},#{sex},#{age},#{price},#{type},#{attention},#{remark})")
    int saveCheckItem(CheckItem checkItem);

    /**
     * 根据检查项代码或条件查询检查项数据，如果条件为 null 或者为空串 "" 则查询所有数据
     *
     * @param condition 查询条件：检查项代号或名称
     */
    List<CheckItem> getCheckItemByCodeOrName(@Param("condition") String condition);

    /**
     * 通过 ID 删除检查项
     *
     * @return 1 - 删除成功
     */
    @Delete("delete from t_checkitem where id = #{checkItemId}")
    int deleteCheckItemById(@Param("checkItemId") Integer checkItemId);

    /**
     * 根据 ID 查询检查项
     */
    @Select("select * from t_checkitem where id = #{checkItemId}")
    CheckItem getCheckItemById(@Param("checkItemId") Integer checkItemId);

    /**
     * 根据 ID 更新检查项
     *
     * @return 1 - 更新成功
     */
    int updateCheckItemById(CheckItem checkItem);

    /**
     * 查询所有检查项
     */
    @Select("select * from t_checkitem")
    List<CheckItem> getAllCheckItems();
}
