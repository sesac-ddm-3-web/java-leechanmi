package org.example.cp.cp_enum;

/**
 * 할인 종류에 따라 가격을 계산하는 클래스.
 * if-else 문을 사용하여 로직을 분기하고 있어 변경에 취약하다.
 */
public class PriceCalculator {

    /**
     * 원가, 할인 값, 할인 종류를 받아 최종 가격을 계산한다.
     *
     * @param originalPrice 원가
     * @param discountValue 할인 값 (퍼센트 또는 고정 금액)
     * @param type          할인 종류 (DiscountType Enum)
     * @return 최종 가격
     */
    public long calculate(long originalPrice, long discountValue, DiscountType type) {
        // 타입에 따라 분기하여 할인 로직을 적용
        long discountedPrice = type.discount(originalPrice, discountValue);

        // 최종 가격이 0보다 작으면 0으로 처리
        return Math.max(0, discountedPrice);
    }
}

