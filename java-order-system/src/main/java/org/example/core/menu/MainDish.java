package org.example.core.menu;

import lombok.Builder;

public class MainDish extends MenuItem {
    private CookingDifficulty difficulty;
    private int calories;

    @Builder
    private MainDish(long id, String name, int price, MenuCategory category, int stock, int preparationTime,
        CookingDifficulty difficulty, int calories) {
        super(id, name, price, category, stock, preparationTime);
        this.difficulty = difficulty;
        this.calories = calories;
    }

    @Override
    public String getDescription() {
        String format = "%s - %s (난이도: %s, %dkcal)";
        return String.format(format, this.category.getDisplayName(), this.name, difficulty.name(), calories);
    }

    @Override
    public int getPreparationTime() {
        return this.preparationTime;
    }

}
