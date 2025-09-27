package org.example.cp06;

import org.example.common.BaseClass;

public class P02_GameMain extends BaseClass {
    class GameCharacter {
        private String name;
        private int level;
        private int hp;
        private int maxHp;

        public GameCharacter(String name) {
            this.name = name;
            this.level = 1;
            this.maxHp = 100;
            this.hp = 100;
        }

        public void takeDamage(int damage) {
            this.hp = this.hp - damage;

            if (this.hp < 0) {
                this.hp = 0;
            }

            System.out.printf("%s이(가) %d의 피해를 입었습니다! (남은 HP: %d)%n", this.name, damage, this.hp);
        }

        public void recoverHp(int amount) {
            this.hp = this.hp + amount;

            if (this.hp > maxHp) {
                this.hp = maxHp;
            }

            System.out.printf("%s이(가) HP를 %d만큼 회복했습니다. (현재 HP: %d)%n", this.name, amount, this.hp);
        }

        public void levelUp() {
            this.level += 1;
            this.maxHp += 20;
            this.hp = this.maxHp;

            System.out.printf("레벨 업! %s의 레벨이 %d가 되었습니다. (최대 HP: %d)%n", this.name, this.level, this.maxHp);
        }

        public void getCharacterInfo() {
            System.out.printf("이름: %s, 레벨: %d, HP: %d/%d%n", this.name, this.level, this.hp, this.maxHp);
        }
    }

    @Override
    public void main() {
        // 1. '전사' 캐릭터 생성
        System.out.println("새로운 캐릭터 '전사'를 생성합니다.");
        GameCharacter warrior = new GameCharacter("전사");
        warrior.getCharacterInfo();
        System.out.println();

        // 2. 몬스터에게 30의 피해를 입음
        System.out.println("## 전투 시작 ##");
        warrior.takeDamage(30);
        System.out.println();

        // 3. 체력 물약 사용 (50 회복)
        System.out.println("체력 물약을 사용합니다.");
        warrior.recoverHp(50);
        warrior.getCharacterInfo();
        System.out.println();

        // 4. 다시 몬스터에게 100의 피해를 입음
        System.out.println("강력한 공격을 받았습니다!");
        warrior.takeDamage(100);
        warrior.getCharacterInfo();
        System.out.println();

        // 5. 레벨 업!
        System.out.println("몬스터를 처치하여 레벨이 올랐습니다.");
        warrior.levelUp();
        warrior.getCharacterInfo();
    }
}
