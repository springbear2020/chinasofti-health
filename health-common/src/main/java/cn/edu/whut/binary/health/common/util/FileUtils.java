package cn.edu.whut.binary.health.common.util;

import java.io.File;
import java.util.Date;
import java.util.UUID;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-22 10:08 Friday
 */
public class FileUtils {
    /**
     * 重命名文件：格式为 datetime-uuid.suffix, eg. 20220722101223-dc5b75ba.png
     *
     * @return 文件命名字符串
     */
    public static String getNewFileName(String suffix) {
        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString();
        return DateUtils.parseDatetimeNoHyphen(new Date()) + "-" + uuidStr.substring(0, 8) + suffix;
    }

    /**
     * 判断指定路径的目录是否存在，不存在则创建
     *
     * @param path 目录路径
     */
    @SuppressWarnings("all")
    public static void createDirectories(String path) {
        File directory = new File(path);
        if (!directory.exists()) {
            // 创建多级目录，忽略返回值
            directory.mkdirs();
        }
    }
}
