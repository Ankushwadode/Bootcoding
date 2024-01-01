package org.bootCoding.file.csv;

import org.bootCoding.entities.House;
import org.bootCoding.file.FIleReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

    public class CsvFileReader implements FIleReader {

    String path;

    public CsvFileReader(String inputPath){
        this.path = inputPath;
    }

    private static House buildhouse(String line){
        String[] content = line.split(",");
        return House.builder()
                .squareFeet(Integer.parseInt(content[0]))
                .bedrooms(Integer.parseInt(content[1]))
                .bathrooms(Integer.parseInt(content[2]))
                .neighbourhood(content[3])
                .year(Integer.parseInt(content[4]))
                .price(Double.parseDouble(content[5]))
                .build();
    }

    @Override
    public List<House> read() {
        File file = new File(path);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line= reader.readLine();
            List<House> houses = new ArrayList<>();
            while ((line=reader.readLine()) != null){
                House house = buildhouse(line);
                houses.add(house);
            }
            return houses;
        } catch (Exception e) {
            throw  new RuntimeException();
        }
    }
}
