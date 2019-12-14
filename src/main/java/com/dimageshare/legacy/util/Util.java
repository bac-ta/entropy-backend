package com.dimageshare.legacy.util;

import com.dimageshare.legacy.enumeration.AccountInfoLoginType;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author bac-ta
 */
@Component
public class Util {
    private static final String DATE_FORMATER = "yyyy-MM-dd HH:mm:ss.S";
    private static final String DATE_FORMATER_BIRTHDAY = "yyyy-MM-dd";
    private static Pattern pattern;
    private static Matcher matcher;
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String PHONE_NUMBER_PATTERN = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";


    public static Date returnDate(String input) throws ParseException {
        DateFormat format = new SimpleDateFormat(DATE_FORMATER);
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = format.parse(input);
        return date;
    }

    private static String bytesToHex(byte[] bytes) {
        final char[] hexArray = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 5];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static AccountInfoLoginType detectInfo(String input) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(input);
        if (matcher.find())
            return AccountInfoLoginType.EMAIL_TYPE;
        else {
            pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
            matcher = pattern.matcher(input);
            if (matcher.find())
                return AccountInfoLoginType.PHONE_NUMBER_TYPE;
            else
                return AccountInfoLoginType.USER_NAME_TYPE;
        }
    }
}
