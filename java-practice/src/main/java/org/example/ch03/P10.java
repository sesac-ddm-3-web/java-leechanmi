package org.example.ch03;

import org.example.common.BaseClass;

public class P10 extends BaseClass {
    @Override
    public void func() {
        System.out.print("국어: ");
        int kor = in.nextInt();

        System.out.print("영어: ");
        int eng = in.nextInt();

        System.out.print("수학: ");
        int math = in.nextInt();

        System.out.print("결석일: ");
        int absent = in.nextInt();

        double avg = (kor + eng + math) / 3.0;

        boolean honor = avg >= 90 && kor >= 80 && eng >= 80 && math >= 80;
        boolean scholarship = avg >= 85 && absent <= 5;
        boolean retest = kor < 60 || eng < 60 || math < 60;
        boolean fail = avg < 60 || absent > 30;

        System.out.println();
        System.out.println("국어: " + kor + "점");
        System.out.println("영어: " + eng + "점");
        System.out.println("수학: " + math + "점");
        System.out.printf("평균: %.2f점%n", avg);
        System.out.println("결석일: " + absent + "일");
        System.out.println();

        System.out.println("우등생: " + honor);
        System.out.println("장학생: " + scholarship);
        System.out.println("재시험 대상: " + retest);
        System.out.println("유급 대상: " + fail);
    }
}
