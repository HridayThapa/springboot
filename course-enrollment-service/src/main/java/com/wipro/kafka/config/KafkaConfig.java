package com.wipro.kafka.config;

import com.wipro.kafka.event.EnrollmentEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    private static final String TOPIC_NAME = "enrollment-events";

    // Create Kafka Topic
    @Bean
    public NewTopic createTopic() {
        return TopicBuilder.name(TOPIC_NAME).partitions(3).replicas(1).build();
    }

    // Kafka Producer Configuration
    @Bean
    public ProducerFactory<String, EnrollmentEvent> producerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, org.springframework.kafka.support.serializer.JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, EnrollmentEvent> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    // Kafka Consumer Configuration
    @KafkaListener(topics = TOPIC_NAME, groupId = "enrollment-group")
    public void listenEnrollmentEvents(EnrollmentEvent event) {
        System.out.println("Received Enrollment Event: " + event);
    }
}
