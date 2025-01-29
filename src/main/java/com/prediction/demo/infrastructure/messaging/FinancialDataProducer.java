package com.prediction.demo.infrastructure.messaging;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FinancialDataProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        try {
            kafkaTemplate.send("prediction-topic", message);
            System.out.println("Message sent: " + message);
        } catch(Exception e) {
            System.out.println("Error sending message: " + e.getMessage());
        }
    }
}