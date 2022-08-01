package cn.edu.whut.binary.health.common.util;

import java.util.Random;

/**
 * @author Spring-_-Bear
 * @datetime 2022-08-01 10:23 Monday
 */
public class StringUtils {
    /**
     * 随机生成指定位数的数字验证码
     *
     * @return 指定位数数字验证码字符串
     */
    public static String digitsVerifyCode(int len) {
        StringBuilder builder = new StringBuilder();
        for (int j = 1; j <= len; j++) {
            int randomNum = new Random().nextInt(10);
            builder.append("0123456789".charAt(randomNum));
        }
        return builder.toString();
    }
}
