package cn.edu.whut.binary.health.api.service;

import cn.edu.whut.binary.health.common.pojo.Order;

/**
 * @author Spring-_-Bear
 * @datetime 2022-08-01 11:44 Monday
 */
public interface OrderService {
    /**
     * 根据日期、会员 ID、套餐 ID 查询预约数据
     */
    Order getOrderOfMemberByDateAndSetMealId(Order order);

    /**
     * 保存预约记录
     */
    boolean saveOrder(Order order);
}
