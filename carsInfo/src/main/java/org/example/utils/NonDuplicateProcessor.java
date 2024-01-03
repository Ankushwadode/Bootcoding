package org.example.utils;

import java.util.HashMap;
import java.util.HashSet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NonDuplicateProcessor {

    public static void main(String[] args) {
        String inputCsvFile = "src/main/resources/housing_price_dataset.csv";
        String outputCsvFile = "src/main/resources/output/Non-Duplicate.csv";

        processCSV(inputCsvFile, outputCsvFile);
    }

    public static void processCSV(String inputFilePath, String outputFilePath) {
        HashSet<String> uniqueDataSet = new HashSet<>();
        HashMap<String, Integer> duplicateCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            // Read header if present
            String header = reader.readLine();

            // Process each line in the CSV file
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                String dataValue = values[0].trim(); // Assuming the data is in the first column

                // Check if the value is already in the set
                if (uniqueDataSet.contains(dataValue)) {
                    // Increment the duplicate count
                    duplicateCountMap.put(dataValue, duplicateCountMap.getOrDefault(dataValue, 0) + 1);
                } else {
                    // Add the value to the set if it's not already present
                    uniqueDataSet.add(dataValue);
                }
            }

            // Write unique data and duplicate count to output CSV file
            try (FileWriter writer = new FileWriter(outputFilePath)) {
                writer.write("unique_data,duplicate_count\n"); // Header

                for (String uniqueValue : uniqueDataSet) {
                    int duplicateCount = duplicateCountMap.getOrDefault(uniqueValue, 0);
                    writer.write(uniqueValue + "," + duplicateCount + "\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
