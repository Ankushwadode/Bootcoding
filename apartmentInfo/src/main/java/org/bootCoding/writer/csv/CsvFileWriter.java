package org.bootCoding.writer.csv;

import org.bootCoding.writer.IFileWriter;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class CsvFileWriter implements IFileWriter {
    @Override
    public void write(List data, String outputPath) {
        try{
            File file = new File(outputPath);
            FileWriter fw = new FileWriter(file);
            fw.write("SquareFeet,Bedrooms,Bathrooms,Neighborhood,YearBuilt,Price");
            fw.write("\n");
            data.forEach(n ->{
                try {
                    fw.write(n.toString());
                    fw.write("\n");
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
