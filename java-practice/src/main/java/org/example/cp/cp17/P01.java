package org.example.cp.cp17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.example.common.BaseClass;

// 리스트에서 짝수만 필터링하기
public class P01 extends BaseClass {
    @Override
    public void main() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = new ArrayList<>();

        // for (Integer number : numbers) {
        //     if (number % 2 == 0) {
        //         evenNumbers.add(number);
        //     }
        // }

        evenNumbers = numbers.stream()
            .filter(n -> n % 2 == 0)
            .toList();

        System.out.println(evenNumbers); // [2, 4, 6, 8, 10]
    }
}
