package cn.edu.whut.binary.health.provider.service.impl;

import cn.edu.whut.binary.health.api.service.OrderSettingService;
import cn.edu.whut.binary.health.common.poi.Converter;
import cn.edu.whut.binary.health.common.poi.SheetBeanConverter;
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

    @Override
    public boolean saveOrUpdateOrderSettingFromExcel(String excelFileFullPath) {
        try {
            // 使用自定义的 jar 包实现 Excel 行数据转换为 Java 对象
            Converter converter = new SheetBeanConverter(excelFileFullPath);
            List<OrderSetting> orderSettingList = converter.excelConvertBean(OrderSetting.class);
            // 逐条数据插入或更新到数据表中
            for (OrderSetting orderSetting : orderSettingList) {
                orderSettingMapper.saveOrUpdateOrderSetting(orderSetting);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
