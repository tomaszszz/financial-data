package com.prediction.demo.input;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class FinancialData {
    @JsonProperty("timestamp")
    private LocalDate timestamp;

    @JsonProperty("stock_price")
    private BigDecimal stockPrice;
}
