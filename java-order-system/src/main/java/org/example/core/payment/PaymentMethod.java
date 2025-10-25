package org.example.core.payment;

import org.example.core.customer.Wallet;

public interface PaymentMethod {
    PaymentResult processPayment(Wallet wallet, int totalAmount, int receivedAmount);
    String getPaymentInfo(Wallet wallet, int totalAmount);
    String getDisplayName();
}
