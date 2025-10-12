package org.example.core.menu;

import org.example.common.IdGenerator;

public class MainDish extends MenuItem {
    private CookingDifficulty difficulty;
    private int calories;

    private MainDish(String id, String name, int price, MenuCategory category, int stock, int preparationTime,
        CookingDifficulty difficulty, int calories) {
        super(id, name, price, category, stock, preparationTime);
        this.difficulty = difficulty;
        this.calories = calories;
    }

    public static MainDish create(String name, int price, MenuCategory category, int stock, int preparationTime,
        CookingDifficulty difficulty, int calories) {
        String id = IdGenerator.generate();

        return new MainDish(id, name, price, category, stock, preparationTime, difficulty, calories);
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

    @Override
    public boolean isAvailable() {
        return stock >= 0;
    }
}
