package org.example.data;

import java.util.ArrayList;

import org.example.core.Restaurant;

public class RestaurantData {

    private RestaurantData() {}

    public static Restaurant buildRestaurant() {
        return Restaurant.builder()
            .name("찬미의 레스토랑")
            .menu(MenuData.buildMenu())
            .orders(new ArrayList<>())
            .paymentHistories(new ArrayList<>())
            .build();
    }
}
