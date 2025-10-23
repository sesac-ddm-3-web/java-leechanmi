package org.example.config;

import org.example.repository.SearchWordRepository;
import org.example.repository.SearchWordRepositoryImpl;
import org.example.service.SearchWordService;

public class ApplicationContext {
    private final Datasource datasource;
    private final SearchWordRepository repository;
    private final SearchWordService service;

    public ApplicationContext() {
        this.datasource = new Datasource();
        this.repository = new SearchWordRepositoryImpl(datasource);
        this.service = new SearchWordService(repository);
    }
}
