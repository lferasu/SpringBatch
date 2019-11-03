//package com.surafel.batch;
//
//import com.surafel.batch.model.Student;
////import jdk.internal.loader.Resource;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.core.io.Resource;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Reader extends FlatFileItemReader<Student> {
//    public Reader(Resource resource) {
//        super();
//        setResource(resource);
//        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
//        lineTokenizer.setNames(new String[] { "firstName", "lastName", "gpa", "age" });
//        lineTokenizer.setDelimiter(",");
//        lineTokenizer.setStrict(false);
//
//        BeanWrapperFieldSetMapper<Student> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
//        fieldSetMapper.setTargetType(Student.class);
//
//        DefaultLineMapper<Student> defaultLineMapper = new DefaultLineMapper<>();
//        defaultLineMapper.setLineTokenizer(lineTokenizer);
//        defaultLineMapper.setFieldSetMapper(fieldSetMapper);
//        setLineMapper(defaultLineMapper);
//    }
//}
