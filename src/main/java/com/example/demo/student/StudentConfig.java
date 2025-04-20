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
    /**
     * A function to pre-populate the database with some data
     * It is annotated with @Bean: to indicate that it is a bean
     * @Bean is used to indicate that a method produces a bean to be managed by the Spring container
     * It is annotated with @Configuration: to indicate that it is a configuration class
     * @Configuration is used to indicate that a class declares one or more @Bean methods
     */

    /**
     * what is a config file
     * A config file is a file that contains configuration settings for a program or system
     * and what are configuration settings in laymans language
     * Configuration settings are the settings that control how a program or system behaves
     */

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
