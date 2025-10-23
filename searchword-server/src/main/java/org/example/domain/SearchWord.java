package org.example.domain;

import java.util.Objects;

public class SearchWord {
    private final String word;

    public SearchWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;

        SearchWord that = (SearchWord)o;
        return Objects.equals(word, that.word);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(word);
    }
}
