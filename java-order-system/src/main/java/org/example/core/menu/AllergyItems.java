package org.example.core.menu;

import java.util.Arrays;
import java.util.TreeSet;
import java.util.stream.Collectors;

import lombok.Getter;

public class AllergyItems {
    private TreeSet<AllergyItem> items;

    public AllergyItems() {
        this.items = new TreeSet<>();
    }

    public static AllergyItems of(AllergyItem... items) {
        AllergyItems allergyItems = new AllergyItems();
        allergyItems.items.addAll(Arrays.asList(items));
        return allergyItems;
    }

    @Override
    public String toString() {
        return items.stream()
            .map(AllergyItem::getDisplayName)
            .collect(Collectors.joining(", "));
    }

    @Getter
    public enum AllergyItem {
        WHEAT("밀"),
        MILK("우유"),
        EGG("계란"),
        PEANUT("땅콩"),
        SHRIMP("새우"),
        SHELLFISH("조개류");
        ;
        private String displayName;

        AllergyItem(String displayName) {
            this.displayName = displayName;
        }
    }
}
