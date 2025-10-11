package menu.actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import core.Calculator;
import menu.MenuAction;
import menu.MenuContext;
import util.ExpressionFormatter;

public class CalculateAction implements MenuAction {
    private final Pattern pattern = Pattern.compile("^[0-9+\\-*/=\\s]+$");

    @Override
    public boolean execute(MenuContext context) {
        String expression = getExpression(context);
        Calculator calculator = context.calculator;
        String result = calculator.calculate(expression);

        System.out.println(ExpressionFormatter.format(expression, result));
        System.out.println();
        return true;
    }

    private String getExpression(MenuContext context) {
        System.out.print("수식: ");
        String expression = context.in.nextLine();

        Matcher matcher = pattern.matcher(expression);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("수식 형식이 잘못 되었습니다. 다시 시도해주세요.");
        }

        return expression;
    }
}
