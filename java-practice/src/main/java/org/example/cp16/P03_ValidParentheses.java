package org.example.cp16;

import java.util.ArrayDeque;
import java.util.Deque;

import org.example.common.BaseClass;

public class P03_ValidParentheses extends BaseClass {
    @Override
    public void main() {
        P03_ValidParentheses solver = new P03_ValidParentheses();
        System.out.println("Case 1: (())() -> " + solver.solution("(())()")); // 예상 출력: true
        System.out.println("Case 2: )()( -> " + solver.solution(")()("));   // 예상 출력: false
        System.out.println("Case 3: (() -> " + solver.solution("(("));    // 예상 출력: false
    }

    boolean solution(String s) {
        // TODO: 이 곳에 코드를 구현하세요.
        Deque<Character> stack = new ArrayDeque<>();
        for (char parentheses : s.toCharArray()) {
            if (stack.isEmpty() || parentheses == '(') {
                stack.push(parentheses);
                continue;
            }

            stack.pop();
        }

        return stack.isEmpty(); // 올바른 괄호인지 여부를 반환해주세요.
    }
}
