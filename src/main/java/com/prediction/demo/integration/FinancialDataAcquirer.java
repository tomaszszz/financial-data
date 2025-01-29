package com.prediction.demo.integration;


import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Deprecated
@Service
public class FinancialDataAcquirer {
    private static final String API_KEY = "cucurf9r01qri16ors1gcucurf9r01qri16ors20";

    private final WebClient webClient = WebClient.create();

    public Mono<String> getDataFromApi() {
        String apiUrl = "https://finnhub.io/api/v1/quote?symbol=AAPL&token=" + API_KEY;
        return webClient.get()
                .uri(apiUrl)
                .retrieve()
                .bodyToMono(String.class);
    }
}
