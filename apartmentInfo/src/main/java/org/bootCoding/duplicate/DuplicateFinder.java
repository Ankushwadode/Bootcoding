package org.bootCoding.duplicate;

import org.bootCoding.entities.House;
import org.bootCoding.file.csv.CsvFileReader;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class DuplicateFinder {

    public void findDuplicates(String inputPath){
        List<House> allHouses = new ArrayList<>();

        CsvFileReader reader = new CsvFileReader(inputPath);

        List data = reader.read();
        System.out.println("size of list: "+data.size());

        HashSet<House> houseHashSet = new HashSet<>(data);
        System.out.println("size of set: "+houseHashSet.size());

        HashMap<House,Integer> countMap = new HashMap<>();

        for (Object house:data){
            countMap.put((House) house,countMap.getOrDefault(house,0)+1);
        }

        System.out.println("Duplicate Count: ");
        for(House key:countMap.keySet()){
            int count =  countMap.get(key);
            if (count>1) System.out.println(key+" : "+count);
        }
    }
}
