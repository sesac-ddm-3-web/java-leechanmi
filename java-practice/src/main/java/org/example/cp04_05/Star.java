package org.example.cp04_05;

import org.example.common.BaseClass;

public class Star extends BaseClass {
    @Override
    public void main() {
        System.out.print("최대 길이: ");
        int level = in.nextInt();
        StringBuilder result = new StringBuilder();

        // 직각 삼각형
        for (int i = 1; i <= level; i++) {
            result.append("*".repeat(i)).append("\n");
        }
        result.append("\n");

        // 역직각 삼각형
        for (int i = level; i >= 1; i--) {
            result.append("*".repeat(i)).append("\n");
        }
        result.append("\n");

        // 정삼각형 (피라미드)
        int maxLength = 1 + 2 * (level - 1);
        for (int i = 1; i <= level; i++) {
            String star = "*".repeat(1 + 2 * (i - 1));
            String blank = " ".repeat((maxLength - star.length()) / 2);

            result.append(blank).append(star).append(blank).append("\n");
        }
        result.append("\n");

        // 역정삼각형 (역피라미드)
        for (int i = level; i >= 1; i--) {
            String star = "*".repeat(1 + 2 * (i - 1));
            String blank = " ".repeat((maxLength - star.length()) / 2);

            result.append(blank).append(star).append(blank).append("\n");
        }
        result.append("\n");

        // 다이아몬드
        for (int i = 1; i < level; i++) {
            String star = "*".repeat(1 + 2 * (i - 1));
            String blank = " ".repeat((maxLength - star.length()) / 2);

            result.append(blank).append(star).append(blank).append("\n");
        }
        for (int i = level; i >= 1; i--) {
            String star = "*".repeat(1 + 2 * (i - 1));
            String blank = " ".repeat((maxLength - star.length()) / 2);

            result.append(blank).append(star).append(blank).append("\n");
        }
        result.append("\n");

        System.out.println(result);
    }
}
