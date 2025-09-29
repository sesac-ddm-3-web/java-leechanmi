package org.example.cp08;

import org.example.common.BaseClass;

interface Payment {
    void processPayment(long amount);

    default void printReceipt(long amount) {
        System.out.println("=== 신용카드 영수증 ===");
        System.out.printf("결제 금액: %d원%n", amount);
        System.out.println("결제 완료");
    }

    default boolean validateAmount(long amount) {
        return amount > 0;
    }
}

class CreditCardPayment implements Payment {

    @Override
    public void processPayment(long amount) {
        System.out.printf("금액 유효성 검사 통과: %d원%n", amount);
        System.out.printf("신용카드로 %d원 결제했습니다.%n", amount);
    }
}

class CashPayment implements Payment {

    @Override
    public void printReceipt(long amount) {
        System.out.println("=== 현금 영수증 ===");
        System.out.printf("결제 금액: %d원%n", amount);
        System.out.println("거스름돈: 없음");
    }

    @Override
    public void processPayment(long amount) {
        System.out.printf("현금으로 %d원 결제했습니다.%n", amount);
    }
}

public class P03 extends BaseClass {
    @Override
    public void main() {
        Payment creditCard = new CreditCardPayment();
        Payment cash = new CashPayment();

        long amount1 = 50000;
        if (creditCard.validateAmount(amount1)) {
            creditCard.processPayment(amount1);
            creditCard.printReceipt(amount1);
            System.out.println(); // 줄 바꿈
        }

        long amount2 = 30000;
        if (cash.validateAmount(amount2)) {
            cash.processPayment(amount2);
            cash.printReceipt(amount2);
        }
    }
}
