package org.example.ch02;

import org.example.common.BaseClass;

public class P8 extends BaseClass {
    static int globalVar = 100;  // 전역 변수

    @Override
    public void main() {
        int localVar = 10;       // 지역 변수

        System.out.println("메인 메소드에서:");
        // globalVar와 localVar 출력
        System.out.println(globalVar);
        System.out.println(localVar);

        {
            int blockVar = 20;   // 블록 변수
            // 여기서 접근 가능한 변수들을 모두 출력
            System.out.println(globalVar);
            System.out.println(localVar);
            System.out.println(blockVar);
        }

        // blockVar에 접근하려고 하면 어떻게 될까?
        // System.out.println(blockVar); // 주석 해제 시 오류 발생
    }
}
