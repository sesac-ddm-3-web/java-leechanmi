package org.example.core.customer;

import org.example.core.menu.MenuItem;
import org.example.core.order.OrderItem;

import lombok.Getter;

@Getter
public class CartItem {
    private final MenuItem menuItem;
    private int quantity;
    private int subtotal;

    public CartItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
        this.subtotal = menuItem.getPrice() * quantity;
    }

    public void addQuantity(int cnt) {
        this.quantity += cnt;
        this.subtotal += menuItem.getPrice() * cnt;
    }

    @Override
    public String toString() {
        String format = "%s x%d: %,d원";
        return String.format(format, menuItem.getName(), this.quantity, menuItem.getPrice());
    }

    public OrderItem toOrderItem() {
        return new OrderItem(this.menuItem, this.quantity, this.subtotal);
    }
}
