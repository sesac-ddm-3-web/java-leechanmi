package org.example.ch02;

import org.example.common.BaseClass;

public class P2 extends BaseClass {
    private static final String FORMAT = "%s %s바이트, 범위: %s ~ %s";

    @Override
    public void func() {
        System.out.println(String.format(FORMAT, "byte:", Byte.SIZE, Byte.MIN_VALUE, Byte.MAX_VALUE));
        System.out.println(String.format(FORMAT, "short:", Short.SIZE, Short.MIN_VALUE, Short.MAX_VALUE));
        System.out.println(String.format(FORMAT, "int:", Integer.SIZE, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(String.format(FORMAT, "long:", Long.SIZE, Long.MIN_VALUE, Long.MAX_VALUE));
        System.out.println(String.format(FORMAT, "float:", Float.SIZE, Float.MIN_VALUE, Float.MAX_VALUE));
        System.out.println(String.format(FORMAT, "double:", Double.SIZE, Double.MIN_VALUE, Double.MAX_VALUE));
        System.out.println(String.format(FORMAT, "char:", Character.SIZE, (int) Character.MIN_VALUE, (int) Character.MAX_VALUE));
        System.out.println(String.format(FORMAT, "boolean:", 1, Boolean.FALSE, Boolean.TRUE));
    }
}
