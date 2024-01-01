package org.bootCoding;

import org.bootCoding.file.csv.CsvFileReader;
import org.bootCoding.entities.House;
import org.bootCoding.filter.DataFilter;
import org.bootCoding.writer.IFileWriter;
import org.bootCoding.writer.csv.CsvFileWriter;
import org.bootCoding.writer.json.JsonWriter;

import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) throws Exception {

        System.out.println("starting......");

        CsvFileReader csvFileReader = new CsvFileReader("D:\\workspace\\BootCoding\\apartmentInfo\\src\\main\\" +
                "resources\\input\\housing_price_dataset.csv");
        List<House> houses = csvFileReader.read();

        IFileWriter fwCsv = new CsvFileWriter();

        IFileWriter fwJson = new JsonWriter();

        //for loop needed

        List<House> house2bhk = DataFilter.filterList(houses,2);
        List<House> house3bhk = DataFilter.filterList(houses,3);
        List<House> house4bhk = DataFilter.filterList(houses,4);
        List<House> house5bhk = DataFilter.filterList(houses,5);

        //sorting acc. to neighbourhood
        Collections.sort(house2bhk);
        Collections.sort(house3bhk);
        Collections.sort(house4bhk);
        Collections.sort(house5bhk);

        fwCsv.write(house2bhk,"src/main/resources/output/Csvdata/house2bhk.csv");
        fwCsv.write(house3bhk,"src/main/resources/output/Csvdata/house3bhk.csv");
        fwCsv.write(house4bhk,"src/main/resources/output/Csvdata/house4bhk.csv");
        fwCsv.write(house5bhk,"src/main/resources/output/Csvdata/house5bhk.csv");

        fwJson.write(house2bhk,"src/main/resources/output/Jsondata/house2bhk.json");
        fwJson.write(house3bhk,"src/main/resources/output/Jsondata/house3bhk.json");
        fwJson.write(house4bhk,"src/main/resources/output/Jsondata/house4bhk.json");
        fwJson.write(house5bhk,"src/main/resources/output/Jsondata/house5bhk.json");

    }
}