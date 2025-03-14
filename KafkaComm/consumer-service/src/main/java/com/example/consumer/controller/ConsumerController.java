package com.example.consumer.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/consumer")
public class ConsumerController {

    private String latestMessage = "No messages received yet";

    @KafkaListener(topics = "test-topic", groupId = "group_id")
    public void consumeMessage(String message) {
        System.out.println("Received message: " + message);
        latestMessage = message;
    }

    @GetMapping("/latest-message")
    public Map<String, String> getLatestMessage() {
        Map<String, String> response = new HashMap<>();
        response.put("message", latestMessage);
        return response;
    }
}
