package org.example.chapter3;

import org.example.common.BaseClass;

public class P11 extends BaseClass {

    @Override
    public void func() {
        System.out.print("첫 번째 수: ");
        double n1 = in.nextDouble();

        System.out.print("연산자: ");
        String operator = in.next();

        System.out.print("두 번째 수: ");
        double n2 = in.nextDouble();

        try {
            double result = switch (operator) {
                case "+" -> n1 + n2;
                case "-" -> n1 - n2;
                case "*" -> n1 * n2;
                case "/" -> {
                    if (n2 == 0) {
                        throw new RuntimeException("0으로 나눌 수 없습니다.");
                    }
                    yield n1 / n2;
                }
                case "%" -> {
                    if (n2 == 0) {
                        throw new RuntimeException("0으로 나눌 수 없습니다.");
                    }
                    yield n1 % n2;
                }
                default -> throw new RuntimeException("유효한 연산자가 아닙니다.");
            };

            System.out.println(n1 + " " + operator + " " + n2 + " = " + result);
        } catch (RuntimeException e) {
            System.out.println("첫 번째 수: " + n1);
            System.out.println("연산자: " + operator);
            System.out.println("두 번째 수: " + n1);
            System.out.println("결과: 오류 - " + e.getMessage());
        }
    }
}
