package org.bootcoding;

import org.bootcoding.duplicate.DuplicateFinder;
import org.bootcoding.metric.TransmissionMetric;
import org.bootcoding.metric.FuelMetric;
import org.bootcoding.metric.collector.MetricCollector;
import org.bootcoding.model.Car;
import org.bootcoding.pdf.PdfConvertor;
import org.bootcoding.reader.file.csv.CsvFileReader;
import org.bootcoding.reader.file.listing.Carlist;
import org.bootcoding.writer.IFileWriter;
import org.bootcoding.writer.csv.CsvFilewriter;
import org.bootcoding.writer.json.JsonWriter;

import java.util.List;

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
        System.out.println("Duplicate data: ");
        DuplicateFinder duplicateFinder = new DuplicateFinder();
        duplicateFinder.findDuplicates(carlist.getAllCars());

        System.out.println("..............................................................................");

        //reading the file
        CsvFileReader csvFileReader = new CsvFileReader("src/main/resources/output/Allcars.csv");
        List<Car> carsList = csvFileReader.read();

        //metric of car by transmission
        System.out.println("Metric of car by transmission");
        MetricCollector transmissionMetric = new TransmissionMetric();
        transmissionMetric.collect(carsList);

        System.out.println("..............................................................................");

        //metric of car by fuel type
        System.out.println("Metric of car by fuel type");
        MetricCollector fuelTypeMetric = new FuelMetric();
        fuelTypeMetric.collect(carsList);
    }
}
