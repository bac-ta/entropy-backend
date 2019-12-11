package com.dimageshare.util;

import com.dimageshare.enumeration.UserInfoLoginType;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
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

    public static Date returnDateBirthDay(String input) throws ParseException {
        DateFormat format = new SimpleDateFormat(DATE_FORMATER_BIRTHDAY);
        Date date = format.parse(input);
        return date;
    }

    public static String hashBySHA512(String passwordToHash) {
        return Hashing.sha512().hashString(passwordToHash, StandardCharsets.UTF_8).toString();
    }

    public static UserInfoLoginType detectInfo(String input) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(input);
        if (matcher.find())
            return UserInfoLoginType.EMAIL_TYPE;
        else {
            pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
            matcher = pattern.matcher(input);
            if (matcher.find())
                return UserInfoLoginType.PHONE_NUMBER_TYPE;
            else
                return UserInfoLoginType.USER_NAME_TYPE;
        }
    }

}
