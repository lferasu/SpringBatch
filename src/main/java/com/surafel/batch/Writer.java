package com.surafel.batch;

import com.surafel.batch.model.TransformedStudent;
import com.surafel.batch.repository.StudentRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class Writer implements ItemWriter<TransformedStudent> {

    @Autowired
    private StudentRepository repo;

    @Override
    @Transactional
    public void write(List<? extends TransformedStudent> transformedStudents) throws Exception {
        repo.saveAll(transformedStudents);
    }

}