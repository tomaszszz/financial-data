package com.prediction.demo.input;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.prediction.demo.infrastructure.messaging.KafkaProducer;
import lombok.RequiredArgsConstructor;

import java.io.IOException;

@RequiredArgsConstructor
public class InputDataSender {
    private final KafkaProducer kafkaProducer;
    private final InputDataPreparer inputDataPreparer;
    private final String csvPath;

    public void prepareAndSendInputData() throws IOException {
        var inputData = inputDataPreparer.prepareData(csvPath);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        String serializedMessage = objectMapper.writeValueAsString(inputData);

        kafkaProducer.sendMessage(serializedMessage);
        System.out.println(serializedMessage);
    }
}
