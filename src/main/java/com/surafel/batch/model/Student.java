package com.surafel.batch.model;

public class Student {

    private Integer id;

    private String firstName;
    private String lastName;
    private Double gpa;
    private Integer age;

    public Student() {
    }

    public Student(Integer id, String firstName, String lastName, Double gpa, Integer age) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.gpa = gpa;
        this.age = age;
    }

    public Student(String firstName, String lastName, Double gpa, Integer age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.gpa = gpa;
        this.age = age;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "firstName: " + firstName + ", lastName: " + lastName;
    }

}
