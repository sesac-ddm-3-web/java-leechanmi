package org.example.ch15_16_17;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.example.common.BaseClass;

class Book {
    private String title;
    private String author;
    private int publishYear;
    private int pages;

    public Book(String title, String author, int publishYear, int pages) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.pages = pages;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPublishYear() { return publishYear; }
    public int getPages() { return pages; }

    @Override
    public String toString() {
        return title + " - " + author + " (" + publishYear + "년, " + pages + "p)";
    }
}

public class P2_4_BookManager extends BaseClass {
    @Override
    public void main() {
        List<Book> books = Arrays.asList(
            new Book("자바의 정석", "남궁성", 2016, 1152),
            new Book("이펙티브 자바", "조슈아 블로크", 2018, 416),
            new Book("클린 코드", "로버트 마틴", 2013, 584),
            new Book("리팩토링", "마틴 파울러", 2020, 752),
            new Book("객체지향의 사실과 오해", "조영호", 2015, 264),
            new Book("스프링 부트 실전 활용", "김영한", 2021, 890)
        );

        // TODO 1: 2018년 이후 출판된 책 필터링하여 출력
        System.out.println("=== 2018 이후 출판 ===");
        books.stream()
            .filter(b -> b.getPublishYear() >= 2018)
            .sorted(Comparator.comparing(Book::getPublishYear))
            .forEach(System.out::println);

        // TODO 2: 페이지 수가 가장 많은 책 찾기 (Optional 처리)
        System.out.println("=== 페이지 수가 가장 많은 책 찾기 ===");
        books.stream()
            .max(Comparator.comparingInt(Book::getPages))
            .ifPresent(System.out::println);

        // TODO 3: 저자별로 책 그룹핑
        // Map<String, List<Book>> 형태로 출력
        Map<String, List<Book>> mapByAuthor = books.stream()
            .collect(Collectors.groupingBy(Book::getAuthor));

        System.out.println("=== 저자별로 책 그룹핑 ===");
        System.out.println(mapByAuthor);

        // TODO 4: Predicate를 사용하여 조건 필터링
        // 500페이지 이상이면서 2015년 이후 출판된 책
        // Predicate<Book> 두 개를 and()로 결합
        System.out.println("=== 500페이지 이상이면서 2015년 이후 출판 ===");
        books.stream()
            .filter(b -> (b.getPages() >= 500) && (b.getPublishYear() >= 2015))
            .forEach(System.out::println);


        // TODO 5: 제목에 "자바" 또는 "Java" 포함된 책 찾기
        // anyMatch() 사용하여 boolean 반환
        boolean hasJavaBook = books.stream()
            .anyMatch(b -> b.getTitle().contains("자바") || b.getTitle().contains("Java"));

        System.out.println("=== 제목에 \"자바\" 또는 \"Java\" 포함된 책 찾기 ===");
        System.out.println("결과: " + hasJavaBook);
    }
}
