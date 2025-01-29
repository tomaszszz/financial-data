package com.prediction.demo;

import com.prediction.demo.infrastructure.messaging.KafkaProducer;
import com.prediction.demo.input.InputDataPreparer;
import com.prediction.demo.input.InputDataSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfiguration {
    @Value("${data.file.path}")
    private String csvPath;

    @Bean
    public InputDataSender inputDataSender(KafkaProducer kafkaProducer,
                                           InputDataPreparer inputDataPreparer) {
        return new InputDataSender(kafkaProducer, inputDataPreparer, csvPath);
    }
}
