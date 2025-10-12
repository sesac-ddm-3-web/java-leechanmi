package org.example.core.menu;

import org.example.common.IdGenerator;

public class SideDish extends MenuItem {
    private FoodSize size;

    private SideDish(String id, String name, int price, MenuCategory category, int stock, int preparationTime, FoodSize size) {
        super(id, name, price, category, stock, preparationTime);
        this.size = size;
    }

    public static SideDish create(String name, int price, MenuCategory category, int stock, int preparationTime, FoodSize size) {
        String id = IdGenerator.generate();
        return new SideDish(id, name, price, category, stock, preparationTime, size);
    }

    @Override
    public String getDescription() {
        String format = "%s - %s (사이즈: %s)";
        return String.format(format, this.category.getDisplayName(), this.name, size.name());
    }

    @Override
    public int getPreparationTime() {
        return this.preparationTime;
    }

    @Override
    public boolean isAvailable() {
        return stock >= 0;
    }
}
