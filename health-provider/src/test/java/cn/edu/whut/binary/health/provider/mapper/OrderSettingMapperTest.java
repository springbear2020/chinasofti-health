package cn.edu.whut.binary.health.provider.mapper;

import cn.edu.whut.binary.health.common.pojo.OrderSetting;
import cn.edu.whut.binary.health.common.util.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
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

    @Test
    public void getOrderSettingByDate() throws ParseException {
        System.out.println(orderSettingMapper.getOrderSettingByDate(DateUtils.parseStringWithHyphen("2019-03-20")));
    }

    @Test
    public void updateOrderSettingByDate() throws ParseException {
        OrderSetting orderSetting = new OrderSetting();
        orderSetting.setOrderDate(DateUtils.parseStringWithHyphen("2022-07-08"));
        orderSetting.setNumber(200);
        orderSetting.setReservations(200);
        System.out.println(orderSettingMapper.updateOrderSettingByDate(orderSetting));
    }
}