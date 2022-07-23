package cn.edu.whut.binary.health.provider.mapper;

import cn.edu.whut.binary.health.common.pojo.OrderSetting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;


/**
 * @author Spring-_-Bear
 * @datetime 2022-07-23 09:20 Saturday
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OrderSettingMapperTest {
    @Autowired
    private OrderSettingMapper orderSettingMapper;

    @Test
    public void getOrderSettingByYearAndMonth() {
        List<OrderSetting> orderSettingList = orderSettingMapper.getOrderSettingByYearAndMonth(new Date());
        orderSettingList.forEach(System.out::println);
    }
}