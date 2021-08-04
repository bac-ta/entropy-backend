package com.entropy.backend.common.utils;

import com.entropy.backend.common.constants.AppConstant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
    public static LocalDate toDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(AppConstant.DATE_FORMAT));
    }

    public static LocalDateTime toDateTime(String date) {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(AppConstant.DATE_FORMAT));
    }

    public static long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
}
