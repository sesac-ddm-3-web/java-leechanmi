package org.example.core;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.example.common.exception.NotFoundException;
import org.example.core.customer.Orderer;
import org.example.core.customer.Wallet;
import org.example.core.menu.MenuCategory;
import org.example.core.menu.MenuItem;
import org.example.core.order.Order;
import org.example.core.customer.Cart;
import org.example.core.order.OrderItem;
import org.example.core.order.OrderStatus;
import org.example.core.payment.PaymentHistory;
import org.example.core.payment.PaymentMethod;
import org.example.core.payment.PaymentResult;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class Restaurant {
    private String name;
    private Map<MenuCategory, List<MenuItem>> menu;
    private List<Order> orders;
    private List<PaymentHistory> paymentHistories;

    public Order createOrder(Orderer orderer) {
        Cart cart = orderer.getCart();
        List<OrderItem> orderItems = cart.toOrderItems();
        Order order = Order.create(orderItems, orderer);
        orders.add(order);

        return order;
    }

    public PaymentHistory processOrder(Order order, PaymentMethod payment, int receivedAmount) {
        Orderer orderer = order.getOrderer();
        Wallet wallet = orderer.getWallet();

        payment.getPaymentInfo(wallet, order.getTotalAmount());
        PaymentResult result = payment.processPayment(wallet, order.getTotalAmount(), receivedAmount);

        PaymentHistory history = PaymentHistory.record(order, result);
        paymentHistories.add(history);

        orderer.getCart().clear();
        order.updateStatus(OrderStatus.CONFIRMED);

        return history;
    }

    public MenuItem findMenuById(Long id) {
        return menu.values().stream()
            .flatMap(List::stream)
            .filter(menu -> menu.getId() == id)
            .findAny()
            .orElseThrow(() -> new NotFoundException("해당하는 메뉴가 존재하지 않습니다."));
    }

    public Order getLastOrder() {
        return orders.getLast();
    }

    public void displayMenu() {
        StringBuilder result = new StringBuilder();

        Arrays.stream(MenuCategory.values())
            .forEach(category -> result.append(this.getMenuDetail(category)));

        System.out.println(result);
    }

    private String getMenuDetail(MenuCategory menuCategory) {
        StringBuilder result = new StringBuilder();
        result.append("[ ").append(menuCategory.getDisplayName()).append(" ]").append("\n");

        String format = """
            %d. %s - %,d원
            설명: %s
            조리시간: %s
            재고: %d개
            주문가능: %s\n
            """;

        menu.get(menuCategory).stream()
            .sorted(Comparator.comparing(MenuItem::getId))
            .forEach(menu -> result.append(
                String.format(
                    format,
                    menu.getId(),
                    menuCategory.getDisplayName(),
                    menu.getPrice(),
                    menu.getDescription(),
                    menu.getPreparationTime(),
                    menu.getStock(),
                    menu.isAvailable() ? "O" : "X"
                )
            ));

        return result.toString();
    }
}