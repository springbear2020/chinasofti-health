package cn.edu.whut.binary.health.mobile.controller;

import cn.edu.whut.binary.health.api.service.SetMealService;
import cn.edu.whut.binary.health.common.constant.MessageConstant;
import cn.edu.whut.binary.health.common.entity.Response;
import cn.edu.whut.binary.health.common.pojo.SetMeal;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-30 17:29 Saturday
 */
@RestController
public class SetMealController {
    @Reference
    private SetMealService setMealService;

    /**
     * 获取所有套餐
     */
    @GetMapping("/setMeal.do")
    public Response getAllSetMeals() {
        List<SetMeal> setMealList = setMealService.getAllSetMeals();
        if (setMealList == null || setMealList.size() == 0) {
            return Response.error(MessageConstant.QUERY_SETMEAL_LIST_FAIL);
        }
        return Response.success(MessageConstant.QUERY_SETMEAL_LIST_SUCCESS).put("list", setMealList);
    }

    /**
     * 查询套餐详情：一个套餐包含多个检查组，一个检查组包含多个检查项
     */
    @GetMapping("/setMeal/{setMealId}.do")
    public Response getSetMealDetails(@PathVariable("setMealId") Integer setMealId) {
        SetMeal setMeal = setMealService.getSetMealDetails(setMealId);
        if (setMeal == null) {
            return Response.error(MessageConstant.QUERY_SETMEAL_FAIL);
        }
        return Response.success(MessageConstant.QUERY_SETMEAL_SUCCESS).put("item", setMeal);
    }
}
