package cn.edu.whut.binary.health.provider.service.impl;

import cn.edu.whut.binary.health.api.service.VerifyCodeService;
import cn.edu.whut.binary.health.common.util.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author Spring-_-Bear
 * @datetime 2022-08-01 10:29 Monday
 */
@Service(interfaceClass = VerifyCodeService.class)
@org.springframework.stereotype.Service
public class VerifyCodeServiceImpl implements VerifyCodeService {
    @Autowired
    private JedisPool jedisPool;

    @Override
    public boolean sendPhoneVerifyCode(String phone) {
        String verifyCode = StringUtils.digitsVerifyCode(6);
        // TODO delete the next line
        System.out.println(verifyCode);
        Jedis jedis = jedisPool.getResource();
        // 将当前手机号和验证进行关联并设置有效时间为 2 分钟
        jedis.setex(phone, 120, verifyCode);
        jedis.close();
        return true;
    }

    @Override
    public String getPhoneVerifyCode(String phone) {
        Jedis jedis = jedisPool.getResource();
        String verifyCode = jedis.get(phone);
        jedis.close();
        return verifyCode;
    }
}
