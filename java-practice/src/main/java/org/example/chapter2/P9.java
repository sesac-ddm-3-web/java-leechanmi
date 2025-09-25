package org.example.chapter2;

import org.example.common.BaseClass;

public class P9 extends BaseClass {
    @Override
    public void func() {
        System.out.print("변환 방식을 선택하세요 (1: 섭씨→화씨, 2: 화씨→섭씨): ");
        String method = in.nextLine();

        System.out.print("섭씨온도 입력: ");
        double degree = in.nextDouble();

        switch (method) {
            case "1" -> {
                double fDegree = degree * 9 / 5 + 32;
                System.out.printf("섭씨 %s도는 화씨 %s도입니다.\n", degree, fDegree);
            }
            case "2" -> {
                double cDegree = (degree - 32) * 5 / 9;
                System.out.printf("섭씨 %s도는 화씨 %s도입니다.\n", degree, cDegree);
            }
        }
    }
}
