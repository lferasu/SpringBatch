package com.surafel.batch;

import com.surafel.batch.model.Student;
import com.surafel.batch.model.TransformedStudent;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

@Component
@Configuration
@EnableBatchProcessing
public class StudentBatchJob extends JobExecutionListenerSupport {
    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    StepBuilderFactory stepBuilderFactory;


//    @Autowired
//    private ResourceLoader resourceLoader;



   //private final Resource resource = resourceLoader.getResource("students.csv");

//
//    @Value("students.csv")
//    Resource resource;

    @Autowired
    Processor processor;

    @Autowired
    Writer writer;

//    @Autowired
//    Reader reader;


    @Bean
    public FlatFileItemReader<Student> reader() {
        return new FlatFileItemReaderBuilder<Student>()
                .name("personItemReader")
                .resource(new ClassPathResource("students.csv"))
                .linesToSkip(1)
                .delimited()
                .names(new String[]{"firstName", "lastName", "gpa", "age"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Student>() {{
                    setTargetType(Student.class);
                }})
                .build();
    }

    @Bean(name = "studentjob")
    public Job studentTransformJob() {

        Step step = stepBuilderFactory.get("step-1")
                .<Student, TransformedStudent> chunk(100)
                .reader(reader())
                .processor(processor)
                .writer(writer)
                .build();

        Job job = jobBuilderFactory.get("student-job")
                .incrementer(new RunIdIncrementer())
                .listener(this)
                .start(step)
                .build();

        return job;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            System.out.println("BATCH JOB COMPLETED SUCCESSFULLY");
        }
    }
}
