package org.example.service;

import org.example.domain.RankHistory;
import org.example.domain.SearchWord;
import org.example.domain.SearchWordStat;
import org.example.repository.SearchWordRepository;

public class SearchWordService {

    private final SearchWordRepository repository;

    public SearchWordService(SearchWordRepository repository) {
        this.repository = repository;
    }

    // 컨트롤러랑 이어지는 로직
    // 요청에 응답하는 데이터 만들기
    // 비즈니스 로직 수행
    public String getPopulars() {
        RankHistory lastHistory = repository.getCurrentRankHistory();
    }

    // 검색어 저장하기
    public void upsertSearchWord(String searchword) {
        SearchWord word = new SearchWord(searchword);
        repository.upsert(word);
    }
}
