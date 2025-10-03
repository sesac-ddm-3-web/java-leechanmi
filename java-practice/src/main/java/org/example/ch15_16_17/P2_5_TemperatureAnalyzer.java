package org.example.ch15_16_17;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.example.common.BaseClass;

class TemperatureData {
    private String city;
    private int[] temperatures; // 7일간의 온도

    public TemperatureData(String city, int[] temperatures) {
        this.city = city;
        this.temperatures = temperatures;
    }

    public String getCity() { return city; }
    public int[] getTemperatures() { return temperatures; }

    @Override
    public String toString() {
        return city + ": " + Arrays.toString(temperatures);
    }
}

public class P2_5_TemperatureAnalyzer extends BaseClass {
    @Override
    public void main() {
        List<TemperatureData> data = Arrays.asList(
            new TemperatureData("서울", new int[]{-2, 0, 3, 5, 7, 4, 1}),
            new TemperatureData("부산", new int[]{5, 7, 8, 10, 12, 11, 9}),
            new TemperatureData("대구", new int[]{1, 3, 5, 7, 9, 6, 4}),
            new TemperatureData("인천", new int[]{-1, 1, 4, 6, 8, 5, 2})
        );

        // TODO 1: 각 도시의 평균 온도 계산
        // Map<String, Double> 형태로 출력
        // Arrays.stream() 활용
        Map<String, Double> averageTemperature = data.stream()
            .collect(Collectors.groupingBy(
                TemperatureData::getCity,
                Collectors.averagingDouble(
                    d -> Arrays.stream(d.getTemperatures())
                        .average()
                        .orElse(0.0)
                )
            ));

        System.out.println("=== 각 도시의 평균 온도 계산 ===");
        System.out.println(averageTemperature);

        // TODO 2: 전체 도시 중 최고 온도 찾기
        // flatMapToInt() 사용
        int max = data.stream()
            .flatMapToInt(d -> Arrays.stream(d.getTemperatures()))
            .max()
            .orElse(0);
        System.out.println("=== 전체 도시 중 최고 온도 찾기 ===");
        System.out.println("최고 온도: " + max);

        // TODO 3: 특정 도시("서울")의 온도 범위(최대-최소) 계산
        // Optional로 도시를 찾고, IntSummaryStatistics 활용
        Optional<TemperatureData> seoulOpt = data.stream()
            .filter(d -> d.getCity().equals("서울"))
            .findFirst();

        seoulOpt.ifPresent(
            seoul -> {
                IntSummaryStatistics stats = Arrays.stream(seoul.getTemperatures())
                    .summaryStatistics();

                int range = stats.getMax() - stats.getMin();
                System.out.println("=== 특정 도시(\"서울\")의 온도 범위(최대-최소) 계산 ===");
                System.out.println("온도 범위: " + range);
            }
        );

        // TODO 4: 영하(0도 미만) 온도가 있는 도시 찾기
        // filter + anyMatch 활용
        System.out.println("=== 영하(0도 미만) 온도가 있는 도시 찾기 ===");
        data.stream()
            .filter(d -> Arrays.stream(
                d.getTemperatures())
                .anyMatch(t -> t < 0))
            .forEach(System.out::println);

        // TODO 5: 모든 날의 평균 온도가 5도 이상인 도시만 필터링
        System.out.println("=== 모든 날의 평균 온도가 5도 이상인 도시만 필터링 ===");
        data.stream()
            .filter(
                d -> Arrays.stream(d.getTemperatures())
                    .average()
                    .orElse(0) > 5
            ).forEach(System.out::println);
    }
}
