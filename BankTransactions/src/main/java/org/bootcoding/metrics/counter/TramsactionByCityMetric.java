package org.bootcoding.metrics.counter;

import org.bootcoding.metrics.MetricCollector;
import org.bootcoding.model.BankTransaction;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TramsactionByCityMetric implements MetricCollector {
    @Override
    public void collect(List<BankTransaction> transactions) {

        Map<String,List<BankTransaction>> transCity = transactions.stream()
                .collect(Collectors.groupingBy(BankTransaction::getLocation));

        System.out.println("....................................................");
        System.out.println("Transaction by MUMBAI: "+transCity.get("MUMBAI").size());
        System.out.println("Transaction by NAVI MUMBAI: "+transCity.get("NAVI MUMBAI").size());
        System.out.println("Transaction by AHMEDABAD: "+transCity.get("AHMEDABAD").size());
        System.out.println("Transaction by PUNE: "+transCity.get("PUNE").size());
        System.out.println("Transaction by THANE: "+transCity.get("THANE").size());
        System.out.println("Transaction by SECUNDERABAD: "+transCity.get("SECUNDERABAD").size());
        System.out.println("Transaction by LUCKNOW: "+transCity.get("LUCKNOW").size());
        System.out.println("Transaction by GURGAON: "+transCity.get("GURGAON").size());
        System.out.println("Transaction by DELHI: "+transCity.get("DELHI").size());
        System.out.println("Transaction by CHENNAI: "+transCity.get("CHENNAI").size());
        System.out.println("Transaction by HYDERABAD: "+transCity.get("HYDERABAD").size());
        System.out.println("Transaction by GHAZIABAD: "+transCity.get("GHAZIABAD").size());
        System.out.println("Transaction by JAIPUR: "+transCity.get("JAIPUR").size());
        System.out.println("Transaction by NOIDA: "+transCity.get("NOIDA").size());
        System.out.println("Transaction by AGRA: "+transCity.get("AGRA").size());
        System.out.println("Transaction by BANGALORE: "+transCity.get("BANGALORE").size());
        System.out.println("Transaction by NASHIK: "+transCity.get("NASHIK").size());
        System.out.println("Transaction by INDORE: "+transCity.get("INDORE").size());

        //below code print every single city from csv file
//        Map<String, Map<Character,Long>> groupCity = transactions.stream()
//                .collect(Collectors.groupingBy(BankTransaction::getLocation,
//                Collectors.groupingBy(BankTransaction::getGender,Collectors.counting())));
//
//        groupCity.forEach((location,gender) ->{
//            System.out.println("Locations "+ location);
//            gender.forEach((genders,count)->{
//                System.out.println("Gender "+genders+ "Counts "+count);
//            });
//        });
    }
}
