package org.example.core.menu;

import org.example.common.IdGenerator;

public class Dessert extends MenuItem {
    private int sugarContents;
    private AllergyItems allergyItems;

    protected Dessert(String id, String name, int price, MenuCategory category, int stock, int preparationTime,
        int sugarContents, AllergyItems allergyItems) {
        super(id, name, price, category, stock, preparationTime);
    }

    public static Dessert create(String name, int price, MenuCategory category, int stock, int preparationTime,
        int sugarContents, AllergyItems allergyItems) {
        String id = IdGenerator.generate();
        return new Dessert(id, name, price, category, stock, preparationTime, sugarContents, allergyItems);
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
