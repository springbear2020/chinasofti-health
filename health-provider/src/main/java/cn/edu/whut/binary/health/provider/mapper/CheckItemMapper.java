package cn.edu.whut.binary.health.provider.mapper;

import cn.edu.whut.binary.health.common.pojo.CheckItem;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

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
}
