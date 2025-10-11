package menu;

import java.util.Scanner;

import core.Calculator;

public class MenuContext {
    public final Scanner in;
    public final Calculator calculator;

    public MenuContext(Scanner in, Calculator calculator) {
        this.in = in;
        this.calculator = calculator;
    }
}
