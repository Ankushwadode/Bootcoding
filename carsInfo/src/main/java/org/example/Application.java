package org.example;

import org.example.pdf.PdfConvertor;
import org.example.reader.file.listing.Carlist;
import org.example.writer.IFileWriter;
import org.example.writer.csv.CsvFilewriter;
import org.example.writer.json.JsonWriter;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {

        System.out.println("Starting.....");

        Carlist carlist = new Carlist();
        carlist.listAllFiles("src/main/resources/input");

        CsvFilewriter csvFilewriter = new CsvFilewriter();
        csvFilewriter.write(carlist.getAllCars(),"src/main/resources/output/Allcars.csv");

        IFileWriter fwJson  = new JsonWriter();
        fwJson.write(carlist.getAllCars(),"src/main/resources/output/Allcars.json");

        PdfConvertor pdfConvertor = new PdfConvertor();
        pdfConvertor.write(carlist.getAllCars(),"src/main/resources/output/AllCarsList.pdf");
    }
}
