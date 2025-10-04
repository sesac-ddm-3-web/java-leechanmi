package org.example.cp16;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.example.common.BaseClass;

public class P02_MarathonRunner extends BaseClass {

    @Override
    public void main() {
        P02_MarathonRunner solver = new P02_MarathonRunner();
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        String result = solver.solution(participant, completion);
        System.out.println("Did not finish: " + result); // 예상 출력: "mislav"
    }

    public String solution(String[] participant, String[] completion) {
        // TODO: 이 곳에 코드를 구현하세요.
        Map<String, Long> participantMap = Arrays.stream(participant)
            .collect(Collectors.groupingBy(
                s -> s,
                Collectors.counting()
            ));

        for (String name : completion) {
            participantMap.compute(name, (k, v) -> v - 1);
        }

        // 완주하지 못한 선수의 이름을 반환해주세요.
        return participantMap.entrySet().stream()
            .filter(p -> p.getValue() > 0)
            .map(Map.Entry::getKey)
            .findAny()
            .orElse("");
    }
}
