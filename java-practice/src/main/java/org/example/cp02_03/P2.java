package org.example.cp02_03;

import org.example.common.BaseClass;

// 상품 할인 및 포인트 계산기
public class P2 extends BaseClass {
    @Override
    public void func() {
        System.out.print("상품의 원가를 입력하세요: ");
        double originalPrice = in.nextDouble();

        System.out.print("할인율(%)을 입력하세요: ");
        double discountRate = in.nextDouble();

        long total = calculateTotal(originalPrice, discountRate);
        int point = calculatePoint(total);

        System.out.println();
        System.out.println("=== 결제 정보 ===");
        System.out.printf("상품 원가: %,.0f원%n", originalPrice);
        System.out.println("할인율: " + discountRate + "%");
        System.out.println("--------------------");
        System.out.printf("최종 결제 금액: %,d원%n", total);
        System.out.printf("적립 포인트: %,d점%n", point);
    }

    private static long calculateTotal(double originalPrice, double discountRate) {
        return (long) (originalPrice * (1 - discountRate / 100) / 10 * 10);
    }

    private static int calculatePoint(double total) {
        return total >= 30000
            ? (int)(total * 0.05)
            : (int)(total * 0.01);
    }
}
