package org.example.ui;

@FunctionalInterface
public interface MenuAction {

    boolean execute(MenuContext context);
}
