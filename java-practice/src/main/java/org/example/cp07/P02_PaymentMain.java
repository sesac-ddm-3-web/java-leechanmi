package org.example.cp07;

import org.example.common.BaseClass;

abstract class Payment {
    protected double amount;
    protected double fee;

    protected Payment(double amount, double fee) {
        this.validateAmount(amount);
        this.amount = amount;
        this.fee = fee;
    }

    private void validateAmount(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("결제 금액은 0원 이하일 수 없습니다.");
        }
    }

    abstract void processPayment();

    public double getAmount() {
        return amount;
    }

    // 고민: 수수료를 반환하는 메서드가 에러 없이 동작하려면 fee가 super 생성자에서 초기화되어야 함
    // 그런데 fee 산정 방식이 클래스마다 다르기 때문에 미리 알기 어려움
    public double getFee() {
        return fee;
    }
}

class CreditCardPayment extends Payment {
    private static final double FEE_RATE = 0.015;

    private CreditCardPayment(int amount, double fee) {
        super(amount, fee);
    }

    public static CreditCardPayment of(int amount) {
        double fee = amount * FEE_RATE;
        return new CreditCardPayment(amount, fee);
    }

    @Override
    void processPayment() {
        System.out.println("신용카드로 " + this.amount + "원 결제가 진행됩니다. (수수료: " + this.fee + ")");
    }
}

class BankTransferPayment extends Payment {
    private static final double FEE = 500;

    private BankTransferPayment(double amount, double fee) {
        super(amount, fee);
    }

    public static BankTransferPayment of(int amount) {
        return new BankTransferPayment(amount, FEE);
    }

    @Override
    void processPayment() {
        System.out.println("계좌 이체로 " + this.amount + "원 결제가 진행됩니다. (수수료: " + this.fee + ")");
    }
}

class MobilePayment extends Payment {
    private static final double FEE_RATE = 0.01;

    private MobilePayment(int amount, double fee) {
        super(amount, fee);
    }

    public static MobilePayment of(int amount) {
        double fee = amount * FEE_RATE;
        return new MobilePayment(amount, fee);
    }

    @Override
    void processPayment() {
        System.out.println("모바일 페이로 " + this.amount + "원 결제가 진행됩니다. (수수료: " + this.fee + ")");
    }
}

public class P02_PaymentMain extends BaseClass {

    @Override
    public void main() {
        // 다양한 결제 수단 객체 생성
        Payment creditCard = CreditCardPayment.of(10000);
        Payment bankTransfer = BankTransferPayment.of(50000);
        Payment mobilePay = MobilePayment.of(30000);

        // Payment 타입 배열에 모든 결제 정보를 담아 다형성 활용
        Payment[] payments = {creditCard, bankTransfer, mobilePay};

        double totalAmount = 0;
        double totalFee = 0;

        System.out.println("## 결제 처리 시작 ##");
        System.out.println("--------------------");

        // 반복문을 돌면서 각 결제 수단의 processPayment 메서드를 호출
        for (Payment payment : payments) {
            payment.processPayment(); // 오버라이딩된 각 클래스의 메서드가 호출됨
            totalAmount += payment.getAmount(); // 총 결제 금액 누적
            // 참고: 수수료 계산을 위해 각 클래스에 수수료를 반환하는 메서드를 추가로 구현할 수 있습니다.
            totalFee += payment.getFee();
            // 여기서는 간단하게 출력 메시지만 확인합니다.
        }

        System.out.println("--------------------");
        System.out.println(">> 총 결제 금액: " + totalAmount + "원");
        System.out.println(">> 총 수수료: " + totalFee + "원");
        // 총 수수료를 계산하여 출력하는 로직을 추가해볼 수도 있습니다.
    }
}
