package org.example.ch03;

import org.example.common.BaseClass;

public class P4 extends BaseClass {
    @Override
    public void main() {
        System.out.print("나이: ");
        int age = in.nextInt();

        System.out.print("면허 보유 (true/false): ");
        boolean haveLicense = in.nextBoolean();

        System.out.println("나이: " + age + "세");
        System.out.println("면허 보유: " + haveLicense);
        System.out.println("운전 가능: " + haveLicense);
        System.out.println("음주 가능: " + (age > 19));
        System.out.println("투표 가능: " + (age > 18));
    }
}
