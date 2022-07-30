package cn.edu.whut.binary.health.backend.controller;

import cn.edu.whut.binary.health.api.service.CheckItemService;
import cn.edu.whut.binary.health.common.constant.MessageConstant;
import cn.edu.whut.binary.health.common.entity.PageQueryBean;
import cn.edu.whut.binary.health.common.entity.Response;
import cn.edu.whut.binary.health.common.pojo.CheckItem;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Spring-_-Bear
 * @datetime 2022-07-16 18:03 Saturday
 */
@RestController
public class CheckItemController {
    @Reference
    private CheckItemService checkItemService;

    /**
     * 保存检查项
     */
    @PostMapping("/checkItem.do")
    public Response saveCheckItem(@RequestBody CheckItem checkItem) {
        if (checkItemService.saveCheckItem(checkItem)) {
            return Response.success(MessageConstant.ADD_CHECK_ITEM_SUCCESS);
        }
        return Response.error(MessageConstant.ADD_CHECK_ITEM_FAIL);
    }

    /**
     * 删除检查项
     */
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

    /**
     * 更新检查项
     */
    @PutMapping("/checkItem.do")
    public Response updateCheckItem(@RequestBody CheckItem checkItem) {
        if (checkItemService.updateCheckItemById(checkItem)) {
            return Response.success(MessageConstant.EDIT_CHECK_ITEM_SUCCESS);
        }
        return Response.error(MessageConstant.EDIT_CHECK_ITEM_FAIL);
    }

    /**
     * 获取检查项分页数据
     */
    @GetMapping("/checkItem.do")
    public Response getCheckItemPageData(@RequestParam Integer currentPage, @RequestParam Integer pageSize, String condition) {
        PageInfo<CheckItem> checkItemPageData = checkItemService.getCheckItemPageData(new PageQueryBean(currentPage, pageSize, condition));
        if (checkItemPageData == null || checkItemPageData.getList() == null || checkItemPageData.getList().size() == 0) {
            return Response.info(MessageConstant.QUERY_CHECK_ITEM_FAIL);
        }
        return Response.success(MessageConstant.QUERY_CHECK_ITEM_SUCCESS).put("pageData", checkItemPageData);
    }

    /**
     * 获取检查项
     */
    @GetMapping("/checkItem/{checkItemId}.do")
    public Response getCheckItem(@PathVariable("checkItemId") Integer checkItemId) {
        CheckItem checkItem = checkItemService.getCheckItemById(checkItemId);
        if (checkItem == null) {
            return Response.info(MessageConstant.QUERY_CHECK_ITEM_FAIL);
        }
        return Response.success(MessageConstant.QUERY_CHECK_ITEM_SUCCESS).put("item", checkItem);
    }

    /**
     * 获取所有的检查项，提供给检查组新增、编辑时使用
     */
    @GetMapping("/checkItem/all.do")
    public Response getAllCheckItems() {
        List<CheckItem> checkItemList = checkItemService.getAllCheckItems();
        if (checkItemList == null || checkItemList.size() == 0) {
            return Response.info(MessageConstant.QUERY_CHECK_ITEM_FAIL);
        }
        return Response.success(MessageConstant.QUERY_CHECK_ITEM_SUCCESS).put("list", checkItemList);
    }
}