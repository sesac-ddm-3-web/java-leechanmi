package org.example.ch02;

import org.example.common.BaseClass;

public class P6 extends BaseClass {
    @Override
    public void func() {
        System.out.print("10진수 입력: ");
        int input = Integer.parseInt(in.nextLine());

        // 출력   
        System.out.println("10진수: " + input);
        System.out.println("2진수: " + Integer.toBinaryString(input));
        System.out.println("8진수: " + Integer.toOctalString(input));
        System.out.println("16진수: " + Integer.toHexString(input));
    }
}
