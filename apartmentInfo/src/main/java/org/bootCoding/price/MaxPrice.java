package org.bootCoding.price;

import java.math.BigDecimal;
import java.util.List;

public class MaxPrice {
    //get max price
    static double getMaxPrice(List data){
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
}
