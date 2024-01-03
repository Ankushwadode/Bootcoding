package org.bootCoding;

import org.bootCoding.file.csv.CsvFileReader;
import org.bootCoding.entities.House;
import org.bootCoding.filter.DataFilter;
import org.bootCoding.pdf.PdfConvertors;
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

        PdfConvertors pdfConvertors = new PdfConvertors();

        //for loop needed
        for(int i=2;i<=5;i++){
            List<House> list = DataFilter.filterList(houses,i);
            Collections.sort(list);
            fwCsv.write(list,"src/main/resources/output/Csvdata/house"+i+"bhk.csv"); //create csv files
            fwJson.write(list,"src/main/resources/output/Jsondata/house"+i+"bhk.json"); //create json files
            pdfConvertors.write(list,"src/main/resources/output/PdfData/house"+i+".pdf"); //create pdf files
        }
    }
}