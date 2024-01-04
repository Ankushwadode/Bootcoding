package org.bootcoding.duplicate;

import org.bootcoding.model.Car;
import org.bootcoding.reader.file.csv.CsvFileReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DuplicateFinder {

    public void findDuplicates(List dataList){

        System.out.println("size of list: "+dataList.size());

        HashSet<Car> houseHashSet = new HashSet<>(dataList);
        System.out.println("size of set: "+houseHashSet.size());

        HashMap<Car,Integer> countMap = new HashMap<>();

        for (Object car:dataList){
            countMap.put((Car) car,countMap.getOrDefault(car,0)+1);
        }

        System.out.println("Duplicate Count: ");
        for(Car key:countMap.keySet()){
            int count =  countMap.get(key);
            if (count>1) System.out.println("Data: "+key+" :  "+"Duplicate count: "+count);
        }
    }


}
