package org.bootCoding.price;

import org.bootCoding.entities.House;
import org.bootCoding.file.csv.CsvFileReader;
import org.bootCoding.filter.DataFilter;

import java.math.BigDecimal;
import java.util.List;

public class MaxPrice {

    //get max price
    public static double getMaxPrice(List data){

        BigDecimal maxPrice = new BigDecimal(0);
        for (Object house:data) {
            String[] datas = house.toString().split(",");
//            System.out.println(data[5]);
            BigDecimal currentPrice = new BigDecimal(datas[5]);
            if (currentPrice.compareTo(maxPrice)>0)
                maxPrice = currentPrice;
        }
//        System.out.println(maxPrice);
        return maxPrice.doubleValue();
    }

    public static void execute(String inputPath){
        //input
        CsvFileReader reader = new CsvFileReader(inputPath);

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
