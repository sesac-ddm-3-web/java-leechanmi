import java.util.Scanner;

import core.Calculator;
import menu.MenuAction;
import menu.MenuContext;
import menu.MenuRouter;

public class Main {
    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Calculator calculator = Calculator.create();

        MenuContext context = new MenuContext(in, calculator);
        MenuRouter router = new MenuRouter();

        boolean isRunning = true;
        while (isRunning) {
            int menu;
            try {
                menu = getMenuNumber();
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
                continue;
            }

            try {
                MenuAction action = router.get(menu);
                isRunning = action.execute(context);
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }
    }

    public static int getMenuNumber() {
        System.out.println(
            """
                1. 조회
                2. 계산
                0. 종료
                """
        );
        System.out.print("선택: ");

        try {
            int menu = Integer.parseInt(in.nextLine());
            return menu;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식을 입력하세요.");
        }
    }

    public static void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
        System.out.println("다시 시도해주세요.");
        System.out.println();
    }
}
