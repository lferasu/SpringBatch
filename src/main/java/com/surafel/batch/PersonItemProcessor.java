//package com.surafel.batch;
//
//import com.surafel.batch.model.Person;
//import org.slf4j.LoggerFactory;
//import org.slf4j.Logger;
//import org.springframework.batch.item.ItemProcessor;
//
//
//
//public class PersonItemProcessor implements ItemProcessor<Person, Person> {
//
//    private  static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);
//    @Override
//    public Person process(Person person) throws Exception {
//      final String firstName = person.getFirstName().toUpperCase();
//      final String lastName = person.getLastName().toUpperCase();
//      final Person transformedPerson = new Person(firstName,lastName);
//      log.info("Converting (" + person + ") into ("+transformedPerson + ")");
//      return transformedPerson;
//    }
//}
