package com.prediction.demo.input;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prediction.demo.infrastructure.messaging.KafkaProducer;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class InputDataSender {
    private final KafkaProducer kafkaProducer;
    private final InputDataPreparer inputDataPreparer;
    private final String csvPath;

    public void prepareAndSendInputData() {
        var inputData = inputDataPreparer.prepareData(csvPath);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        serializeAndSend(inputData, objectMapper);
    }

    private void serializeAndSend(List<FinancialData> input, ObjectMapper objectMapper) {
        try {
            String serializedMessage = objectMapper.writeValueAsString(input);
            kafkaProducer.sendMessage(serializedMessage);
            System.out.println("Message sent: " + serializedMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
