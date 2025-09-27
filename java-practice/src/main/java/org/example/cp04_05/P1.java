package org.example.cp04_05;

import org.example.common.BaseClass;

// while 문으로 작성된 코드를 for 문으로 바꿔보기
public class P1 extends BaseClass {
    @Override
    public void main() {
        String input = "";

        // while (!input.equals("exit")) {
        //     System.out.print("입력 (종료하려면 exit): ");
        //     input = in.next();
        //     System.out.println("사용자 입력: " + input);
        // }

        for (boolean isExit = false; !isExit; ) {
            System.out.print("입력 (종료하려면 exit): ");
            input = in.nextLine();
            System.out.println("사용자 입력: " + input);

            if (input.equals("exit")) {
                isExit = true;
            }
        }

        System.out.println("프로그램을 종료합니다.");
        in.close();

    }
}
