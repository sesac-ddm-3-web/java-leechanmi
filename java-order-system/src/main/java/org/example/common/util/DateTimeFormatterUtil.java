package org.example.common.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterUtil {
    private static final DateTimeFormatter BASIC_DATE = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static final DateTimeFormatter DASHED_DATETIME = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static String formatBasic(LocalDate date) {
        return BASIC_DATE.format(date);
    }

    public static String formatDashed(LocalDateTime dateTime) {
        return DASHED_DATETIME.format(dateTime);
    }
}
