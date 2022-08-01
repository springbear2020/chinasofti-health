package cn.edu.whut.binary.health.provider.mapper;

import cn.edu.whut.binary.health.common.pojo.Order;
import cn.edu.whut.binary.health.common.util.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Spring-_-Bear
 * @datetime 2022-08-01 11:40 Monday
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OrderMapperTest {
    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void getOrderOfMemberByDateAndSetMealId() {
        Order order = new Order();
        order.setMemberId(82);
        order.setOrderDate(DateUtils.parseStringWithHyphen("2019-03-11"));
        order.setSetmealId(7);
        System.out.println(orderMapper.getOrderOfMemberByDateAndSetMealId(order));
    }

    @Test
    public void saveOrder() {
        Order order = new Order();
        order.setMemberId(82);
        order.setOrderDate(DateUtils.parseStringWithHyphen("2019-03-11"));
        order.setSetmealId(7);
        order.setOrderType(Order.ORDER_TYPE_TELEPHONE);
        order.setOrderStatus(Order.ORDER_STATUS_NO);
        System.out.println(orderMapper.saveOrder(order));
    }
}
