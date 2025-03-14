package com.example.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @KafkaListener(topics = "test-topic", groupId = "group_id")
    public void consumeMessage(String message) {
        System.out.println("Received message: " + message);
    }
}
