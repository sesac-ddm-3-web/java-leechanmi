package org.example.core.order;

import java.time.LocalDateTime;
import java.util.List;

import org.example.common.util.IdGenerator;
import org.example.core.customer.Orderer;
import org.example.core.order.exception.InvalidOrderException;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Order {
    private final String orderId;
    private final List<OrderItem> items;
    private final LocalDateTime orderTime;
    private final int totalAmount;
    private final Orderer orderer;
    private OrderStatus status;

    @Builder
    private Order(String orderId, List<OrderItem> items, OrderStatus status, LocalDateTime orderTime, int totalAmount, Orderer orderer) {
        this.validateItemSize(items);

        this.orderId = orderId;
        this.items = items;
        this.status = status;
        this.orderTime = orderTime;
        this.totalAmount = totalAmount;
        this.orderer = orderer;
    }

    private void validateItemSize(List<OrderItem> items) {
        if (items.isEmpty()) {
            throw new InvalidOrderException("주문 항목이 존재하지 않습니다.");
        }
    }

    public static Order create(List<OrderItem> items, Orderer orderer) {
        String orderId = IdGenerator.generateOrderNumber();
        int totalAmount = items.stream()
            .mapToInt(OrderItem::getSubtotal)
            .sum();

        return Order.builder()
            .orderId(orderId)
            .items(items)
            .status(OrderStatus.PENDING)
            .orderTime(LocalDateTime.now())
            .totalAmount(totalAmount)
            .orderer(orderer)
            .build();
    }

    // todo: 각 상태 변경 별로 메서드 존재하게 변경
    public void updateStatus(OrderStatus status) {
        this.status = status;
    }
}