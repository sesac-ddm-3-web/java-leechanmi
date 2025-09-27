package org.example.ch03;

import org.example.common.BaseClass;

public class P5 extends BaseClass {
    @Override
    public void main() {
        System.out.print("초기값: ");
        int value = in.nextInt();

        System.out.print("더할 값: ");
        int add = in.nextInt();

        System.out.print("뺄 값: ");
        int sub = in.nextInt();

        System.out.print("곱할 값: ");
        int mul = in.nextInt();

        System.out.print("나눌 값: ");
        int div = in.nextInt();

        System.out.println("초기값: " + value);
        System.out.println("+=" + add + " -> " + (value += add));
        System.out.println("-=" + sub + " -> " + (value -= sub));
        System.out.println("*=" + mul + " -> " + (value *= mul));
        System.out.println("/=" + div + " -> " + (value /= div));
        System.out.println("최종 결과: " + value);
    }
}
