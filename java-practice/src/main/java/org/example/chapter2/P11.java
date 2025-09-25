package org.example.chapter2;

import org.example.common.BaseClass;

public class P11 extends BaseClass {
    @Override
    public void func() {
        System.out.print("초 입력: ");
        int input = in.nextInt();

        int hour = input / 3600;
        int min = (input - hour * 3600) / 60;
        int sec = input % 60;

        StringBuilder result = new StringBuilder();
        result.append(input + "초는 ");

        if (hour != 0) {
            result.append(hour + "시간 ");
        }
        if (min != 0) {
            result.append(min + "분 ");
        }
        result.append(sec + "초입니다.");

        System.out.println(result);
    }
}
