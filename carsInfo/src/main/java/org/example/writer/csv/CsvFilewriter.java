package org.example.writer.csv;

import org.example.writer.IFileWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvFilewriter implements IFileWriter {
    @Override
    public void write(List data, String outputPath) {
       try{
           File file = new File(outputPath);
           FileWriter fileWriter = new FileWriter(file);
           fileWriter.write("model,year,price,transmission,mileage,fuelType,tax,mpg,engineSize");
           fileWriter.write("\n");
           data.forEach(d->{
               try{
                   fileWriter.write(d.toString());
                   fileWriter.write("\n");
               } catch (Exception e) {
                   throw new RuntimeException(e);
               }
           });
           fileWriter.close();
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }
}
