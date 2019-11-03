package com.surafel.batch.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class TransformedStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private Double gpa;
    private LocalDate birthDate;

    public TransformedStudent() {
    }

    public TransformedStudent(String firstName, String lastName, Double gpa, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;
        this.birthDate = birthDate;
    }

    //    public TransformedStudent(Integer id, String lastName, String firstName, Double gpa, LocalDate birthDate) {
//        this.id = id;
//        this.lastName = lastName;
//        this.firstName = firstName;
//        this.gpa = gpa;
//        this.birthDate = birthDate;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "firstName: " + firstName + ", lastName: " + lastName;
    }
}
