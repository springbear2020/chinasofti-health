package cn.edu.whut.binary.health.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Spring-_-Bear
 * @datetime 2022-07-22 09:57 Friday
 */
public class DateUtils {
    /**
     * Parse the java.util.Date into 2022-06-30 format
     *
     * @param date java.util.Date
     * @return Date after formatting
     */
    public static String parseDateWithHyphen(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    /**
     * Parse java.util.Date into 20220606122345 format
     *
     * @param date java.util.Date
     * @return Datetime in format string
     */
    public static String parseDatetimeNoHyphen(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return dateFormat.format(date);
    }
}
