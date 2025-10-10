package menu;

import java.util.Map;

import menu.actions.CalculateAction;
import menu.actions.ExitAction;
import menu.actions.HistoryViewAction;

public class MenuRouter {
    private final Map<Integer, MenuAction> actions = Map.of(
        0, new ExitAction(),
        1, new HistoryViewAction(),
        2, new CalculateAction()
        );

    public MenuAction get(int menu) {
        MenuAction action = actions.get(menu);
        if (action == null) {
            throw new IllegalArgumentException("유효하지 않은 메뉴 번호: " + menu);
        }

        return action;
    }
}
