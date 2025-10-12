package org.example.core.menu;

import lombok.Builder;

public class Dessert extends MenuItem {
    private int sugarContents;
    private AllergyItems allergyItems;

    @Builder
    private Dessert(long id, String name, int price, MenuCategory category, int stock, int preparationTime,
        int sugarContents, AllergyItems allergyItems) {
        super(id, name, price, category, stock, preparationTime);
        this.sugarContents = sugarContents;
        this.allergyItems = allergyItems;
    }

    @Override
    public String getDescription() {
        String format = "%s - %s (당도: %s, %s)";
        return String.format(format, this.category.getDisplayName(), this.name, this.sugarContents, this.allergyItems);
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
