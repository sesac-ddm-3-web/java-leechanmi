package org.example.ch09;

import org.example.common.BaseClass;

class Computer {
    private String brand;
    private String model;

    public Computer(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    // static 중첩 클래스는 사실상 Computer.StaticCPU 라는 이름을 가진 일반 클래스
    // 외부 클래스의 인스턴스에 전혀 의존하지 않는 독립적인 클래스
    static class StaticCPU {
        private int cores;
        private double speed;

        public StaticCPU(int cores, double speed) {
            this.cores = cores;
            this.speed = speed;
        }

        String getSpecification() {
            return this.cores + "코어, " + this.speed+ "GHz";
        }
    }

    // static 클래스를 상속해도 일반 클래스와 똑같이 동작
    class NonStaticCPU extends StaticCPU{
        public NonStaticCPU(int cores, double speed) {
            super(cores, speed);
        }
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}

public class P01 extends BaseClass {
    @Override
    public void main() {
        // 1. 외부 클래스를 통해 정적 중첩 클래스 생성
        Computer myComputer = new Computer("SAMSUNG", "Galaxy Book");
        Computer.StaticCPU staticCpu = new Computer.StaticCPU(8, 3.2);

        System.out.println("컴퓨터: " + myComputer.getBrand() + " " + myComputer.getModel());
        System.out.println("CPU 사양: " + staticCpu.getSpecification());

        // 2. 외부 클래스 인스턴스 없이 직접 정적 중첩 클래스 생성
        Computer.StaticCPU anotherStaticCpu = myComputer.new NonStaticCPU(4, 2.8);
        System.out.println("컴퓨터 외부에서 CPU 생성: " + anotherStaticCpu.getSpecification());
    }
}
