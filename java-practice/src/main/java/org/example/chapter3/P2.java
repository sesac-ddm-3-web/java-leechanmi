package org.example.chapter3;

import org.example.common.BaseClass;

public class P2 extends BaseClass {
    @Override
    public void func() {
        int a = 5;
        System.out.println("초기값: a = " + a);

        int b = ++a;
        System.out.println("++a 후: a = " + a + ", b = " + b);

        int c = a++;
        System.out.println("a++ 후: a = " + a + ", c = " + c);

        int d = --a;
        System.out.println("--a 후: a = " + a + ", d = " + d);

        int e = a--;
        System.out.println("a-- 후: a = " + a + ", e = " + e);
    }
}
