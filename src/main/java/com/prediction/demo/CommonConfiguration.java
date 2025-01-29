package com.prediction.demo;

import com.prediction.demo.infrastructure.messaging.FinancialDataProducer;
import com.prediction.demo.integration.FinancialDataAcquirer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

public class CommonConfiguration {
    @Bean
    public FinancialDataProducer financialDataProducer(KafkaTemplate<String, String> kafkaTemplate) {
        return new FinancialDataProducer(kafkaTemplate); }

    @Bean
    public RepeatTest repeatTest(FinancialDataProducer financialDataProducer, FinancialDataAcquirer financialDataAcquirer) {
        return new RepeatTest(financialDataProducer, financialDataAcquirer);
    }
}
