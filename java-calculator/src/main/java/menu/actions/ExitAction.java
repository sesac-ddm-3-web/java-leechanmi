package menu.actions;

import menu.MenuAction;
import menu.MenuContext;

public class ExitAction implements MenuAction {
    @Override
    public boolean execute(MenuContext context) {
        return false;
    }
}
