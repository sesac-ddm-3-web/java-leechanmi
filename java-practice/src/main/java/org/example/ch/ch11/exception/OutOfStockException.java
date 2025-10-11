package org.example.ch.ch11.exception;

public class OutOfStockException extends OrderException {
    private static final String message = "오류: 상품의 재고가 부족합니다.";

    public OutOfStockException() {
        super(message);
    }
}
