package org.example.cp.cp17;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.example.common.BaseClass;

// 상품 리스트를 카테고리별로 그룹핑하기
class Product {
    private String name;
    private String category;

    public Product(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class P05 extends BaseClass {
    @Override
    public void main() {
        List<Product> products = Arrays.asList(
            new Product("모니터", "전자제품"),
            new Product("키보드", "전자제품"),
            new Product("사과", "식품"),
            new Product("바나나", "식품"),
            new Product("책", "도서")
        );

        Map<String, List<Product>> productsByCategory = new HashMap<>();

        // for (Product p : products) {
        //     if (!productsByCategory.containsKey(p.getCategory())) {
        //         productsByCategory.put(p.getCategory(), new ArrayList<>());
        //     }
        //     productsByCategory.get(p.getCategory()).add(p);
        // }

        productsByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println(productsByCategory);
        // {도서=[책], 전자제품=[모니터, 키보드], 식품=[사과, 바나나]}
    }
}
