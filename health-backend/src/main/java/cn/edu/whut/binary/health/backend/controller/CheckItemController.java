package cn.edu.whut.binary.health.backend.controller;

import cn.edu.whut.binary.health.api.service.CheckItemService;
import cn.edu.whut.binary.health.common.constant.MessageConstant;
import cn.edu.whut.binary.health.common.entity.Response;
import cn.edu.whut.binary.health.common.pojo.CheckItem;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}