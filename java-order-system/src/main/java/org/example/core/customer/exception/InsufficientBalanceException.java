package org.example.core.customer.exception;

public class InsufficientBalanceException extends RuntimeException {
    private static final String MESSAGE = "잔액 부족";

    public InsufficientBalanceException() {
        super(MESSAGE);
    }
}
