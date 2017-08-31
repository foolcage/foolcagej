package com.foolcage.foolcompute.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xuanqi on 17-7-12.
 */
public class DateUtils {
    public static String dateToStr(Date date, boolean precise) {
        DateFormat dateFormat = precise ? new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ") : new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    public static Date strToDate(String date) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.parse(date);
    }
}
