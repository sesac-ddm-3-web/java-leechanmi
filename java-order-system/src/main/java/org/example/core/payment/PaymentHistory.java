package org.example.core.payment;

import java.util.stream.Collectors;

import org.example.common.exception.StatusConflictException;
import org.example.common.util.DateTimeFormatterUtil;
import org.example.core.order.Order;
import org.example.core.order.OrderStatus;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PaymentHistory {
    private final Order order;
    private final PaymentMethod method;
    private final int receivedAmount;
    private final int changeAmount;

    @Builder(access = AccessLevel.PRIVATE)
    private PaymentHistory(Order order, PaymentMethod method, int receivedAmount, int changeAmount) {
        validateOrderStatus(order);

        this.order = order;
        this.method = method;
        this.receivedAmount = receivedAmount;
        this.changeAmount = changeAmount;
    }

    public static PaymentHistory record(Order order, PaymentResult result) {
        return PaymentHistory.builder()
            .order(order)
            .method(result.method())
            .receivedAmount(result.receivedAmount())
            .changeAmount(result.changeAmount())
            .build();
    }

    private void validateOrderStatus(Order order) {
        if (order.getStatus() != OrderStatus.PENDING) {
            throw new StatusConflictException("이미 처리 완료된 주문입니다.");
        }
    }

    @Override
    public String toString() {
        String format = """
            ===== 영수증 =====
            주문번호: %s
            주문시간: %s
            ─────────────────────────
            %s
            ─────────────────────────
            총 금액           %,d원
            결제방법          %s
            받은금액          %,d원
            거스름돈          %,d원
            ─────────────────────────
            """;

        String itemListFormat = "%s x%d\t\t%,d원";
        String items = order.getItems().stream()
            .map(item -> String.format(itemListFormat, item.getMenuItem().getName(), item.getQuantity(), item.getSubtotal()))
            .collect(Collectors.joining("\n"));
        
        return String.format(
            format,
            order.getOrderId(),
            DateTimeFormatterUtil.formatDashed(order.getOrderTime()),
            items,
            order.getTotalAmount(),
            this.method.getDisplayName(),
            this.receivedAmount,
            this.changeAmount
        );
    }
}
