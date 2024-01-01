package org.bootCoding.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class House implements Comparable{
    
     int squareFeet;
     int bedrooms;
     int bathrooms;
     String neighbourhood;
     int year;
     double price;

     @Override
     public String toString() {
          return  squareFeet +
                  "," + bedrooms +
                  "," + bathrooms +
                  "," + neighbourhood +
                  "," + year +
                  "," + price;
     }

     @Override
     public int compareTo(Object o) {
          House house = (House) o;
          return this.neighbourhood.compareTo(house.neighbourhood);
     }
}
