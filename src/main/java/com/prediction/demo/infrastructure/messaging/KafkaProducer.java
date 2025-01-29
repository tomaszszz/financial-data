package com.prediction.demo.infrastructure.messaging;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {
    @Value("${kafka.topic.name}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        try {
            kafkaTemplate.send(topicName, message);
            System.out.println("Message sent: " + message);
        } catch(Exception e) {
            System.out.println("Error sending message: " + e.getMessage());
        }
    }
}