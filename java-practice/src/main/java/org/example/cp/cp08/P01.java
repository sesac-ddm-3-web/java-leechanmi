package org.example.cp.cp08;

import org.example.common.BaseClass;

interface Shape {
    double calculateArea();

    double calculatePerimeter();
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * width + 2 * height;
    }
}

public class P01 extends BaseClass {
    @Override
    public void main() {
        // Shape 인터페이스는 Circle과 Rectangle 객체를 모두 참조할 수 있습니다.
        Shape circle = new Circle(5.0); // 반지름 5
        Shape rectangle = new Rectangle(4.0, 5.0); // 가로 4, 세로 5

        System.out.printf("원의 넓이: %.2f\n", circle.calculateArea());
        System.out.printf("원의 둘레: %.2f\n", circle.calculatePerimeter());

        System.out.printf("직사각형의 넓이: %.1f\n", rectangle.calculateArea());
        System.out.printf("직사각형의 둘레: %.1f\n", rectangle.calculatePerimeter());
    }
}
