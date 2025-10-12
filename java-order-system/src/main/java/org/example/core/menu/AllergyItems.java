package org.example.core.menu;

import java.util.TreeSet;
import java.util.stream.Collectors;

import lombok.Getter;

public class AllergyItems {
    private TreeSet<AllergyItem> items;

    @Override
    public String toString() {
        return items.stream()
            .map(AllergyItem::getKr)
            .collect(Collectors.joining(", "));
    }

    @Getter
    enum AllergyItem {
        WHEAT("밀"),
        MILK("우유"),
        EGG("계란"),
        PEANUT("땅콩"),
        SHRIMP("새우"),
        SHELLFISH("조개류");
        ;
        private String kr;

        AllergyItem(String kr) {
            this.kr = kr;
        }
    }
}
