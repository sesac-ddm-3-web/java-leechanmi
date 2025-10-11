package org.example.cp.cp17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.example.common.BaseClass;

// 문자열 리스트를 각 문자열의 길이 리스트로 변환하기
public class P02 extends BaseClass {
    @Override
    public void main() {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        List<Integer> wordLengths = new ArrayList<>();

        // for (String word : words) {
        //     wordLengths.add(word.length());
        // }

        wordLengths = words.stream()
            .mapToInt(String::length)
            .boxed()
            .toList();

        System.out.println(wordLengths); // [5, 6, 6, 4]
    }
}
