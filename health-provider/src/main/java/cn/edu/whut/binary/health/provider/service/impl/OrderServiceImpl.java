package cn.edu.whut.binary.health.provider.service.impl;

import cn.edu.whut.binary.health.api.service.OrderService;
import cn.edu.whut.binary.health.common.pojo.Order;
import cn.edu.whut.binary.health.provider.mapper.OrderMapper;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Spring-_-Bear
 * @datetime 2022-08-01 11:45 Monday
 */
@Service(interfaceClass = OrderService.class)
@org.springframework.stereotype.Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order getOrderOfMemberByDateAndSetMealId(Order order) {
        return orderMapper.getOrderOfMemberByDateAndSetMealId(order);
    }

    @Override
    public boolean saveOrder(Order order) {
        return orderMapper.saveOrder(order) == 1;
    }
}
