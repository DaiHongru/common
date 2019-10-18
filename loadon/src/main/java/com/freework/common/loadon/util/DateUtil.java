package com.freework.common.loadon.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author daihongru
 */
public class DateUtil {
    private final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取second秒后的时间
     *
     * @param second
     * @return
     */
    public static Date getLaterTimeSecond(int second) {
        Date date = new Date();
        if (second <= 0) {
            return date;
        }
        date.setTime(date.getTime() + second * 1000);
        return date;
    }

    /**
     * 获取minute分后的时间
     *
     * @param minute
     * @return
     */
    public static Date getLaterTimeMinute(int minute) {
        Date date = new Date();
        if (minute <= 0) {
            return date;
        }
        date.setTime(date.getTime() + minute * 60000);
        return date;
    }

    /**
     * 获取当前时间的字符串格式
     * yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String getCurrentTimeToString() {
        Date date = new Date();
        return SIMPLE_DATE_FORMAT.format(date);
    }

    /**
     * 将yyyy-MM-dd HH:mm:ss格式的字符串转为Date
     * @param dateString
     * @return
     * @throws ParseException
     */
    public static Date getStringToDate(String dateString) throws ParseException {
        return SIMPLE_DATE_FORMAT.parse(dateString);
    }
}
