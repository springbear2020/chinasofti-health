package cn.edu.whut.binary.health.provider.mapper;

import cn.edu.whut.binary.health.common.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @author Spring-_-Bear
 * @datetime 2022-08-01 11:37 Monday
 */
public interface OrderMapper {
    /**
     * 根据日期、会员 ID、套餐 ID 查询预约数据
     */
    @Select("select * from t_order where member_id = #{memberId} and setmeal_id = #{setmealId} and DATE_FORMAT(orderDate,'%Y-%m-%d') = DATE_FORMAT(orderDate,'%Y-%m-%d')")
    Order getOrderOfMemberByDateAndSetMealId(Order order);

    /**
     * 保存预约记录
     */
    @Insert("insert into t_order(member_id, orderDate, orderType, orderStatus, setmeal_id) values (#{memberId},#{orderDate},#{orderType},#{orderStatus},#{setmealId})")
    int saveOrder(Order order);
}
