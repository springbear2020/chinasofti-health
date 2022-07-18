package cn.edu.whut.binary.health.backend.controller;

import cn.edu.whut.binary.health.api.service.CheckItemService;
import cn.edu.whut.binary.health.common.constant.MessageConstant;
import cn.edu.whut.binary.health.common.entity.PageQueryBean;
import cn.edu.whut.binary.health.common.entity.Response;
import cn.edu.whut.binary.health.common.pojo.CheckItem;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;


/**
 * @author Spring-_-Bear
 * @datetime 2022-07-16 18:03 Saturday
 */
@RestController
public class CheckItemController {
    @Reference
    private CheckItemService checkItemService;

    @PostMapping("/checkItem.do")
    public Response saveCheckItem(@RequestBody CheckItem checkItem) {
        if (checkItemService.saveCheckItem(checkItem)) {
            return Response.success(MessageConstant.ADD_CHECK_ITEM_SUCCESS);
        }
        return Response.error(MessageConstant.ADD_CHECK_ITEM_FAIL);
    }

    @GetMapping("/checkItem.do")
    public Response getCheckItemPageData(PageQueryBean pageQueryBean) {
        if (pageQueryBean == null) {
            return Response.warn(MessageConstant.PARAMETERS_NEEDED);
        }
        PageInfo<CheckItem> checkItemPageData = checkItemService.getCheckItemPageData(pageQueryBean);
        if (checkItemPageData == null || checkItemPageData.getList() == null || checkItemPageData.getList().size() == 0) {
            return Response.info(MessageConstant.QUERY_CHECK_ITEM_NO_DATA);
        }
        return Response.success(MessageConstant.QUERY_CHECK_ITEM_SUCCESS).put("pageData", checkItemPageData);
    }

    @DeleteMapping("/checkItem.do")
    public Response deleteCheckItem(@RequestParam Integer checkItemId) {
        try {
            if (checkItemService.deleteCheckItemById(checkItemId)) {
                return Response.success(MessageConstant.DELETE_CHECK_ITEM_SUCCESS);
            }
        } catch (Exception e) {
            // 检查项与检查组存在关联关系，不能删除检查项
            return Response.error(e.getMessage());
        }
        return Response.error(MessageConstant.DELETE_CHECK_ITEM_FAIL);
    }

    @GetMapping("/checkItem/{checkItemId}.do")
    public Response getOneCheckItem(@PathVariable("checkItemId") Integer checkItemId) {
        CheckItem checkItem = checkItemService.getCheckItemById(checkItemId);
        if (checkItem == null) {
            return Response.info(MessageConstant.QUERY_CHECK_ITEM_NO_DATA);
        }
        return Response.success(MessageConstant.QUERY_CHECK_ITEM_SUCCESS).put("checkItem", checkItem);
    }

    @PutMapping("/checkItem.do")
    public Response updateCheckItem(CheckItem checkItem) {
        if (checkItem.getId() == null) {
            return Response.warn(MessageConstant.PARAMETERS_NEEDED);
        }
        if (checkItemService.updateCheckItemById(checkItem)) {
            return Response.success(MessageConstant.EDIT_CHECK_ITEM_SUCCESS);
        }
        return Response.error(MessageConstant.EDIT_CHECK_ITEM_FAIL);
    }
}