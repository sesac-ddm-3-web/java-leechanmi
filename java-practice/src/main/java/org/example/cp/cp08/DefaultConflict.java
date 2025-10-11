package org.example.cp.cp08;

import org.example.common.BaseClass;

interface GrandFather {
    default void method() {
        System.out.println("grandfather");
    }
}

interface Father1 extends GrandFather {
    @Override
    default void method() {
        System.out.println("father1");
    }
}

interface Father2 extends GrandFather {
    @Override
    default void method() {
        System.out.println("father2");
    }
}

class Son implements Father1, Father2 {
    @Override
    public void method() {
        System.out.println("son");
    }
}

public class DefaultConflict extends BaseClass {
    @Override
    public void main() {

    }
}
