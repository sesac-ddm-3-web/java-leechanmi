package org.example.core.payment;

public record PaymentResult(
    PaymentMethod method,
    int totalAmount,
    int receivedAmount,
    int changeAmount
) {
}
