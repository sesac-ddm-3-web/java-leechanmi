package org.example.ch02;

import org.example.common.BaseClass;

public class P7 extends BaseClass {
    @Override
    public void main() {
        System.out.print("이름: ");
        String name = in.nextLine();

        System.out.print("나이: ");
        int age = in.nextInt();

        System.out.print("키: ");
        double height = in.nextDouble();

        System.out.print("결혼 여부: ");
        boolean isMarried = in.nextBoolean();

        // 출력
        System.out.println("\n=== 입력된 정보 ===");
        System.out.println("이름: " + name);
        System.out.println("나이: " + age + "세");
        System.out.println("키: " + height + "cm");
        System.out.println("결혼 여부: " + (isMarried ? "기혼" : "미혼"));
    }
}
