package org.example.chapter3;

import org.example.common.BaseClass;

public class P8 extends BaseClass {
    @Override
    public void func() {
        int a = 10, b = 20, c = 30;

        System.out.println("a = " + a + ", b = " + b + ", c = " + c);
        System.out.println();

        int result1 = a + b * c;
        System.out.println("result1 = a + b * c = " + a + " + (" + b + " * " + c + ")"
            + " = " + a + " + " + (b * c) + " = " + result1);

        int result2 = (a + b) * c;
        System.out.println("result2 = (a + b) * c = (" + a + " + " + b + ") * " + c
            + " = " + (a + b) + " * " + c + " = " + result2);

        int result3 = a > b ? a : b + c;
        System.out.println("result3 = a > b ? a : b + c = " + a + " > " + b
            + " ? " + a + " : " + b + " + " + c
            + " = " + (a > b) + " ? " + a + " : " + (b + c)
            + " = " + result3);

        boolean result4 = a + b > c && b - a < c;
        System.out.println("result4 = a + b > c && b - a < c = "
            + a + " + " + b + " > " + c + " && " + b + " - " + a + " < " + c
            + " = " + (a + b) + " > " + c + " && " + (b - a) + " < " + c
            + " = " + (a + b > c) + " && " + (b - a < c)
            + " = " + result4);
    }
}
