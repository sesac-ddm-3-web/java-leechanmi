package org.example.ch11.exception;

public class OrderException extends Exception {
    // TODO: 공통 포맷으로 메시지를 만들 수는 없을까?

    public OrderException(String message) {
        super(message);
    }
}
