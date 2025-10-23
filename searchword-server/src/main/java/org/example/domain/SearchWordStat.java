package org.example.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class SearchWordStat {
    private final ConcurrentHashMap<SearchWord, SearchWordData> searchwordStorage;
    private final List<RankHistory> rankHistory;

    public SearchWordStat() {
        this.searchwordStorage = new ConcurrentHashMap<>();
        this.rankHistory = new ArrayList<>();
    }

    // upsert 로직


    // 마지막 rank history 가져오는 로직
}
