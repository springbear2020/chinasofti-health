package cn.edu.whut.binary.health.backend.controller;

import cn.edu.whut.binary.health.api.service.OrderSettingService;
import cn.edu.whut.binary.health.common.constant.MessageConstant;
import cn.edu.whut.binary.health.common.entity.Response;
import cn.edu.whut.binary.health.common.pojo.OrderSetting;
import cn.edu.whut.binary.health.common.util.DateUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
     * 获取指定年、指定月的预约设置数据
     */
    @GetMapping("/orderSetting.do")
    public Response getOrderSettingData(@RequestParam("dateStr") String dateStr) {
        Date specifiedDate;
        try {
            // 客户端指定年、指定月的预约设置数据。请求参数有错则默认查询当前年、当前月的数据
            specifiedDate = DateUtils.parseStringWithHyphen(dateStr);
        } catch (ParseException e) {
            return Response.error(MessageConstant.QUERY_ORDER_FAIL);
        }
        List<OrderSetting> orderSettingList = orderSettingService.getOrderSettingByYearAndMonth(specifiedDate);
        if (orderSettingList == null || orderSettingList.size() == 0) {
            return Response.error(MessageConstant.QUERY_ORDER_FAIL);
        }
        return Response.success(MessageConstant.QUERY_ORDER_SUCCESS).put("list", orderSettingList);
    }

    @PostMapping("/orderSetting.do")
    public Response saveOrderSetting(@RequestParam("dateStr") String dateStr, @RequestParam("number") Integer number) {
        Date specifiedDate;
        try {
            // 解析前端传来的时间字符串
            specifiedDate = DateUtils.parseStringWithHyphen(dateStr);
        } catch (ParseException e) {
            return Response.error(MessageConstant.ORDER_SETTING_FAIL);
        }
        OrderSetting orderSetting = new OrderSetting(specifiedDate, number);
        // 已预约人数设置为 0
        orderSetting.setReservations(0);
        if (orderSettingService.saveOrderSetting(orderSetting)) {
            return Response.success(MessageConstant.ORDER_SETTING_SUCCESS);
        }
        return Response.error(MessageConstant.ORDER_SETTING_FAIL);
    }
}
