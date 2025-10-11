package org.example.cp.cp08;

import org.example.common.BaseClass;

interface Movable {
    void move();
}

interface Flyable extends Movable {
    void fly();
}

interface Swimable extends Movable {
    void swim();
}

interface Attackable {
    void attack();
}

interface MagicAttackable extends Attackable {
    void magicAttack();
}

class Dragon implements Flyable, MagicAttackable {
    private final String name = "드래곤";

    @Override
    public void attack() {
        System.out.printf("%s이 물리 공격을 합니다.%n", name);
    }

    @Override
    public void fly() {
        System.out.printf("%s이 하늘을 날아갑니다.%n", name);
    }

    @Override
    public void magicAttack() {
        System.out.printf("%s이 마법 공격을 합니다!%n", name);
    }

    @Override
    public void move() {
        System.out.printf("%s이 이동합니다.%n", name);
    }
}

class Fish implements Swimable {
    private final String name = "물고기";

    @Override
    public void swim() {
        System.out.printf("%s가 수영합니다.%n", name);
    }

    @Override
    public void move() {
        System.out.printf("%s가 이동합니다.%n", name);
    }
}

class Warrior implements Movable, Attackable {
    private final String name = "전사";

    @Override
    public void attack() {
        System.out.printf("%s가 물리 공격을 합니다.%n", name);
    }

    @Override
    public void move() {
        System.out.printf("%s가 이동합니다.%n", name);
    }
}

public class P05 extends BaseClass {
    @Override
    public void main() {
        // 각 캐릭터 객체 생성
        Dragon dragon = new Dragon();
        Fish fish = new Fish();
        Warrior warrior = new Warrior();

        // 드래곤의 모든 기능 실행
        dragon.move();
        dragon.fly();
        dragon.attack();
        dragon.magicAttack();
        System.out.println(); // 줄 바꿈

        // 물고기의 모든 기능 실행
        fish.move();
        fish.swim();
        System.out.println(); // 줄 바꿈

        // 전사의 모든 기능 실행
        warrior.move();
        warrior.attack();
    }
}
