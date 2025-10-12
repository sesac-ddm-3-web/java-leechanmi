package org.example.core.payment;

import java.util.regex.Pattern;

import org.example.core.customer.Wallet;
import org.example.core.customer.exception.InsufficientBalanceException;
import org.example.core.payment.exception.PaymentFailureException;

public enum PaymentMethodImpl implements PaymentMethod {
    CARD("카드") {
        @Override
        public PaymentResult processPayment(Wallet wallet, int totalAmount, int receivedAmount) {
            validateCardNumber(wallet.getCardNumber());
            return new PaymentResult(CARD, totalAmount, receivedAmount, 0);
        }

        @Override
        public String getPaymentInfo(Wallet wallet, int totalAmount) {
            String format = """
                ===== 카드 결제 =====
                결제 정보: %s 결제
                결제 금액: %,d원
                """;

            return String.format(format, CARD.displayName, totalAmount);
        }

        private void validateCardNumber(String cardNumber) {
            Pattern pattern = Pattern.compile("^\\d{4}(-\\d{4}){3}$");
            if (!pattern.matcher(cardNumber).matches()) {
                throw new PaymentFailureException("유효하지 않은 카드 번호");
            }
        }
    },

    CASH("현금") {
        @Override
        public PaymentResult processPayment(Wallet wallet, int totalAmount, int receivedAmount) {
            validateReceivedAmount(receivedAmount, totalAmount);

            try {
                wallet.deductCash(receivedAmount);
            } catch (InsufficientBalanceException e) {
                throw new PaymentFailureException(e.getMessage());
            }

            int changeAmount = receivedAmount - totalAmount;
            return new PaymentResult(CASH, totalAmount, receivedAmount, changeAmount);
        }

        @Override
        public String getPaymentInfo(Wallet wallet, int totalAmount) {
            String format = """
                ===== 현금 결제 =====
                결제 정보: %s 결제
                결제 금액: %,d원
                보유 현금: %,d원
                """;

            return String.format(format, CASH.displayName, totalAmount, wallet.getCashBalance());
        }
    },

    POINT("포인트") {
        @Override
        public PaymentResult processPayment(Wallet wallet, int totalAmount, int receivedAmount) {
            validateReceivedAmount(receivedAmount, totalAmount);

            try {
                wallet.deductPoints(totalAmount);
            } catch (InsufficientBalanceException e) {
                throw new PaymentFailureException(e.getMessage());
            }
            return new PaymentResult(POINT, totalAmount, receivedAmount, 0);

        }

        @Override
        public String getPaymentInfo(Wallet wallet, int totalAmount) {
            String format = """
                ===== 포인트 결제 =====
                결제 정보: %s 결제
                결제 금액: %,d원
                보유 포인트: %,d원
                """;

            return String.format(format, POINT.displayName, totalAmount, wallet.getPointBalance());
        }
    };

    private final String displayName;

    PaymentMethodImpl(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    private static void validateReceivedAmount(int receivedAmount, int totalAmount) {
        if (receivedAmount < totalAmount) {
            throw new PaymentFailureException("금액 부족");
        }
    }
}
