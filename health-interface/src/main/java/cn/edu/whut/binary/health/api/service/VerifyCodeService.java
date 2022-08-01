package cn.edu.whut.binary.health.api.service;

/**
 * @author Spring-_-Bear
 * @datetime 2022-08-01 10:28 Monday
 */
public interface VerifyCodeService {
    /**
     * 给手机号发送验证码
     */
    boolean sendPhoneVerifyCode(String phone);

    /**
     * 通过手机号获取验证码，若验证码不存在则返回 null
     */
    String getPhoneVerifyCode(String phone);
}
