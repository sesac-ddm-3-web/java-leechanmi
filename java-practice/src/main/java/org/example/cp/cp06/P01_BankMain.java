package org.example.cp.cp06;

import org.example.common.BaseClass;

public class P01_BankMain extends BaseClass {

    class BankAccount {
        private String accountNumber;
        private String ownerName;
        private long balance;

        public BankAccount(String accountNumber, String ownerName) {
            this.accountNumber = accountNumber;
            this.ownerName = ownerName;
            this.balance = 0;
        }

        public void deposit(long amount) {
            this.validateDepositAmount(amount);

            this.balance += amount;
            System.out.printf("입금 후 잔액: %d원%n", this.balance);
        }

        private void validateDepositAmount(long amount) {
            if (amount < 0) {
                throw new RuntimeException("유효하지 않은 금액입니다.");
            }
        }

        public void withdraw(long amount) {
            validateWithdrawAmount(amount);

            this.balance -= amount;
            System.out.printf("출금 후 잔액: %d원%n", this.balance);
        }

        private void validateWithdrawAmount(long amount) {
            if (amount < 0) {
                throw new RuntimeException("유효하지 않은 금액입니다.");
            }

            if (this.balance < amount) {
                throw new RuntimeException("잔액이 부족합니다.");
            }
        }

        public void getBalanceInfo() {
            System.out.printf("계좌번호: %s, 예금주: %s, 현재 잔액: %d원%n", this.accountNumber, this.ownerName, this.balance);
        }
    }

    @Override
    public void main() {
        // 1. 홍길동의 계좌 생성
        System.out.println("새로운 계좌를 생성합니다.");
        BankAccount myAccount = new BankAccount("123-456-789", "홍길동");
        myAccount.getBalanceInfo();
        System.out.println();

        // 2. 50,000원 입금
        System.out.println("50,000원을 입금합니다.");
        try {
            myAccount.deposit(50000);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println();
        }

        // 3. 25,000원 출금
        System.out.println("25,000원을 출금합니다.");
        try {
            myAccount.withdraw(25000);
            myAccount.getBalanceInfo();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println();
        }

        // 4. 잔액보다 많은 금액 출금 시도
        System.out.println("30,000원을 출금 시도합니다.");
        try {
            myAccount.withdraw(30000);
            myAccount.getBalanceInfo();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println();
        }
    }
}
