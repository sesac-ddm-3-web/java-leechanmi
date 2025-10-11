package menu.actions;

import menu.MenuAction;
import menu.MenuContext;

public class HistoryViewAction implements MenuAction {
    @Override
    public boolean execute(MenuContext context) {
        System.out.println(context.calculator.getHistories());
        System.out.println();
        return true;
    }
}
