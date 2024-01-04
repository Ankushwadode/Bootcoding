package org.bootcoding.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car implements Comparable{
    private String model;
    private int year;
    private double price;
    private String transmission;
    private int mileage;
    private String fuelType;
    private int tax;
    private double mpg;
    private double engineSize;

    @Override
    public String toString() {
        return
                 model +
                "," + year +
                "," + price +
                "," + transmission +
                "," + mileage +
                "," + fuelType +
                "," + tax +
                "," + mpg +
                "," + engineSize ;
    }

    @Override
    public int compareTo(Object o) {
        Car car =(Car) o; //type casting
        return this.model.compareTo(car.model);
    }
}
