package org.example.chapter2;

import org.example.common.BaseClass;

public class P5 extends BaseClass {
    @Override
    public void func() {
        System.out.print("정수 입력: ");
        String intStr = in.nextLine();

        System.out.print("실수 입력: ");
        String doubleStr = in.nextLine();

        System.out.print("불린 입력: ");
        String boolStr = in.nextLine();

        int intValue = Integer.parseInt(intStr);
        double doubleValue = Double.parseDouble(doubleStr);
        boolean boolValue = Boolean.parseBoolean(boolStr);

        // 출력
        System.out.println("문자열 \"" + intStr + "\"을 정수로: " + intValue);
        System.out.println("문자열 \"" + doubleStr + "\"을 실수로: " + doubleValue);
        System.out.println("문자열 \"" + boolStr + "\"를 불린으로: " + boolValue);
    }
}
