package cn.edu.whut.binary.health.api.service;

import cn.edu.whut.binary.health.common.pojo.OrderSetting;

import java.util.Date;
import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-23 09:15 Saturday
 */
public interface OrderSettingService {
    /**
     * 获取指定年、指定月的预约设置数据
     */
    List<OrderSetting> getOrderSettingByYearAndMonth(Date specifiedDate);

    /**
     * 保存预约设置
     */
    boolean saveOrderSetting(OrderSetting orderSetting);
}
