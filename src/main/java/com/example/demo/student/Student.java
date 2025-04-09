package com.example.demo.student;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

/**
    * A class to represent a student
 */
@Entity//javax persistence
public class Student {

    /**
     * Param Id: to indicate that this is the primary key
     * @GeneratedValue: to indicate that the value will be generated automatically
     * @SequenceGenerator: to indicate that the value will be generated using a sequence
     */
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;

    public Student() {
    }

    //constructor to create a new student
    public Student(Long id,
            String name,
            String email,
            LocalDate dob) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.dob = dob;
    }
  //constructor to create a new student
    public Student(String name,
                   String email,
                   LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
