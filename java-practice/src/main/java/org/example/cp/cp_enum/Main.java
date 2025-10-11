package org.example.cp.cp_enum;

public class Main {
    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator();

        long originalPrice = 30000; // 원가: 30,000원

        // 1. 10% 퍼센트 할인 적용
        long priceAfterPercentageDiscount = calculator.calculate(originalPrice, 10, DiscountType.PERCENTAGE);
        System.out.printf("30,000원의 10%% 할인 적용 가격: %,d원%n%n", priceAfterPercentageDiscount);

        // 2. 5,000원 고정 금액 할인 적용
        long priceAfterFixedDiscount = calculator.calculate(originalPrice, 5000, DiscountType.FIXED_AMOUNT);
        System.out.printf("30,000원의 5,000원 할인 적용 가격: %,d원%n", priceAfterFixedDiscount);
    }
}

