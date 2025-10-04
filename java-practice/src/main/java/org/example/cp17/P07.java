package org.example.cp17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.example.common.BaseClass;

// 부서별 평균 연봉 계산하기
class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

public class P07 extends BaseClass {
    @Override
    public void main() {
        List<Employee> employees = Arrays.asList(
            new Employee("James", "개발팀", 5500),
            new Employee("Robert", "개발팀", 6000),
            new Employee("Maria", "기획팀", 5800),
            new Employee("Linda", "기획팀", 6200),
            new Employee("David", "인사팀", 5300)
        );

        // 1. 부서별로 급여 리스트를 만든다.
        Map<String, List<Double>> salariesByDept = new HashMap<>();
        for (Employee e : employees) {
            salariesByDept
                .computeIfAbsent(e.getDepartment(), k -> new ArrayList<>())
                .add(e.getSalary());
        }

        // 2. 부서별 급여 리스트를 가지고 평균을 계산한다.
        Map<String, Double> avgSalaryByDept = new HashMap<>();
        for (Map.Entry<String, List<Double>> entry : salariesByDept.entrySet()) {
            double sum = 0;
            for (double salary : entry.getValue()) {
                sum += salary;
            }
            avgSalaryByDept.put(entry.getKey(), sum / entry.getValue().size());
        }

        Map<String, Double> result = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
            ));

        System.out.println(result);
        // {인사팀=5300.0, 개발팀=5750.0, 기획팀=6000.0}
    }
}
