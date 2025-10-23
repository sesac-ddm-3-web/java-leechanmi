package org.example.repository;

import org.example.config.Datasource;
import org.example.domain.RankHistory;
import org.example.domain.SearchWord;
import org.example.domain.SearchWordStat;

public class SearchWordRepositoryImpl implements SearchWordRepository {

    private final Datasource datasource;

    public SearchWordRepositoryImpl(Datasource datasource) {
        this.datasource = datasource;
    }

    @Override
    public void upsert(SearchWord searchWord) {
        SearchWordStat searchWordStat = datasource.getSearchWordStat();
        searchWordStat.upsert(searchWord);
    }

    @Override
    public RankHistory getCurrentRankHistory() {
        SearchWordStat searchWordStat = datasource.getSearchWordStat();
        return searchWordStat.getCurrentRankHistory();
    }
}