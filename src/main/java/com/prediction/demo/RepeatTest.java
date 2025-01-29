package com.prediction.demo;

import com.prediction.demo.infrastructure.messaging.FinancialDataProducer;
import com.prediction.demo.integration.FinancialDataAcquirer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
@AllArgsConstructor
public class RepeatTest {
    private final FinancialDataProducer financialDataProducer;
    private final FinancialDataAcquirer financialDataAcquirer;

    public void doRepeatedly() {
        Runnable fetchData = () -> financialDataAcquirer.getDataFromApi().subscribe(financialDataProducer::sendMessage);
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        int delayInSeconds = 10;
        executorService.scheduleAtFixedRate(fetchData, 0, delayInSeconds, TimeUnit.SECONDS);
    }
}
