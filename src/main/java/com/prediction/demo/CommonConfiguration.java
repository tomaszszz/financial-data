package com.prediction.demo;

import com.prediction.demo.infrastructure.messaging.KafkaProducer;
import com.prediction.demo.input.InputDataPreparer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

public class CommonConfiguration {
    @Bean
    public KafkaProducer financialDataProducer(KafkaTemplate<String, String> kafkaTemplate) {
        return new KafkaProducer(kafkaTemplate); }

    @Bean
    public InputDataPreparer prepareInputData() {
        return new InputDataPreparer();
    }
}
