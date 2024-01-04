package org.bootcoding.metric;

import org.bootcoding.metric.collector.MetricCollector;
import org.bootcoding.model.Car;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FuelMetric implements MetricCollector {
    @Override
    public void collect(List<Car> data) {
        Map<String ,List<Car>> collect = data.stream().collect(Collectors.groupingBy(Car::getFuelType));
        collect.forEach((fuelType,carData)-> System.out.println(fuelType+" : "+carData.size()));
    }
}
