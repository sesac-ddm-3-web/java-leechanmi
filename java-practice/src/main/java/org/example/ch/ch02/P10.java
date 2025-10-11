package org.example.ch.ch02;

import org.example.common.BaseClass;

public class P10 extends BaseClass {
    @Override
    public void main() {
        System.out.print("키(cm) 입력: ");
        double height = in.nextDouble();

        System.out.print("몸무게(kg) 입력: ");
        double weight = in.nextDouble();

        double bmi = weight / Math.pow((height / 100), 2);

        String result;
        if (bmi < 18.5) {
            result = "저체중";
        } else if (bmi >= 18.5 && bmi < 25) {
            result = "정상체중";
        } else if (bmi >= 25 && bmi < 30) {
            result = "과체중";
        } else {
            result = "비만";
        }

        System.out.printf("키: %scm\n", height);
        System.out.printf("몸무게: %skg\n", weight);
        System.out.printf("BMI: %.2f\n", bmi);
        System.out.printf("판정: %s\n", result);
    }
}
