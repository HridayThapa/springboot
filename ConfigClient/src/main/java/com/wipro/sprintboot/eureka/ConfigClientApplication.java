package com.wipro.sprintboot.eureka;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication	
@RestController
@RequestMapping("/config")
public class ConfigClientApplication {

    @Value("${myapp.message: Default message if not found}")
    private String message;

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @GetMapping("/message")
    public String getMessage() {
        return message;
    }
}