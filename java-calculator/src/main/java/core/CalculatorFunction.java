package core;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public enum CalculatorFunction {
    ADD("+", BigDecimal::add),
    SUB("-", BigDecimal::subtract),
    MUL("*", BigDecimal::multiply),
    DIV("/", BigDecimal::divide),
    ;

    private final String operator;
    private final BiFunction<BigDecimal, BigDecimal, BigDecimal> operation;

    CalculatorFunction(String operator, BiFunction<BigDecimal, BigDecimal, BigDecimal> operation) {
        this.operator = operator;
        this.operation = operation;
    }

    public BigDecimal apply(BigDecimal op1, BigDecimal op2) {
        return this.operation.apply(op1, op2);
    }

    public static Optional<CalculatorFunction> find(String operator) {
        return Arrays.stream(values())
            .filter(func -> func.operator.equals(operator))
            .findAny();
    }

    public String getOperator() {
        return operator;
    }
}
