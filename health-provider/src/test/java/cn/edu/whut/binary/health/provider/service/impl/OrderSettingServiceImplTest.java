package cn.edu.whut.binary.health.provider.service.impl;

import cn.edu.whut.binary.health.api.service.OrderSettingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author Spring-_-Bear
 * @datetime 2022-07-27 11:51 Wednesday
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OrderSettingServiceImplTest {
    @Autowired
    private OrderSettingService orderSettingService;

    @Test
    public void saveOrUpdateOrderSettingFromExcel() {
        System.out.println(orderSettingService.saveOrUpdateOrderSettingFromExcel("C:/Users/Admin/Desktop/order_setting.xlsx"));
    }
}