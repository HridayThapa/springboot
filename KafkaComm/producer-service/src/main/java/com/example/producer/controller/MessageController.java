package com.example.producer.controller;

import com.example.producer.service.MessageProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/producer")
public class MessageController {

    private final MessageProducer messageProducer;

    public MessageController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String topic, @RequestParam String message) {
        messageProducer.sendMessage(topic, message);
        return "Message sent successfully!";
    }
}
