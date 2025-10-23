package org.example.repository;

import org.example.domain.RankHistory;
import org.example.domain.SearchWord;

public interface SearchWordRepository {

    void upsert(SearchWord searchWord);

    RankHistory getCurrentRankHistory();
}
