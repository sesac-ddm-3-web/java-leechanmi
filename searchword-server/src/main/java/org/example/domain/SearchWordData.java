package org.example.domain;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class SearchWordData implements Comparable<SearchWordData> {
    private AtomicInteger count;
    private AtomicInteger reducedCount;
    private LocalDateTime searchedAt;

    public AtomicInteger getCount() {
        return count;
    }

    public LocalDateTime getSearchedAt(){
        return searchedAt;
    }

    public SearchWordData(AtomicInteger count, AtomicInteger reducedCount){
        this.count = count;
        this.reducedCount = reducedCount;
        this.searchedAt = LocalDateTime.now();
    }

    public void addCount() {
        this.count.incrementAndGet();
    }

    @Override
    public int compareTo(SearchWordData another) {
        if (this.getCount().get() == another.getCount().get()) {
            if (this.searchedAt.isAfter(another.searchedAt)) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return this.getCount().get() - another.getCount().get();
        }
    }
}