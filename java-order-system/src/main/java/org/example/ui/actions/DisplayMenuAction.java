package org.example.ui.actions;

import org.example.ui.MenuAction;
import org.example.ui.MenuContext;

public class DisplayMenuAction implements MenuAction {
    @Override
    public boolean execute(MenuContext context) {
        System.out.println();
        System.out.println("===== 메뉴 상세 정보 =====");
        context.restaurant.displayMenu();
        return true;
    }
}
