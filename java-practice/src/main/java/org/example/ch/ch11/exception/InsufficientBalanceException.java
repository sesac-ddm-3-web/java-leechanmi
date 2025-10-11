package org.example.ch.ch11.exception;

public class InsufficientBalanceException extends OrderException {
    private static final String message = "오류: 사용자 잔고가 부족합니다.";

    public InsufficientBalanceException() {
        super(message);
    }
}