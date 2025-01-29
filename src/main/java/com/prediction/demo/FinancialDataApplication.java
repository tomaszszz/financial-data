package com.prediction.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.prediction.demo.input.InputDataSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinancialDataApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(FinancialDataApplication.class, args)
					.getBean(InputDataSender.class)
					.prepareAndSendInputData();
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

}
