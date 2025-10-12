package org.example.core.menu;

import org.example.common.IdGenerator;

public class Beverage extends MenuItem {
    private int capacity;
    private TemperatureOption temperatureOption;

    private Beverage(String id, String name, int price, MenuCategory category, int stock, int preparationTime) {
        super(id, name, price, category, stock, preparationTime);
    }

    public static Beverage create(String name, int price, MenuCategory category, int stock, int preparationTime) {
        String id = IdGenerator.generate();
        return new Beverage(id, name, price, category, stock, preparationTime);
    }

    @Override
    public String getDescription() {
        String format = "%s - %s (%dml, %s)";
        return String.format(format, this.category.getDisplayName(), this.name, this.capacity, this.temperatureOption.name());
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
