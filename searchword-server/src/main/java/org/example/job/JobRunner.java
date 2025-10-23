package org.example.job;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.example.config.Datasource;
import org.example.domain.RankHistory;
import org.example.domain.SearchWord;
import org.example.domain.SearchWordData;
import org.example.domain.SearchWordStat;

public class JobRunner implements Runnable {

    private final int LIMIT = 10;
    private final Datasource datasource;

    public JobRunner(Datasource datasource) {
        this.datasource = datasource;
    }

    @Override
    public void run() {
        while (true) {
            try {
                doJob();
                Thread.sleep(60_000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void doJob() throws IOException {
        SearchWordStat searchWordStat = datasource.getSearchWordStat();
        ConcurrentHashMap<SearchWord, SearchWordData> storage = searchWordStat.getStorage();

        Map<SearchWord, SearchWordData> snapshot = storage.entrySet()
            .stream()
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        SearchWord[] searchWords = snapshot.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .map(Map.Entry::getKey)
            .limit(LIMIT)
            .toArray(SearchWord[]::new);

        RankHistory newPopulars = new RankHistory(searchWords);
        searchWordStat.addHistory(newPopulars);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH시 mm분 ss초");
        String now = LocalDateTime.now().format(formatter);

        String content = IntStream.range(0, searchWords.length)
            .mapToObj(i -> (i + 1) + ". " + searchWords[i].getWord())
            .collect(Collectors.joining("\n"));

        String output = String.format("[인기 검색어 순위] %s%n%s%n%n", now, content);

        var writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(output);
        writer.flush();
    }
}
