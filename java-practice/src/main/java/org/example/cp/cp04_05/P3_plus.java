package org.example.cp.cp04_05;

import org.example.common.BaseClass;

// 1000페이지 책에서 숨겨진 페이지 찾기 (자동 계산)
public class P3_plus extends BaseClass {
    private final int RETRY_COUNT = 10;

    @Override
    public void main() {
        int page = (int)(Math.random() * 1000) + 1;

        System.out.println("두꺼운 책의 아무 페이지나 펼쳤습니다. 몇 페이지일까요? (1~1000, 기회: 10번)");
        System.out.println("page = " + page);

        int left = 1;
        int right = 1000;

        int cnt = 1;
        while (true) {
            if (cnt > RETRY_COUNT) {
                System.out.printf("아쉽네요. 모든 페이지를 넘겨봤지만 찾지 못했습니다. 정답은 %d쪽 입니다.\n", page);
                break;
            }

            System.out.printf("%d번째 시도: ", cnt);
            // int guess = in.nextInt();
            int mid = (left + right) / 2;
            System.out.println("page = " + mid);

            if (page > mid) {
                left = mid + 1;
                System.out.println("더 뒷장이에요! (Up!)");
            } else if (page < mid) {
                right = mid - 1;
                System.out.println("더 앞장이에요! (Down!)");
            } else {
                System.out.println("정답입니다! 책을 찾았네요.");
                System.out.printf("축하합니다! %d번 만에 페이지를 찾았습니다.\n", cnt);
                break;
            }

            cnt++;
        }
    }
}
