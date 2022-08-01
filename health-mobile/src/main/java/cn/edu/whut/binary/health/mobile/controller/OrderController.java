package cn.edu.whut.binary.health.mobile.controller;

import cn.edu.whut.binary.health.api.service.*;
import cn.edu.whut.binary.health.common.constant.MessageConstant;
import cn.edu.whut.binary.health.common.entity.Response;
import cn.edu.whut.binary.health.common.pojo.Member;
import cn.edu.whut.binary.health.common.pojo.Order;
import cn.edu.whut.binary.health.common.pojo.OrderSetting;
import cn.edu.whut.binary.health.common.pojo.SetMeal;
import cn.edu.whut.binary.health.common.util.DateUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Spring-_-Bear
 * @datetime 2022-08-01 10:51 Monday
 */
@RestController
public class OrderController {
    @Reference
    private VerifyCodeService verifyCodeService;
    @Reference
    private OrderSettingService orderSettingService;
    @Reference
    private MemberService memberService;
    @Reference
    private OrderService orderService;
    @Reference
    private SetMealService setMealService;

    @PostMapping("/order.do")
    public Response saveOrderInfo(@RequestParam String validateCode, @RequestParam String orderDate, @RequestParam Integer setmealId,
                                  @RequestParam String name, @RequestParam String sex, @RequestParam String telephone, @RequestParam String idCard) {
        // 从 Redis 缓存中获取当前手机号所关联的验证码
        String phoneVerifyCode = verifyCodeService.getPhoneVerifyCode(telephone);
        // 验证码已过期或不存在
        if (phoneVerifyCode == null) {
            return Response.warn(MessageConstant.VALIDATE_CODE_NOT_EXISTS);
        }
        // 用户输入的验证码与缓存中的验证码不匹配
        if (!validateCode.equals(phoneVerifyCode)) {
            return Response.error(MessageConstant.VALIDATE_CODE_ERROR);
        }

        // 查询当前日期下是否已经设置预约数据
        OrderSetting orderSetting = orderSettingService.getOrderSettingByDate(DateUtils.parseStringWithHyphen(orderDate));
        if (orderSetting == null || orderSetting.getNumber() == null || orderSetting.getNumber() <= 0) {
            return Response.warn(MessageConstant.SELECTED_DATE_CANNOT_ORDER);
        }
        // 判断当前日期下已预约人数是否大于可预约人数
        int reservations = orderSetting.getReservations() == null ? 0 : orderSetting.getReservations();
        if (reservations >= orderSetting.getNumber()) {
            return Response.warn(MessageConstant.ORDER_FULL);
        }

        // 根据身份证号是否已注册会员，不是则进行注册
        Member member = memberService.getMemberByIdCard(idCard);
        if (member == null) {
            member = new Member();
            member.setName(name);
            member.setSex(sex);
            member.setPhoneNumber(telephone);
            member.setIdCard(idCard);
            member.setRegTime(new Date());
            // 新增会员
            if (!memberService.saveMember(member)) {
                return Response.error(MessageConstant.ADD_MEMBER_FAIL);
            }
        }

        // 判断会员当前日期、当前套餐是否已经进行了体检预约
        Order order = new Order(member.getId(), DateUtils.parseStringWithHyphen(orderDate), Order.ORDER_TYPE_WECHAT, Order.ORDER_STATUS_NO, setmealId);
        if (orderService.getOrderOfMemberByDateAndSetMealId(order) != null) {
            return Response.info(MessageConstant.HAS_ORDERED);
        }
        // 保存用户的预约记录
        if (!orderService.saveOrder(order)) {
            return Response.error(MessageConstant.ORDER_SAVE_FAIL);
        }
        // 更新已预约人数 +1
        reservations++;
        orderSetting.setReservations(reservations);
        if (!orderSettingService.updateOrderSettingByDate(orderSetting)) {
            return Response.error(MessageConstant.ORDER_SETTING_FAIL);
        }

        // 根据套餐 ID 查询套餐信息
        SetMeal setMeal = setMealService.getSetMealDetails(setmealId);
        return Response.success(MessageConstant.ORDER_SUCCESS).put("name", name).put("setMealName", setMeal.getName())
                .put("orderDate", order.getOrderDate()).put("orderType", order.getOrderType());
    }
}
