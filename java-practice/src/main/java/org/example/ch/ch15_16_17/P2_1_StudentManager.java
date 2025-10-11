package org.example.ch.ch15_16_17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.example.common.BaseClass;

class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() { return name; }
    public int getScore() { return score; }

    @Override
    public String toString() {
        return name + "(" + score + "점)";
    }
}

public class P2_1_StudentManager extends BaseClass {
    @Override
    public void main() {
        List<Student> students = Arrays.asList(
            new Student("김철수", 85),
            new Student("이영희", 92),
            new Student("박민수", 78),
            new Student("정지원", 95),
            new Student("최유진", 88)
        );

        // TODO 1: 80점 이상 학생들만 필터링하여 출력
        String over80 = students.stream()
            .filter(s -> s.getScore() >= 80)
            .map(Student::getName)
            .collect(Collectors.joining(", "));

        System.out.println("=== 80점 이상 ===");
        System.out.println(over80);
        System.out.println();

        // TODO 2: 전체 학생 평균 점수 계산 (Optional<Double> 활용)
        System.out.println("=== 평균 ===");

        students.stream()
            .mapToDouble(Student::getScore)
            .average()
            .ifPresent(avg -> System.out.println("평균 점수: " + avg));
        System.out.println();

        // TODO 3: 점수 기준 내림차순 정렬 후 출력
        String nameByScoreDesc = students.stream()
            .sorted(Comparator.comparing(Student::getScore).reversed())
            .map(Student::getName)
            .collect(Collectors.joining(", "));

        System.out.println("=== 점수 기준 내림차순 정렬 ===");
        System.out.println(nameByScoreDesc);
        System.out.println();

        // TODO 4: 이름으로 학생 찾기 (Optional 반환)
        // "박민수" 찾기 -> 있으면 점수 출력, 없으면 "학생을 찾을 수 없습니다" 출력
        System.out.println("=== 이름으로 학생 찾기 - 박민수 ===");
        students.stream()
            .filter(s -> s.getName().equals("박민수"))
            .findFirst()
            .ifPresentOrElse(
                s -> System.out.println("점수: " + s.getScore()),
                () -> System.out.println("학생을 찾을 수 없습니다.")
            );
    }
}
