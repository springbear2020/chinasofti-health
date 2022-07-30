package cn.edu.whut.binary.health.backend.controller;

import cn.edu.whut.binary.health.api.service.OrderSettingService;
import cn.edu.whut.binary.health.common.constant.MessageConstant;
import cn.edu.whut.binary.health.common.entity.Response;
import cn.edu.whut.binary.health.common.pojo.OrderSetting;
import cn.edu.whut.binary.health.common.util.DateUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-23 09:13 Saturday
 */
@RestController
public class OrderSettingController {
    @Reference
    private OrderSettingService orderSettingService;

    /**
     * 获取指定年、月的预约设置数据
     */
    @GetMapping("/orderSetting.do")
    public Response getOrderSettingData(@RequestParam("dateStr") String dateStr) {
        Date specifiedDate = DateUtils.parseStringWithHyphen(dateStr);
        if (specifiedDate == null) {
            return Response.error(MessageConstant.GET_ORDER_SETTING_FAIL);
        }
        List<OrderSetting> orderSettingList = orderSettingService.getOrderSettingByYearAndMonth(specifiedDate);
        if (orderSettingList == null || orderSettingList.size() == 0) {
            return Response.error(MessageConstant.GET_ORDER_SETTING_FAIL);
        }
        return Response.success(MessageConstant.GET_ORDER_SETTING_SUCCESS).put("list", orderSettingList);
    }

    /**
     * 获取指定年、月、日的预约设置数据
     */
    @GetMapping("/orderSetting/{dateStr}.do")
    public Response getOrderSetting(@PathVariable("dateStr") String dateStr) {
        Date date = DateUtils.parseStringWithHyphen(dateStr);
        if (date == null) {
            return Response.error(MessageConstant.ORDER_SETTING_FAIL);
        }
        OrderSetting orderSetting = orderSettingService.getOrderSettingByDate(date);
        if (orderSetting == null) {
            return Response.error(MessageConstant.ORDER_SETTING_FAIL);
        }
        return Response.success(MessageConstant.ORDER_SETTING_SUCCESS).put("item", orderSetting);
    }

    /**
     * 更新预约设置
     */
    @PutMapping("/orderSetting.do")
    public Response updateOrderSetting(@RequestParam("reservations") Integer reservations, @RequestParam("dateStr") String dateStr) {
        Date date = DateUtils.parseStringWithHyphen(dateStr);
        if (date == null) {
            return Response.error(MessageConstant.ORDER_SETTING_FAIL);
        }
        OrderSetting orderSetting = new OrderSetting();
        orderSetting.setReservations(reservations);
        orderSetting.setOrderDate(date);
        if (orderSettingService.updateOrderSettingByDate(orderSetting)) {
            return Response.success(MessageConstant.ORDER_SETTING_SUCCESS);
        }
        return Response.success(MessageConstant.ORDER_SETTING_FAIL);
    }
}
