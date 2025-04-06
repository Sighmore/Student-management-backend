package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.DECEMBER;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args ->{
            Student mariam = new Student(
                    "Mariam",
                    "marriam@gmail.com",
                    LocalDate.of(2000,DECEMBER,5)
            ) ;
            Student james = new Student(
                    "James",
                    "James@gmail.com",
                    LocalDate.of(1995,DECEMBER,5)
            ) ;
            Student Simon = new Student(
                    "simon",
                    "simonkuriah7@gmail.com",
                    LocalDate.of(2009,DECEMBER,5)

            ) ;

            repository.saveAll(
                    List.of(mariam,james,Simon)
            );

        };
    }

}
