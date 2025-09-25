package org.example.chapter2;

import org.example.common.BaseClass;

public class P3 extends BaseClass {
    @Override
    public void func() {
        byte b = 10;
        int i = b;        // byte → int
        long l = i;       // int → long
        float f = l;      // long → float
        double d = f;     // float → double

        System.out.printf("""
            byte b = %s
            int i = %s
            long l = %s
            float f = %s
            double d = %s
            """, b, i, l, f, d);
    }
}
