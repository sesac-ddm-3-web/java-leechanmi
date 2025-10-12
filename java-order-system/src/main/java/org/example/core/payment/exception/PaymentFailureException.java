package org.example.core.payment.exception;

public class PaymentFailureException extends RuntimeException {
    private static final String FORMAT = "결제에 실패했습니다. 사유: %s";

    public PaymentFailureException(String failureDetail) {
        super(String.format(FORMAT, failureDetail));
    }
}
