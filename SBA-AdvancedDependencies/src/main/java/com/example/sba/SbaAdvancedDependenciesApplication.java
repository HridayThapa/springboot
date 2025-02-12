package com.example.sba;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.NoSuchElementException;

@SpringBootApplication
public class SbaAdvancedDependenciesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SbaAdvancedDependenciesApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(PersonRepository repository) {
        return args -> {
            Person person = new Person();
            person.setName("Alex");

            repository.save(person);
            Person saved = repository.findById(person.getId()).orElseThrow(NoSuchElementException::new);
            
           
            System.out.println("Saved Person: ID=" + saved.getId() + ", Name=" + saved.getName());
        };
    }
}