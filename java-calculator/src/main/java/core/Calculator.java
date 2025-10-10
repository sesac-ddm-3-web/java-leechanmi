package core;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final CalculatorLog log;

    public Calculator(CalculatorLog log) {
        this.log = log;
    }

    public String calculate(String expression) {
        // 기록에 있는지 검색
        String cached = log.getFromCache(expression);
        if (cached != null) {
            return cached;
        }

        List<String> ops = parseExpression(expression);

        // 곱셉, 나눗셈 계산
        for (int i = 1; i < ops.size() - 1; i += 2) {
            String op = ops.get(i);
            if (isMulDiv(op)) {
                BigDecimal left = new BigDecimal(ops.get(i - 1));
                BigDecimal right = new BigDecimal(ops.get(i + 1));
                BigDecimal mid = apply(op, left, right);

                ops.set(i - 1, mid.toPlainString());
                ops.remove(i + 1);
                ops.remove(i);
            }
        }

        // 덧셈, 뺄셈 계산
        BigDecimal result = new BigDecimal(ops.getFirst());
        for (int i = 1; i < ops.size() - 1; i += 2) {
            String op = ops.get(i);
            BigDecimal right = new BigDecimal(ops.get(i + 1));
            result = apply(op, result, right);
        }

        String output = result.toPlainString();
        log.save(expression, output);

        return output;
    }

    public String getHistories() {
        return log.getHistories();
    }

    private List<String> parseExpression(String expression) {
        List<String> ops = new ArrayList<>(List.of(expression.split("\\s+")));
        if (ops.size() % 2 == 0) {
            throw new IllegalArgumentException("유효하지 않은 수식: " + expression);
        }
        return ops;
    }

    private BigDecimal apply(String operator, BigDecimal a, BigDecimal b) {
        return CalculatorFunction.find(operator)
            .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 연산자: " + operator))
            .apply(a, b);
    }

    private boolean isMulDiv(String operator) {
        return (
            CalculatorFunction.MUL.getOperator().equals(operator)
                || CalculatorFunction.DIV.getOperator().equals(operator)
        );
    }
}
