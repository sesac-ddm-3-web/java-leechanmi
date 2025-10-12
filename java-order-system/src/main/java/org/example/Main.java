package org.example;

import java.util.Scanner;

import org.example.core.Restaurant;
import org.example.core.customer.Orderer;
import org.example.data.OrdererData;
import org.example.data.RestaurantData;
import org.example.ui.MenuAction;
import org.example.ui.MenuContext;
import org.example.ui.MenuRouter;

public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Restaurant restaurant = RestaurantData.buildRestaurant();
        Orderer orderer = OrdererData.buildOrderer();

        MenuContext context = new MenuContext(in, restaurant, orderer);
        MenuRouter router = new MenuRouter();

        boolean running = true;
        while (running) {
            printMainMenu();
            int menuNumber = getMenuNumber();

            MenuAction action = router.get(menuNumber);
            running = action.execute(context);
        }
    }

    public static void printMainMenu() {
        System.out.println("""
            ===== 🍽️ 레스토랑 주문 시스템 =====
            
            1. 메뉴 보기
            2. 주문하기
            3. 결제하기
            4. 종료
            """
        );
    }

    public static int getMenuNumber() {
        System.out.print("선택: ");
        return in.nextInt();
    }
}