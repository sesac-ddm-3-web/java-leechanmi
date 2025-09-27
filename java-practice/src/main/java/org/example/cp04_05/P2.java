package org.example.cp04_05;

import org.example.common.BaseClass;

// for 문으로 작성된 코드를 while 문으로 바꿔보기
public class P2 extends BaseClass {
    @Override
    public void func() {
        int sum = 0;

        // 초기화, 조건식, 증감식이 한 줄에 명확하게 표현됨
        // for (int i = 1; i <= 5; i++) {
        //     sum += i;
        // }

        int i = 1;
        while (i <= 5) {
            sum += i++;
        }

        System.out.println("1부터 5까지의 합: " + sum); // 결과: 15
    }
}
