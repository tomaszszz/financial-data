package com.prediction.demo.input;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prediction.demo.infrastructure.messaging.KafkaProducer;
import lombok.AllArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InputDataSender {
    public static final String CSV_PATH = "src/main/resources/financial_data.csv";

    private final KafkaProducer kafkaProducer;
    private final InputDataPreparer inputDataPreparer;


    public void prepareAndSendInputData() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        var inputData = inputDataPreparer.prepareData(CSV_PATH);
        String serializedMessage = objectMapper.writeValueAsString(inputData);

        kafkaProducer.sendMessage(serializedMessage);
        System.out.println(serializedMessage);
    }
}
