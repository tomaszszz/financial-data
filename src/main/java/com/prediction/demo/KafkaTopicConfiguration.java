package com.prediction.demo;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfiguration {
    @Bean
    public NewTopic predictionTopic() {
        return new NewTopic("prediction-topic", 1, (short) 1);
    }
}
