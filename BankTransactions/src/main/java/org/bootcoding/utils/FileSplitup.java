package org.bootcoding.utils;

import com.google.common.collect.Lists;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.time.Instant;
import java.util.List;

public class FileSplitup {
    public void splitFile(String inputPath, int splitCount, String outputPath){
        try{
            CSVReader csvReader = new CSVReader(new FileReader(inputPath));
            List<String[]> data = csvReader.readAll();

            List<List<String[]>> partitionData = Lists.partition(data,splitCount);

            for (List<String[]> subList : partitionData){
                CSVWriter writer = new CSVWriter(new FileWriter(outputPath+"/"+"BankTransaction_"
                        +(Instant.now().getNano())+".csv"));

                writer.writeAll(subList);
            }

        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
