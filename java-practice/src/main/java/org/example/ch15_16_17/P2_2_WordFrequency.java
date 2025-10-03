package org.example.ch15_16_17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

import org.example.common.BaseClass;

public class P2_2_WordFrequency extends BaseClass {
    @Override
    public void main() {
        String[] words = {
            "apple", "banana", "apple", "cherry", "banana",
            "apple", "date", "cherry", "banana", "apple"
        };

        // TODO 1: 단어별 빈도수를 Map<String, Long>으로 계산
        // Collectors.groupingBy()와 Collectors.counting() 사용
        Map<String, Long> wordFrequency = Arrays.stream(words)
            .collect(Collectors.groupingBy(
                word -> word,
                Collectors.counting()
            ));

        // TODO 2: 빈도수 기준 내림차순 정렬하여 출력
        // Map.Entry 정렬 활용
        System.out.println("=== 빈도수 기준 내림차순 정렬 ===");

        wordFrequency.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .forEach(word -> System.out.println(word.getKey() + " : " + word.getValue()));
        System.out.println();

        // TODO 3: 가장 많이 등장한 단어 상위 3개 출력
        // Stream.limit() 활용
        System.out.println("=== 가장 많이 등장한 단어 상위 3개 ===");

        wordFrequency.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(3)
            .forEach(word -> System.out.print(word + ", "));
        System.out.println();
    }
}
