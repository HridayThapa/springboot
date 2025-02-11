package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumberController {
	
	private static final String template = "My favorite number is, %s!";
	private final AtomicLong counter = new AtomicLong();

    @GetMapping("/numbers")
    public synchronized Numbers numbers(@RequestParam( value= "name", defaultValue = "7") String name) {
    	return new Numbers(counter.incrementAndGet(), String.format(template, name));
   
    }
}
