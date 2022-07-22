package cn.edu.whut.binary.health.backend.controller;

import cn.edu.whut.binary.health.api.service.SetMealService;
import cn.edu.whut.binary.health.common.constant.MessageConstant;
import cn.edu.whut.binary.health.common.entity.PageQueryBean;
import cn.edu.whut.binary.health.common.entity.Response;
import cn.edu.whut.binary.health.common.pojo.CheckGroup;
import cn.edu.whut.binary.health.common.pojo.SetMeal;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-22 08:53 Friday
 */
@RestController
public class SetMealController {
    @Reference
    private SetMealService setMealService;

    @GetMapping("/setMeal.do")
    public Response getSetMealPageData(@RequestParam Integer currentPage, @RequestParam Integer pageSize, String condition) {
        PageQueryBean pageQueryBean = new PageQueryBean(currentPage, pageSize, condition);
        PageInfo<SetMeal> setMealPageData = setMealService.getSetMealPageData(pageQueryBean);
        if (setMealPageData == null || setMealPageData.getList() == null || setMealPageData.getList().size() == 0) {
            return Response.info(MessageConstant.QUERY_SETMEAL_FAIL);
        }
        return Response.success(MessageConstant.QUERY_CHECK_GROUP_SUCCESS).put("pageData", setMealPageData);
    }

    /**
     * 保存套餐，并维护套餐与检查组的多对多关系
     */
    @PostMapping("/setMeal.do")
    public Response saveSetMeal(SetMeal setMeal, @RequestBody Integer[] checkGroupIds) {
        if (setMealService.saveSetMeal(setMeal, Arrays.asList(checkGroupIds))) {
            return Response.success(MessageConstant.ADD_SETMEAL_SUCCESS);
        }
        return Response.error(MessageConstant.ADD_SETMEAL_FAIL);
    }

    @DeleteMapping("/setMeal.do")
    public Response deleteSetMeal(@RequestParam Integer setMealId) {
        if (setMealService.deleteSetMealById(setMealId)) {
            return Response.success(MessageConstant.DELETE_SETMEAL_SUCCESS);
        }
        return Response.error(MessageConstant.DELETE_SETMEAL_FAIL);
    }

    /**
     * 根据套餐 ID 查询其对应的检查组信息（一个套餐对应多个检查组）
     */
    @GetMapping("/setMeal/{setMealId}.do")
    public Response getCheckItemIdsOfCheckGroup(@PathVariable("setMealId") Integer setMealId) {
        List<Integer> checkGroupIdList = setMealService.getCheckGroupIdsOfSetMeal(setMealId);
        if (checkGroupIdList == null || checkGroupIdList.size() == 0) {
            return Response.info(MessageConstant.QUERY_CHECK_GROUP_OF_SET_MAIL_FAIL);
        }
        return Response.success(MessageConstant.QUERY_CHECK_GROUP_OF_SET_MAIL_SUCCESS).put("list", checkGroupIdList);
    }

    /**
     * 更新套餐信息，并更新套餐所对应的检查组关系
     *
     * @param setMeal       新的套餐信息
     * @param checkGroupIds 新套餐所对应的新检查组的 ID 数组
     */
    @PutMapping("/setMeal.do")
    public Response updateSetMeal(SetMeal setMeal, @RequestBody Integer[] checkGroupIds) {
        if (setMealService.updateSetMeal(setMeal, Arrays.asList(checkGroupIds))) {
            return Response.success(MessageConstant.EDIT_CHECK_GROUP_SUCCESS);
        }
        return Response.error(MessageConstant.EDIT_CHECK_GROUP_FAIL);
    }
}
