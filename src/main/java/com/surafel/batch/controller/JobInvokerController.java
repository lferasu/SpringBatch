package com.surafel.batch.controller;

import com.surafel.batch.model.TransformedStudent;
import com.surafel.batch.repository.StudentRepository;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class JobInvokerController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    StudentRepository repo;

    @Autowired
    @Qualifier("studentjob")
    Job studentTransformJob;

    @GetMapping("/run-batch-job")
    public List<TransformedStudent> handle() throws Exception {

        JobParameters jobParameters = new JobParametersBuilder()
                .addString("source", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
        jobLauncher.run(studentTransformJob, jobParameters);

        return repo.findAll();
    }
}