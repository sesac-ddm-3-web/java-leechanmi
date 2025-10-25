package org.example.ui;

import java.util.Map;

import org.example.ui.actions.DisplayMenuAction;
import org.example.ui.actions.ExitMenuAction;
import org.example.ui.actions.OrderMenuAction;
import org.example.ui.actions.PaymentMenuAction;

public class MenuRouter {
    private final Map<Integer, MenuAction> actions = Map.of(
        1, new DisplayMenuAction(),
        2, new OrderMenuAction(),
        3, new PaymentMenuAction(),
        4, new ExitMenuAction()
    );

    public MenuAction get(int menu) {
        MenuAction action = actions.get(menu);
        if (action == null) {
            throw new IllegalArgumentException("유효하지 않은 메뉴 번호: " + menu);
        }

        return action;
    }
}
