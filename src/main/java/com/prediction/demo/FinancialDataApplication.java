package com.prediction.demo;

import com.prediction.demo.input.InputDataSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class FinancialDataApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(FinancialDataApplication.class, args)
					.getBean(InputDataSender.class)
					.prepareAndSendInputData();
		} catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
