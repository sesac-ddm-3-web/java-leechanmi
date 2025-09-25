package org.example.cp02_03;

import org.example.common.BaseClass;

// 간단한 이자 계산기
public class P1 extends BaseClass {
    @Override
    public void func() {
        System.out.print("원금을 입력하세요: ");
        long principal = in.nextLong();

        System.out.print("연이율(%)을 입력하세요: ");
        double interestRate = in.nextDouble();

        System.out.print("예치 기간(년)을 입력하세요: ");
        int years = in.nextInt();

        double profit = calculateProfit(principal, interestRate, years);
        double total = calculateTotal(principal, profit);

        System.out.println();
        System.out.println("=== 최종 계산 결과 ===");
        System.out.printf("원금: %,d원%n", principal);
        System.out.println("연이율: " + interestRate + "%");
        System.out.println("기간: " + years + "년");
        System.out.println("--------------------");
        System.out.printf("총 이자 수익: %,d원%n", (long) profit);
        System.out.printf("최종 수령액: %,d원%n", (long) total);
    }

    private static double calculateProfit(long principal, double interestRate, int years) {
        return principal * (interestRate / 100) * years;
    }

    private static double calculateTotal(long principal, double profit) {
        return principal + profit;
    }
}
