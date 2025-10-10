package core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

class CalculatorTest {

    @Test
    @DisplayName("[성공] 정수 계산")
    void testOperatorPrecedence() {
        Calculator calc = new Calculator(new CalculatorLog());
        String result = calc.calculate("1 + 2 * 3");

        assertEquals("7", result);
        assertEquals(new BigDecimal("7"), new BigDecimal(result));
    }

    @Test
    @DisplayName("[성공] 실수 계산")
    void testDecimalOperation() {
        Calculator calc = new Calculator(new CalculatorLog());
        String result = calc.calculate("10 / 4 + 1.5 * 2");

        assertEquals("5.5", result);
        assertEquals(new BigDecimal("5.5"), new BigDecimal(result));
    }

    @Test
    @DisplayName("[성공] 음수 계산")
    void testUnaryMinus() {
        Calculator calc = new Calculator(new CalculatorLog());
        String result = calc.calculate("-2 * 3 + 5");

        assertEquals("-1", result);
        assertEquals(new BigDecimal("-1"), new BigDecimal(result));
    }

    @Test
    @DisplayName("[성공] 같은 수식은 캐시에서 가져오기")
    void testCachedResult() {
        CalculatorLog log = new CalculatorLog();
        Calculator calc = new Calculator(log);

        String first = calc.calculate("2 * 5 + 1");
        String second = calc.calculate("2 * 5 + 1");

        assertEquals("11", first);
        assertEquals("11", second);
    }

    @Test
    @DisplayName("[실패] 유효하지 않은 연산자 사용 시 예외 발생")
    void testInvalidOperator() {
        Calculator calc = new Calculator(new CalculatorLog());
        Exception e = assertThrows(IllegalArgumentException.class, () -> calc.calculate("1 ^ 2"));
        assertTrue(e.getMessage().contains("유효하지 않은 연산자"));
    }

    @Test
    @DisplayName("[실패] 유효하지 않은 수식 예외 발생")
    void testInvalidExpressionLength() {
        Calculator calc = new Calculator(new CalculatorLog());
        Exception e = assertThrows(IllegalArgumentException.class, () -> calc.calculate("1 +"));
        assertTrue(e.getMessage().contains("유효하지 않은 수식"));
    }
}