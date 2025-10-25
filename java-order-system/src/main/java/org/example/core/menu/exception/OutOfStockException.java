package org.example.core.menu.exception;

public class OutOfStockException extends RuntimeException {
    private static final String MESSAGE_FORMAT = "재고가 부족하여 주문할 수 없습니다. 카테고리: %s, 메뉴명: %s";

    public OutOfStockException(String category, String name) {
        super(String.format(MESSAGE_FORMAT, category, name));
    }
}
