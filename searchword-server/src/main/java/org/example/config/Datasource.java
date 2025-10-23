package org.example.config;

import org.example.domain.SearchWordStat;

public class Datasource {
    private final SearchWordStat searchWordStat;

    public Datasource() {
        this.searchWordStat = new SearchWordStat();
    }

    public SearchWordStat getSearchWordStat() {
        return searchWordStat;
    }
}
