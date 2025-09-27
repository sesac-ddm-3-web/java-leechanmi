package org.example.ch03;

import org.example.common.BaseClass;

public class P1 extends BaseClass {
    @Override
    public void main() {
        System.out.print("첫 번째 수: ");
        int num1 = in.nextInt();

        System.out.print("두 번째 수: ");
        int num2 = in.nextInt();

        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
        System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
        System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
        System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
        System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));
    }
}
