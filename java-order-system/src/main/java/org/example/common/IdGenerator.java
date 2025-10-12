package org.example.common;

public class IdGenerator {
    private static final int ID_LENGTH = 16;

    public static String generate() {
        return RandomTextGenerator.generate(ID_LENGTH);
    }
}
