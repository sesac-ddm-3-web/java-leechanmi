package org.example.ui.actions;

import org.example.common.exception.NotFoundException;
import org.example.core.Restaurant;
import org.example.core.customer.Orderer;
import org.example.core.menu.MenuItem;
import org.example.ui.MenuAction;
import org.example.ui.MenuContext;

public class OrderMenuAction implements MenuAction {
    @Override
    public boolean execute(MenuContext context) {
        boolean running = true;
        Restaurant restaurant = context.restaurant;
        Orderer orderer = context.orderer;

        System.out.println();
        System.out.println("===== 주문하기 =====");
        while (running) {
            System.out.print("메뉴 번호 입력: ");
            long menuId = context.in.nextInt();

            System.out.print("수량 입력: ");
            int quantity = context.in.nextInt();

            MenuItem menu;
            try {
                menu = restaurant.findMenuById(menuId);
            } catch (NotFoundException e) {
                System.out.println(e.getMessage());
                System.out.println("다시 입력해주세요.");
                System.out.println();
                continue;
            }
            orderer.getCart().addItem(menu, quantity);

            System.out.printf("✅ '%s' %d개가 장바구니에 추가되었습니다.%n", menu.getName(), quantity);
            System.out.print("계속 주문하시겠습니까? (y/n): ");
            String input = context.in.next().toLowerCase();
            System.out.println();

            running = input.equals("y");
        }

        System.out.println(orderer.getCart());
        System.out.println();
        return true;
    }
}
