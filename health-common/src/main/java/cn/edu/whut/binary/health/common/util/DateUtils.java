package cn.edu.whut.binary.health.common.util;

import java.text.ParseException;
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

    /**
     * Parse the date in string format into java.util.Date,
     * if parse then return the default Date given by user
     *
     * @param dateStr     Date in string format
     * @return java.util.Date
     */
    public static Date parseStringWithHyphen(String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.parse(dateStr);
    }
}
