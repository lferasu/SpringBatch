package com.surafel.batch;

import com.surafel.batch.model.Student;
import com.surafel.batch.model.TransformedStudent;
import com.surafel.batch.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class Processor implements ItemProcessor<Student, TransformedStudent> {

   // private  static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Autowired
    private StudentRepository repo;

    @Override
    public TransformedStudent process(Student student) throws Exception {

        int age = student.getAge();

        LocalDate dob = LocalDate.of(LocalDate.now().minusYears(age).getYear(),01,01);
        return new TransformedStudent(student.getFirstName(),
                student.getLastName(),
                student.getGpa(),
                dob);
    }

}