package org.example.core.menu;

import org.example.core.menu.exception.OutOfStockException;

import lombok.Getter;

@Getter
public abstract class MenuItem {
    protected String id;
    protected String name;
    protected int price;
    protected MenuCategory category;
    protected int stock;
    protected int preparationTime;

    protected MenuItem(String id, String name, int price, MenuCategory category, int stock, int preparationTime) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.stock = stock;
        this.preparationTime = preparationTime;
    }

    public abstract String getDescription();
    public abstract int getPreparationTime();
    public abstract boolean isAvailable();

    public void reduceStock(int quantity) {
        if (!isAvailable()) {
            throw new OutOfStockException(this.category.name(), this.name);
        }
        this.stock -= 1;
    }
}