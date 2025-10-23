package org.example.domain;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class SearchWordData implements Comparable {
    private AtomicInteger count;
    private AtomicInteger reducedCount;
    private LocalDateTime searchedAt;

    public void addCount() {
        this.count.incrementAndGet();
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
