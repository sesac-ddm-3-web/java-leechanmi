package org.example.cp.cp_enum;

import java.util.function.BiFunction;

public enum DiscountType {
    PERCENTAGE((originalPrice, discountValue) -> originalPrice - (originalPrice * discountValue / 100)),
    FIXED_AMOUNT(((originalPrice, discountValue) -> originalPrice - discountValue)),
    FIXED_AMOUNT_DOUBLE((originalPrice, discountValue) -> originalPrice - 2 * discountValue),
    PERCENTAGE_DOUBLE((originalPrice, discountValue) -> originalPrice - 2 * (originalPrice * discountValue / 100))
    ;

    private final BiFunction<Long, Long, Long> expression;

    DiscountType(BiFunction<Long, Long, Long> expression) {
        this.expression = expression;
    }

    public long discount(long originalPrice, long discountValue) {
        return this.expression.apply(originalPrice, discountValue);
    }
}
