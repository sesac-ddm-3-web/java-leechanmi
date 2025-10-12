package org.example.core.order;

import org.example.core.menu.MenuItem;

import lombok.Getter;

@Getter
public class OrderItem {
    private final MenuItem menuItem;
    private final int quantity;
    private final int subtotal;

    public OrderItem(MenuItem menuItem, int quantity, int subtotal) {
        this.menuItem = menuItem;
        this.quantity = quantity;
        this.subtotal = subtotal;
    }
}
