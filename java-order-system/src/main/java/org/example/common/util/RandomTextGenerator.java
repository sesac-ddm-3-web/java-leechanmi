package org.example.common.util;

import java.util.UUID;

public class RandomTextGenerator {

    // 실무에서는 랜덤 문자열을 어떻게 생성할까?
    public static String generate() {
        return UUID.randomUUID().toString();
    }

    public static String generate(int length) {
        StringBuilder text = new StringBuilder();
        while (text.length() < length) {
            text.append(generate());
        }

        return text.substring(0, length).toUpperCase();
    }
}
