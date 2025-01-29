package com.prediction.demo.input;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@Component
@AllArgsConstructor
public class InputDataPreparer {
    private static final String CSV_DELIMITER = ";";

    public List<InputData> prepareData(String csvPath) {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(csvPath))) {
            List<InputData> records = reader.lines()
                    .skip(1)
                    .map(line -> line.split(CSV_DELIMITER))
                    .map(line -> InputData.builder()
                            .timestamp(LocalDate.parse(line[0]))
                            .stockPrice(new BigDecimal(line[1]))
                            .build()
                    )
                    .toList();
            System.out.println( "Data read successfully. Records count: " + records.size() );
            return records;
        } catch (IOException e) {
            System.out.println("Error while parsing: " + e.getMessage());
        }
        return null;
    }
}
