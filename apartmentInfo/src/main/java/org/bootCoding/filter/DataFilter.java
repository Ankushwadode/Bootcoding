package org.bootCoding.filter;

import org.bootCoding.entities.House;

import java.util.List;
import java.util.stream.Collectors;

public class DataFilter {
    public static List<House> filterList(List<House> list, int count){
        return list.stream().filter(house -> house.getBedrooms() == count).collect(Collectors.toList());
    }
}
