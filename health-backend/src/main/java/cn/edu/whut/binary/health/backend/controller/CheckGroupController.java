package cn.edu.whut.binary.health.backend.controller;

import cn.edu.whut.binary.health.api.service.CheckGroupService;
import cn.edu.whut.binary.health.common.constant.MessageConstant;
import cn.edu.whut.binary.health.common.entity.PageQueryBean;
import cn.edu.whut.binary.health.common.entity.Response;
import cn.edu.whut.binary.health.common.pojo.CheckGroup;
import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


/**
 * @author Spring-_-Bear
 * @datetime 2022-07-19 10:43 Tuesday
 */
@RestController
public class CheckGroupController {
    @Reference
    private CheckGroupService checkGroupService;

    /**
     * 保存检查组，并维护检查组与检查项的多对多关系
     */
    @PostMapping("/checkGroup.do")
    public Response saveCheckGroup(CheckGroup checkGroup, @RequestBody Integer[] checkItemIds) {
        if (checkGroupService.saveCheckGroup(checkGroup, Arrays.asList(checkItemIds))) {
            return Response.success(MessageConstant.ADD_CHECK_GROUP_SUCCESS);
        }
        return Response.error(MessageConstant.ADD_CHECK_GROUP_FAIL);
    }

    @GetMapping("/checkGroup.do")
    public Response getCheckGroupPageData(@RequestParam Integer currentPage, @RequestParam Integer pageSize, String condition) {
        PageQueryBean pageQueryBean = new PageQueryBean(currentPage, pageSize, condition);
        PageInfo<CheckGroup> checkGroupPageData = checkGroupService.getCheckGroupPageData(pageQueryBean);
        if (checkGroupPageData == null || checkGroupPageData.getList() == null || checkGroupPageData.getList().size() == 0) {
            return Response.info(MessageConstant.QUERY_CHECK_GROUP_FAIL);
        }
        return Response.success(MessageConstant.QUERY_CHECK_GROUP_SUCCESS).put("pageData", checkGroupPageData);
    }

    @DeleteMapping("/checkGroup.do")
    public Response deleteCheckGroup(@RequestParam Integer checkGroupId) {
        if (checkGroupService.deleteCheckGroupById(checkGroupId)) {
            return Response.success(MessageConstant.DELETE_CHECK_GROUP_SUCCESS);
        }
        return Response.error(MessageConstant.DELETE_CHECK_GROUP_FAIL);
    }

    /**
     * 根据检查组 ID 查询其对应的检查项信息（一个检查组对应多个检查项）
     */
    @GetMapping("/checkGroup/{checkGroupId}.do")
    public Response getCheckItemIdsOfCheckGroup(@PathVariable("checkGroupId") Integer checkGroupId) {
        List<Integer> checkItemIdList = checkGroupService.getCheckItemIdsOfCheckGroup(checkGroupId);
        if (checkItemIdList == null || checkItemIdList.size() == 0) {
            return Response.info(MessageConstant.QUERY_CHECK_ITEM_OF_GROUP_FAIL);
        }
        return Response.success(MessageConstant.QUERY_CHECK_ITEM_OF_GROUP_SUCCESS).put("list", checkItemIdList);
    }

    /**
     * 更新检查组信息，并更新检查组所对应的检查项关系
     *
     * @param checkGroup   新的检查组信息
     * @param checkItemIds 新检查组所对应的新检查项的 ID 数组
     */
    @PutMapping("/checkGroup.do")
    public Response updateCheckGroup(CheckGroup checkGroup, @RequestBody Integer[] checkItemIds) {
        if (checkGroup.getId() == null) {
            return Response.warn(MessageConstant.PARAMETERS_NEEDED);
        }
        if (checkGroupService.updateCheckGroup(checkGroup, Arrays.asList(checkItemIds))) {
            return Response.success(MessageConstant.EDIT_CHECK_GROUP_SUCCESS);
        }
        return Response.error(MessageConstant.EDIT_CHECK_GROUP_FAIL);
    }
}

