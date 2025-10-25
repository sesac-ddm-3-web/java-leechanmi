package org.example.common.util;

import java.time.LocalDate;

public class IdGenerator {
    private static final int ID_LENGTH = 16;

    public static String generate() {
        return RandomTextGenerator.generate(ID_LENGTH);
    }

    public static String generateOrderNumber() {
        String format = "ORD-%s-%s";
        String date = DateTimeFormatterUtil.formatBasic(LocalDate.now());
        String random = RandomTextGenerator.generate(5);

        return String.format(format, date, random);
    }
}