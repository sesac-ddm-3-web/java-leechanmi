package org.example.config;

import org.example.job.JobRunner;
import org.example.repository.SearchWordRepository;
import org.example.repository.SearchWordRepositoryImpl;
import org.example.service.SearchWordService;

public class ApplicationContext {
    private final Datasource datasource;
    private final SearchWordRepository repository;
    private final SearchWordService service;
    private final JobRunner jobRunner;

    public ApplicationContext() {
        this.datasource = new Datasource();
        this.repository = new SearchWordRepositoryImpl(datasource);
        this.service = new SearchWordService(repository);
        this.jobRunner = new JobRunner(datasource);
    }

    public SearchWordService getService() {
        return service;
    }

    public JobRunner getJobRunner() {
        return jobRunner;
    }
}
