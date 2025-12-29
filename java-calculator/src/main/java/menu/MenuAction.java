package menu;

@FunctionalInterface
public interface MenuAction {

    boolean execute(MenuContext context);
}
