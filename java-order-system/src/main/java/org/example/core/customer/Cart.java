package org.example.core.customer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.example.core.menu.MenuItem;
import org.example.core.order.OrderItem;

public class Cart {
    private LinkedHashMap<Long, CartItem> items;

    private Cart(LinkedHashMap<Long, CartItem> items) {
        this.items = items;
    }

    public static Cart create() {
        return new Cart(new LinkedHashMap<>());
    }

    public void addItem(MenuItem menuItem, int quantity) {
        long menuId = menuItem.getId();

        if (items.containsKey(menuId)) {
            CartItem item = items.get(menuId);
            item.addQuantity(quantity);
        } else {
            CartItem item = new CartItem(menuItem, quantity);
            items.put(menuId, item);
        }
    }

    public void removeItem(String menuItemId) {
        items.remove(menuItemId);
    }

    public void clear() {
        items.clear();
    }

    // 계산 가능한 값은 저장하지 말라는 말이 있는데,
    // 매번 계산하는게 맞을까, 저장하는게 맞을까?
    public int getTotalAmount() {
        return items.values().stream()
            .mapToInt(item -> item.getMenuItem().getPrice())
            .sum();
    }

    public int getPreparationTime() {
        return items.values().stream()
            .mapToInt(item -> item.getMenuItem().getPreparationTime())
            .sum();
    }

    public List<OrderItem> toOrderItems() {
        return this.items.sequencedEntrySet().stream()
            .map(Map.Entry::getValue)
            .map(CartItem::toOrderItem)
            .toList();
    }

    @Override
    public String toString() {
        String format = """
            ===== 장바구니 =====
            %s
            ─────────────────────────
            총 금액: %,d원
            예상 조리 시간: %d분
            """;

        List<CartItem> list = new ArrayList<>(items.values());
        String items = IntStream.range(0, list.size())
            .mapToObj(i -> String.format("%d. %s", i + 1, list.get(i)))
            .collect(Collectors.joining("\n"));

        return String.format(format, items, this.getTotalAmount(), this.getPreparationTime());
    }
}
