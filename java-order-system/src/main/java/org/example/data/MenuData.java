package org.example.data;

import static org.example.core.menu.AllergyItems.AllergyItem.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.core.menu.Beverage;
import org.example.core.menu.CookingDifficulty;
import org.example.core.menu.Dessert;
import org.example.core.menu.FoodSize;
import org.example.core.menu.MainDish;
import org.example.core.menu.MenuCategory;
import org.example.core.menu.MenuItem;
import org.example.core.menu.SideDish;
import org.example.core.menu.TemperatureOption;
import org.example.core.menu.AllergyItems;

public final class MenuData {

    private MenuData() {}

    public static Map<MenuCategory, List<MenuItem>> buildMenu() {
        Map<MenuCategory, List<MenuItem>> menu = new HashMap<>();
        menu.put(MenuCategory.MAIN_DISH, mainDishes());
        menu.put(MenuCategory.SIDE_DISH, sideDishes());
        menu.put(MenuCategory.BEVERAGE, beverages());
        menu.put(MenuCategory.DESSERT, desserts());
        return menu;
    }

    private static List<MenuItem> mainDishes() {
        List<MenuItem> list = new ArrayList<>();
        list.add(MainDish.builder()
            .id(1L).name("스테이크").price(25_000)
            .category(MenuCategory.MAIN_DISH).stock(5).preparationTime(30)
            .difficulty(CookingDifficulty.HIGH).calories(800)
            .build());
        list.add(MainDish.builder()
            .id(2L).name("파스타").price(15_000)
            .category(MenuCategory.MAIN_DISH).stock(8).preparationTime(20)
            .difficulty(CookingDifficulty.MEDIUM).calories(600)
            .build());
        list.add(MainDish.builder()
            .id(3L).name("그릴 치킨").price(14_000)
            .category(MenuCategory.MAIN_DISH).stock(6).preparationTime(22)
            .difficulty(CookingDifficulty.MEDIUM).calories(650)
            .build());
        list.add(MainDish.builder()
            .id(4L).name("비프 스튜").price(16_000)
            .category(MenuCategory.MAIN_DISH).stock(4).preparationTime(35)
            .difficulty(CookingDifficulty.HIGH).calories(700)
            .build());
        list.add(MainDish.builder()
            .id(5L).name("리조또").price(13_000)
            .category(MenuCategory.MAIN_DISH).stock(7).preparationTime(25)
            .difficulty(CookingDifficulty.MEDIUM).calories(580)
            .build());
        return list;
    }

    private static List<MenuItem> sideDishes() {
        List<MenuItem> list = new ArrayList<>();
        list.add(SideDish.builder()
            .id(6L).name("감자튀김").price(5_000)
            .category(MenuCategory.SIDE_DISH).stock(15).preparationTime(10)
            .size(FoodSize.MEDIUM)
            .build());
        list.add(SideDish.builder()
            .id(7L).name("샐러드").price(7_000)
            .category(MenuCategory.SIDE_DISH).stock(10).preparationTime(5)
            .size(FoodSize.LARGE)
            .build());
        list.add(SideDish.builder()
            .id(8L).name("마늘빵").price(4_000)
            .category(MenuCategory.SIDE_DISH).stock(12).preparationTime(6)
            .size(FoodSize.MEDIUM)
            .build());
        list.add(SideDish.builder()
            .id(9L).name("양송이 수프").price(4_500)
            .category(MenuCategory.SIDE_DISH).stock(9).preparationTime(7)
            .size(FoodSize.SMALL)
            .build());
        list.add(SideDish.builder()
            .id(10L).name("오니온 링").price(4_500)
            .category(MenuCategory.SIDE_DISH).stock(11).preparationTime(8)
            .size(FoodSize.MEDIUM)
            .build());
        return list;
    }

    private static List<MenuItem> beverages() {
        List<MenuItem> list = new ArrayList<>();
        list.add(Beverage.builder()
            .id(11L).name("콜라").price(3_000)
            .category(MenuCategory.BEVERAGE).stock(25).preparationTime(2)
            .capacity(500).temperatureOption(TemperatureOption.COLD)
            .build());
        list.add(Beverage.builder()
            .id(12L).name("사이다").price(3_000)
            .category(MenuCategory.BEVERAGE).stock(20).preparationTime(2)
            .capacity(500).temperatureOption(TemperatureOption.COLD)
            .build());
        list.add(Beverage.builder()
            .id(13L).name("아메리카노").price(4_000)
            .category(MenuCategory.BEVERAGE).stock(18).preparationTime(3)
            .capacity(355).temperatureOption(TemperatureOption.HOT)
            .build());
        list.add(Beverage.builder()
            .id(14L).name("오렌지 주스").price(4_500)
            .category(MenuCategory.BEVERAGE).stock(14).preparationTime(3)
            .capacity(400).temperatureOption(TemperatureOption.COLD)
            .build());
        list.add(Beverage.builder()
            .id(15L).name("레몬에이드").price(4_500)
            .category(MenuCategory.BEVERAGE).stock(16).preparationTime(3)
            .capacity(450).temperatureOption(TemperatureOption.COLD)
            .build());
        return list;
    }

    private static List<MenuItem> desserts() {
        List<MenuItem> list = new ArrayList<>();
        list.add(Dessert.builder()
            .id(16L).name("초코케이크").price(7_000)
            .category(MenuCategory.DESSERT).stock(8).preparationTime(3)
            .sugarContents(2) // MEDIUM
            .allergyItems(AllergyItems.of(WHEAT, MILK, EGG))
            .build());
        list.add(Dessert.builder()
            .id(17L).name("티라미수").price(8_000)
            .category(MenuCategory.DESSERT).stock(0).preparationTime(3)
            .sugarContents(1) // LOW
            .allergyItems(AllergyItems.of(WHEAT, MILK, EGG))
            .build());
        list.add(Dessert.builder()
            .id(18L).name("치즈케이크").price(7_500)
            .category(MenuCategory.DESSERT).stock(6).preparationTime(3)
            .sugarContents(2)
            .allergyItems(AllergyItems.of(WHEAT, MILK, EGG))
            .build());
        list.add(Dessert.builder()
            .id(19L).name("마카롱").price(3_500)
            .category(MenuCategory.DESSERT).stock(10).preparationTime(2)
            .sugarContents(3) // HIGH
            .allergyItems(AllergyItems.of(EGG, MILK))
            .build());
        list.add(Dessert.builder()
            .id(20L).name("바닐라 아이스크림").price(3_500)
            .category(MenuCategory.DESSERT).stock(9).preparationTime(2)
            .sugarContents(2)
            .allergyItems(AllergyItems.of(MILK))
            .build());
        return list;
    }
}