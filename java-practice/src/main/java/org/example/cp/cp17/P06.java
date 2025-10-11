package org.example.cp.cp17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.example.common.BaseClass;

// 중첩된 리스트를 단일 리스트로 만들기 (flatMap)
class Student {
    private String name;
    private List<String> courses; // 수강하는 과목 리스트

    public Student(String name, List<String> courses) {
        this.name = name;
        this.courses = courses;
    }

    public List<String> getCourses() {
        return courses;
    }
}

public class P06 extends BaseClass {
    @Override
    public void main() {
        List<Student> students = Arrays.asList(
            new Student("Alice", Arrays.asList("Java", "Math")),
            new Student("Bob", Arrays.asList("Math", "English")),
            new Student("Charlie", Arrays.asList("Java", "History"))
        );

        List<String> allCourses = new ArrayList<>();
        // for (Student student : students) {
        //     for (String course : student.getCourses()) {
        //         allCourses.add(course);
        //     }
        // }
        allCourses = students.stream()
            .flatMap(s -> s.getCourses().stream())
            .toList();

        // 중복을 제거하지 않은 전체 수강 과목 리스트
        System.out.println(allCourses); // [Java, Math, Math, English, Java, History]
    }
}
