package org.example.ch02;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;

import org.example.common.BaseClass;

public class P12 extends BaseClass {
    @Override
    public void func() {
        System.out.print("생년월일 입력 (YYYY-MM-DD): ");
        String input = in.nextLine();

        String[] birthDate = input.split("-");
        LocalDate today = LocalDate.now(ZoneId.of("Asia/Seoul"));

        int birthYear = Integer.parseInt(birthDate[0]);
        int birthMonth = Integer.parseInt(birthDate[1]);
        int birthDay = Integer.parseInt(birthDate[2]);
        int age = today.getDayOfYear() - birthYear + 1;

        System.out.println("=== 생년월일 분석 ===");
        System.out.println("생년: " + birthYear + "년");
        System.out.println("생월: " + birthMonth + "월");
        System.out.println("생일: " + birthDay + "일");
        System.out.println("나이: " + age + "세");
        System.out.println();

        System.out.println("=== 생년 진법 변환 ===");
        System.out.println("10진수: " + birthYear);
        System.out.println("2진수: " + Integer.toBinaryString(birthYear));
        System.out.println("8진수: " + Integer.toOctalString(birthYear));
        System.out.println("16진수: " + Integer.toHexString(birthYear));
        System.out.println();

        System.out.println("=== 생년 자릿수 분석 ===");

        String[] birthYearDigits = String.valueOf(birthYear).split("");
        System.out.println("각 자릿수: " + String.join(",", birthYearDigits));

        int sum = Arrays.stream(birthYearDigits)
            .mapToInt(Integer::parseInt)
            .sum();
        System.out.println("자릿수 합: " + sum);
    }
}
