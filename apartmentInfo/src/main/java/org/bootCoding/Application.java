package org.bootCoding;

import org.bootCoding.duplicate.DuplicateFinder;
import org.bootCoding.file.csv.CsvFileReader;
import org.bootCoding.entities.House;
import org.bootCoding.filter.DataFilter;
import org.bootCoding.metrics.BedroomMetric;
import org.bootCoding.metrics.BedroomNeighbourhoodMetric;
import org.bootCoding.metrics.NeighbourhoodMetric;
import org.bootCoding.metrics.collector.MetricCollector;
import org.bootCoding.pdf.PdfConvertors;
import org.bootCoding.price.MaxPrice;
import org.bootCoding.writer.IFileWriter;
import org.bootCoding.writer.csv.CsvFileWriter;
import org.bootCoding.writer.json.JsonWriter;

import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) throws Exception {

        System.out.println("starting......");

        //path can be taken from the user
        MaxPrice.execute("src/main/resources/input/housing_price_dataset.csv");

        System.out.println("......................................................");

        //helps to find the duplicate data in file
        DuplicateFinder duplicateFinder = new DuplicateFinder();
        duplicateFinder.findDuplicates("src/main/resources/input/housing_price_dataset.csv");

        //read the given file
        CsvFileReader csvFileReader = new CsvFileReader("D:\\workspace\\BootCoding\\apartmentInfo\\src\\main\\" +
        "resources\\input\\housing_price_dataset.csv");

        //reader object
        List<House> houses = csvFileReader.read();

        //csv writer object
        IFileWriter fwCsv = new CsvFileWriter();

        //json writer object
        IFileWriter fwJson = new JsonWriter();

        //pdf convertors object
        PdfConvertors pdfConvertors = new PdfConvertors();

        //for-loop to generate specific no of files
        for(int i=2;i<=5;i++){
            List<House> list = DataFilter.filterList(houses,i);
            Collections.sort(list);
            fwCsv.write(list,"src/main/resources/output/Csvdata/house"+i+"bhk.csv"); //create csv files
            fwJson.write(list,"src/main/resources/output/Jsondata/house"+i+"bhk.json"); //create json files
            pdfConvertors.write(list,"src/main/resources/output/PdfData/house"+i+".pdf"); //create pdf files
        }

        System.out.println("......................................................");

        //metric of bedroom
        System.out.println("Metric according to bedroom: ");
        MetricCollector metricCollectorBedroom = new BedroomMetric();
        metricCollectorBedroom.collect(houses);

        System.out.println("......................................................");

        //metric of neighbourhood
        System.out.println("Metric according to neighbourhood: ");
        MetricCollector metricCollectorNeighbourhood = new NeighbourhoodMetric();
        metricCollectorNeighbourhood.collect(houses);

        System.out.println("......................................................");

        //metric of bedroom and neighbourhood combine
        System.out.println("Metric according to neighbourhood and bedroom: ");
        MetricCollector metricCollectorCombine = new BedroomNeighbourhoodMetric();
        metricCollectorCombine.collect(houses);
    }
}