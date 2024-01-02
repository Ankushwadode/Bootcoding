package org.example;

import org.example.reader.file.csv.CsvFileReader;
import org.example.writer.csv.CsvFilewriter;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Main().listAllFiles("D:\\workspace\\BootCoding\\carsInfo\\src\\main\\resources\\input");
    }

    private void processData(File file){
        System.out.println("Files: "+ file.getName());
        String filePath = file.getPath();
        System.out.println(filePath);
        CsvFileReader csvFileReader = new CsvFileReader(filePath);
        List data = csvFileReader.read();
        Collections.sort(data);
        CsvFilewriter csvFilewriter = new CsvFilewriter();
        csvFilewriter.write(data,"src/main/resources/output/allCars.csv");
    }

    private void listAllFiles(String  path){
        try{
            File file = new File(path);
            if(file.isDirectory()){
                File[] files = file.listFiles();
                for(File f:files){
                    if (f.isDirectory()){
                        System.out.println("Directory: "+f.getName());
                        listAllFiles(f.getAbsolutePath());
                    }else {
                        processData(f);
                    }
                }
            }else {
                processData(file);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}