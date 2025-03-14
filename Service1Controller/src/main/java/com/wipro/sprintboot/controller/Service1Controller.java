package com.wipro.sprintboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service1")
public class Service1Controller {

    @GetMapping("/message")
    public String getMessage() {
        return "Hello from Service 1 on port 9091!";
    }
}
