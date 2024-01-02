package org.example;

import org.example.reader.file.listing.Carlist;
import org.example.writer.IFileWriter;
import org.example.writer.csv.CsvFilewriter;
import org.example.writer.json.JsonWriter;

public class Application {
    public static void main(String[] args) {
        Carlist carlist = new Carlist();
        carlist.listAllFiles("src/main/resources/input");
        CsvFilewriter csvFilewriter = new CsvFilewriter();
        csvFilewriter.write(carlist.getAllCars(),"src/main/resources/output/Allcars.csv");

        IFileWriter fwJson  = new JsonWriter();

        fwJson.write(carlist.getAllCars(),"src/main/resources/output/Allcars.json");

    }
}