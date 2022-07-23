package cn.edu.whut.binary.health.backend.controller;

import cn.edu.whut.binary.health.api.service.OrderSettingService;
import cn.edu.whut.binary.health.common.constant.MessageConstant;
import cn.edu.whut.binary.health.common.entity.Response;
import cn.edu.whut.binary.health.common.pojo.OrderSetting;
import cn.edu.whut.binary.health.common.util.DateUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/orderSetting/{dateStr}.do")
    public Response getOrderSettingData(@PathVariable("dateStr") String dateStr) {
        // 客户端指定年、指定月的预约设置数据。请求参数有错则默认查询当前年、当前月的数据
        List<OrderSetting> orderSettingList = orderSettingService.getOrderSettingByYearAndMonth(DateUtils.parseStringWithHyphen(dateStr, new Date()));
        if (orderSettingList == null || orderSettingList.size() == 0) {
            return Response.error(MessageConstant.QUERY_ORDER_FAIL);
        }
        return Response.success(MessageConstant.QUERY_ORDER_SUCCESS).put("list", orderSettingList);
    }
}
