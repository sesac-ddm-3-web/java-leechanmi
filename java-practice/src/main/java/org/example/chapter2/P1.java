package org.example.chapter2;

import org.example.common.BaseClass;

public class P1 extends BaseClass {

	@Override
	public void func() {
		int age = 25;
		double height = 175.5;
		char grade = 'A';
		boolean isStudent = true;

		System.out.printf("나이: %d\n", age);
		System.out.printf("키: %.1f\n", height);
		System.out.printf("학점: %s\n", grade);
		System.out.printf("학생 여부: %s\n", isStudent);
	}
}
