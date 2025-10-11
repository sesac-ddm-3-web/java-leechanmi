package org.example.ch.ch03;

import org.example.common.BaseClass;

public class P6 extends BaseClass {
    @Override
    public void main() {
        System.out.print("첫 번째 수: ");
        int n1 = in.nextInt();

        System.out.print("두 번째 수: ");
        int n2 = in.nextInt();

        System.out.print("성적: ");
        int score = in.nextInt();

        char grade;
        if (score >= 90) {
            grade = 'A';
        } else if (score >= 80) {
            grade = 'B';
        } else if (score >= 70) {
            grade = 'C';
        } else {
            grade = 'D';
        }

        System.out.println("더 큰 수: " + (n1 > n2 ? n1 : n2));
        System.out.println(n1 + "의 절댓값: " + Math.abs(n1));
        System.out.println("성적 " + score + "의 등급: " + grade);
    }
}
