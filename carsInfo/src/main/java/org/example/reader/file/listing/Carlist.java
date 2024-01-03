package org.example.reader.file.listing;

import org.example.model.Car;
import org.example.pdf.PdfConvertor;
import org.example.reader.file.csv.CsvFileReader;

import java.io.File;
import java.util.*;

public class Carlist {
    public List<Car> allCars = new ArrayList<>();

    public List<Car> getAllCars() {
        return allCars;
    }

    public void listAllFiles(String  path){
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

    private void processData(File file){
        System.out.println("Files: "+ file.getName());
        String filePath = file.getPath();
        System.out.println(filePath);

        CsvFileReader csvFileReader = new CsvFileReader(filePath);
        List data = csvFileReader.read();
        Collections.sort(data);

        allCars.addAll(data);
    }

}
