package org.example.ch02;

import org.example.common.BaseClass;

public class P4 extends BaseClass {
    @Override
    public void func() {
        int doubleToInt = (int)3.14;
        byte intToByte = (byte)300;
        int charToInt = (int)'A';
        char intTochar = (char)65;

        System.out.printf("""
                3.14 → %s (소수점 손실)
                300 → %s (오버플로우 발생)
                'A' → %s (ASCII 코드)
                65 → %s (ASCII 문자)
            """, doubleToInt, intToByte, charToInt, intTochar);
    }
}
