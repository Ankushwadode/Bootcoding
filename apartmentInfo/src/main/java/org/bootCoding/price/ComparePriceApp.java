package org.bootCoding.price;

import org.bootCoding.entities.House;
import org.bootCoding.file.csv.CsvFileReader;
import org.bootCoding.filter.DataFilter;

import java.math.BigDecimal; //importing BigDecimal class
import java.util.List;

public class ComparePriceApp {
    public static void main(String[] args) {//finding the maximum value from 2 files

        //input
        CsvFileReader reader = new CsvFileReader("src/main/resources/input/housing_price_dataset.csv");

        //read
        List<House> houses = reader.read();

        //filter
        List bhk2 = DataFilter.filterList(houses,2);
        double House2bhk = MaxPrice.getMaxPrice(bhk2);

        List bhk3 = DataFilter.filterList(houses,3);
        double House3bhk = MaxPrice.getMaxPrice(bhk3);

        //output
        System.out.println("The price of 2-BHK:"+House2bhk+"\n"+"The Price of 3-BHK:"+ House3bhk);

        if (House2bhk>House3bhk){
            System.out.println("The price of 2BHK is greater then Price of 3BHK");
        }else {
            System.out.println("The price of 3BHK is greater then Price of 2BHK");
        }
    }



}
