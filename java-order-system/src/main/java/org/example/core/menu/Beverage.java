package org.example.core.menu;

import lombok.Builder;

public class Beverage extends MenuItem {
    private int capacity;
    private TemperatureOption temperatureOption;

    @Builder
    private Beverage(long id, String name, int price, MenuCategory category, int stock, int preparationTime,
        int capacity, TemperatureOption temperatureOption) {
        super(id, name, price, category, stock, preparationTime);
        this.capacity = capacity;
        this.temperatureOption = temperatureOption;
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
