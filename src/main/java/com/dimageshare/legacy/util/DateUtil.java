package com.dimageshare.legacy.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author bac-ta
 */
public class DateUtil {
    private static final String DATE_FORMATER = "yyyy-MM-dd HH:mm:ss.S";
    private static final String DATE_FORMATER_BIRTHDAY = "yyyy-MM-dd";

    public static Date returnDate(String input) throws ParseException {
        DateFormat format = new SimpleDateFormat(DATE_FORMATER);
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = format.parse(input);
        return date;
    }

    public static Date returnDateBirthDay(String input) throws ParseException {
        DateFormat format = new SimpleDateFormat(DATE_FORMATER_BIRTHDAY);
        Date date = format.parse(input);
        return date;
    }
}
