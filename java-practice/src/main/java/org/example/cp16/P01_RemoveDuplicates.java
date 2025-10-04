package org.example.cp16;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.example.common.BaseClass;

public class P01_RemoveDuplicates extends BaseClass {
    @Override
    public void main() {
        P01_RemoveDuplicates solver = new P01_RemoveDuplicates();
        int[] arr = {1, 2, 5, 2, 4, 5, 1, 6};
        System.out.println("Original Array: " + Arrays.toString(arr));
        List<Integer> result = solver.solution(arr);
        System.out.println("Unique List: " + result); // 예상 출력: [1, 2, 4, 5, 6] (순서는 다를 수 있음)
    }

    public List<Integer> solution(int[] arr) {
        // TODO: 이 곳에 코드를 구현하세요.
        // 배열을 입력받아, 중복된 숫자를 모두 제거한 숫자 목록을 반환
        Set<Integer> set = Arrays.stream(arr)
            .boxed()
            .collect(Collectors.toSet());

        return set.stream().toList(); // 결과 리스트를 반환해주세요.
    }
}
