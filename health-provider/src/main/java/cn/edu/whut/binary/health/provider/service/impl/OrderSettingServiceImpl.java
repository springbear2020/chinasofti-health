package cn.edu.whut.binary.health.provider.service.impl;

import cn.edu.whut.binary.health.api.service.OrderSettingService;
import cn.edu.whut.binary.health.common.pojo.OrderSetting;
import cn.edu.whut.binary.health.provider.mapper.OrderSettingMapper;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-23 09:19 Saturday
 */
@Service(interfaceClass = OrderSettingService.class)
@org.springframework.stereotype.Service
public class OrderSettingServiceImpl implements OrderSettingService {
    @Autowired
    private OrderSettingMapper orderSettingMapper;

    @Override
    public List<OrderSetting> getOrderSettingByYearAndMonth(Date specifiedDate) {
        return orderSettingMapper.getOrderSettingByYearAndMonth(specifiedDate);
    }

    @Override
    public boolean saveOrderSetting(OrderSetting orderSetting) {
        return orderSettingMapper.saveOrUpdateOrderSetting(orderSetting) > 0;
    }
}
