package cn.edu.whut.binary.health.common.util;

import java.util.Date;
import java.util.UUID;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-22 10:08 Friday
 */
public class StringUtils {
    /**
     * 重命名图片文件：格式为 datetime-uuid.suffix, eg. 20220722101223-dc5b75ba.png
     *
     * @return 文件命名字符串
     */
    public static String getImageFileName(String suffix) {
        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString();
        return DateUtils.parseDatetimeNoHyphen(new Date()) + "-" + uuidStr.substring(0, 8) + suffix;
    }
}
