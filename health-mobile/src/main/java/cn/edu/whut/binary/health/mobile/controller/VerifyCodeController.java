package cn.edu.whut.binary.health.mobile.controller;

import cn.edu.whut.binary.health.api.service.VerifyCodeService;
import cn.edu.whut.binary.health.common.constant.MessageConstant;
import cn.edu.whut.binary.health.common.entity.Response;
import cn.edu.whut.binary.health.common.util.StringUtils;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Spring-_-Bear
 * @datetime 2022-08-01 10:20 Monday
 */
@RestController
public class VerifyCodeController {
    @Reference
    private VerifyCodeService verifyCodeService;

    /**
     * 给指定的手机号发送数字验证码，有效时间 1 分钟
     */
    @GetMapping("/digit.do")
    public Response getFourDigitsVerifyCode(@RequestParam("phone") String phone) {
        if (verifyCodeService.sendPhoneVerifyCode(phone)) {
            return Response.success(MessageConstant.SEND_VALIDATE_CODE_SUCCESS);
        }
        return Response.error(MessageConstant.SEND_VALIDATE_CODE_FAIL);
    }
}
