package com.prediction.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinancialDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialDataApplication.class, args)
				.getBean(RepeatTest.class)
				.doRepeatedly();
	}

}
