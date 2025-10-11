package org.example.cp.cp17;

import java.util.Arrays;
import java.util.List;

import org.example.common.BaseClass;

public class P04 extends BaseClass {
    @Override
    public void main() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = 0;

        // for (int number : numbers) {
        //     sum += number;
        // }

        sum = numbers.stream()
            .mapToInt(Integer::intValue)
            .sum();

        System.out.println("합계: " + sum); // 합계: 15
    }
}
