package org.joedan.client;

import org.joedan.model.bean.reliefweb.JobData;

import java.util.HashSet;
import java.util.Set;

/**
 * TODO: Indexing in elastic search for persistence.
 */
public class JobsRepository {

    private static JobsRepository instance;

    public static JobsRepository getInstance() {
        if (instance == null) {
            synchronized (JobsRepository.class) {
                if (instance == null) {
                    instance = new JobsRepository();
                }
            }
        }

        return instance;
    }

    private final Set<JobData> jobs = new HashSet<>();

    public Set<JobData> getJobs() {
        return jobs;
    }


    public void addJobs(Set<JobData> data) {
        jobs.addAll(data);
    }
}
