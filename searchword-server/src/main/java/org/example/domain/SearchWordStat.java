package org.example.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SearchWordStat {
    private final ConcurrentHashMap<SearchWord, SearchWordData> storage;
    private final List<RankHistory> rankHistory;

    public SearchWordStat() {
        this.storage = new ConcurrentHashMap<>();
        this.rankHistory = new ArrayList<>();
    }

    // upsert 로직
    public void upsert(SearchWord searchWord) {
        storage.merge(
            searchWord,
            new SearchWordData(new AtomicInteger(1), new AtomicInteger(1)),
            (oldV, newV) -> { oldV.addCount(); return oldV; }
        );
    }

    // 마지막 rank history 가져오는 로직
    public RankHistory getCurrentRankHistory() {
        return rankHistory.getLast();
    }

    // 히스토리 추가
    public void addHistory(RankHistory history) {
        rankHistory.add(history);
    }

    public ConcurrentHashMap<SearchWord, SearchWordData> getStorage() {
        return storage;
    }
}
