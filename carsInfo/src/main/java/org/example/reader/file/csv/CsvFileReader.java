package org.example.reader.file.csv;

import org.example.model.Car;
import org.example.reader.file.FileReader;
import org.example.utils.NumberUtility;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader implements FileReader {

    String path;

public CsvFileReader(String inputPath){this.path=inputPath;}


private static Car ListCars(String line){
    String[] carInfo = line.split(",");
    return Car.builder()
            .model(carInfo[0])
            .year(Integer.parseInt(carInfo[1]))
            .price(NumberUtility.sanitize(carInfo[2]))
            .transmission(carInfo[3])
            .mileage(Integer.parseInt(carInfo[4]))
            .fuelType(carInfo[5])
            .tax(Integer.parseInt(carInfo[6]))
            .mpg(NumberUtility.sanitize(carInfo[7]))
            .engineSize(NumberUtility.sanitize(carInfo[8]))
            .build();
}

    @Override
    public List read() {
        File file = new File(path);

        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(file));
            String line= reader.readLine();
            List<Car> houses = new ArrayList<>();
            while ((line=reader.readLine()) != null){
                if (!line.contains(",,,,,,,")){
                    Car car = ListCars(line);
                    houses.add(car);
                }
            }
            return houses;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
