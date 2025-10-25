package org.example.core.menu;

public enum MenuCategory {
    MAIN_DISH("메인 요리"),
    SIDE_DISH("사이드 메뉴"),
    BEVERAGE("음료"),
    DESSERT("디저트");

    private String displayName;

    MenuCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}