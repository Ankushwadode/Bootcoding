package org.bootcoding;

import org.bootcoding.duplicate.DuplicateFinder;
import org.bootcoding.pdf.PdfConvertor;
import org.bootcoding.reader.file.listing.Carlist;
import org.bootcoding.writer.IFileWriter;
import org.bootcoding.writer.csv.CsvFilewriter;
import org.bootcoding.writer.json.JsonWriter;

public class Application {
    public static void main(String[] args) {

        System.out.println("Starting.....");

        //read folder for files
        Carlist carlist = new Carlist();
        carlist.listAllFiles("src/main/resources/input");

//        //csv writer object
        CsvFilewriter csvFilewriter = new CsvFilewriter();
        csvFilewriter.write(carlist.getAllCars(),"src/main/resources/output/Allcars.csv");

//        //json writer object
        IFileWriter fwJson  = new JsonWriter();
        fwJson.write(carlist.getAllCars(),"src/main/resources/output/Allcars.json");

//        //convert to pdf file
        PdfConvertor pdfConvertor = new PdfConvertor();
        pdfConvertor.write(carlist.getAllCars(),"src/main/resources/output/AllCarsList.pdf");

        //findes the duplicate in a given file
        DuplicateFinder duplicateFinder = new DuplicateFinder();
        duplicateFinder.findDuplicates(carlist.getAllCars());
    }
}
