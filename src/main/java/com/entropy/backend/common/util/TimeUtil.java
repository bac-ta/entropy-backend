package com.entropy.backend.common.util;

import com.entropy.backend.common.constant.FormatString;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
    public static LocalDate toDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(FormatString.DATE_FORMAT));
    }
}
