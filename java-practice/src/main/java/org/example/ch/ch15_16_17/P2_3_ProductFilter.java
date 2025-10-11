package org.example.ch.ch15_16_17;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.example.common.BaseClass;

class Product {
    private String name;
    private int price;
    private String category;

    public Product(String name, int price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return name + " - " + price + "원 (" + category + ")";
    }
}

public class P2_3_ProductFilter extends BaseClass {
    @Override
    public void main() {
        List<Product> products = Arrays.asList(
            new Product("노트북", 1200000, "전자기기"),
            new Product("마우스", 35000, "전자기기"),
            new Product("키보드", 89000, "전자기기"),
            new Product("의자", 150000, "가구"),
            new Product("책상", 300000, "가구"),
            new Product("모니터", 250000, "전자기기")
        );

        // TODO 1: "전자기기" 카테고리 상품만 필터링하여 출력
        System.out.println("=== 전자기기 카테고리 상품 ===");
        products.stream()
            .filter(p -> "전자기기".equals(p.getCategory()))
            .forEach(System.out::println);

        // TODO 2: 가격이 100000원 이상인 상품들의 총 가격 계산
        // Stream.reduce() 또는 mapToInt().sum() 활용
        int total = products.stream()
            .map(Product::getPrice)
            .filter(price -> price >= 100000)
            .reduce(0, Integer::sum);

        System.out.println("=== 가격이 100000원 이상인 상품들의 총 가격 계산 ===");
        System.out.println(total);

        // TODO 3: 가장 비싼 상품 찾기 (Optional 반환)
        // 있으면 상품명과 가격 출력, 없으면 "상품 없음" 출력
        System.out.println("=== 가장 비싼 상품 찾기 ===");
        products.stream()
            .mapToInt(Product::getPrice)
            .max()
            .ifPresentOrElse(
                System.out::println,
                () -> System.out.println("상품 없음")
            );

        // TODO 4: 카테고리별로 상품 그룹핑
        // Map<String, List<Product>> 형태로 출력
        System.out.println("=== 카테고리별로 상품 그룹핑 ===");
        Map<String, List<Product>> groupByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));
        System.out.println(groupByCategory);
    }
}
