package cn.edu.whut.binary.health.provider.mapper;

import cn.edu.whut.binary.health.common.pojo.OrderSetting;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-23 09:20 Saturday
 */
@Repository
public interface OrderSettingMapper {
    /**
     * 获取指定年、指定月的预约设置数据
     */
    @Select("SELECT * FROM `t_ordersetting` WHERE DATE_FORMAT(orderDate,'%Y-%m') = DATE_FORMAT(#{specifiedDate},'%Y-%m')")
    List<OrderSetting> getOrderSettingByYearAndMonth(@Param("specifiedDate") Date specifiedDate);

    /**
     * 保存预约设置
     */
    @Insert("insert into t_ordersetting(orderDate, number, reservations) VALUES (#{orderDate},#{number},#{reservations})")
    int saveOrderSetting(OrderSetting orderSetting);
}
