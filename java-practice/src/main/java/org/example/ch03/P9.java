package org.example.ch03;

import java.util.Arrays;

import org.example.common.BaseClass;

public class P9 extends BaseClass {
    @Override
    public void func() {
        System.out.print("숫자 입력: ");
        int n = in.nextInt();

        System.out.print("설정할 비트 위치: ");
        int setBit = in.nextInt();

        System.out.print("해제할 비트 위치: ");
        int clearBit = in.nextInt();

        String bin = Integer.toBinaryString(n);
        System.out.println("원래 수: " + n + " (" + Integer.toBinaryString(n) + ")");

        String reversedBin = new StringBuilder(bin).reverse().toString();
        int reversedNum = Integer.parseInt(reversedBin, 2);
        System.out.println("비트 뒤집기: " + reversedNum + " (" + reversedBin + ")");

        int setResult = n | (1 << setBit);
        System.out.println(setBit + "번 비트 설정: " + setResult + " (" + Integer.toBinaryString(setResult) + ")");

        int clearResult = n & ~(1 << clearBit);
        System.out.println(clearBit + "번 비트 해제: " + clearResult + " (" + Integer.toBinaryString(clearResult) + ")");

        int oneCnt = Arrays.stream(bin.split(""))
            .mapToInt(Integer::parseInt)
            .filter(bit -> bit == 1)
            .sum();
        System.out.println("1의 개수: " + oneCnt + "개");
    }
}
