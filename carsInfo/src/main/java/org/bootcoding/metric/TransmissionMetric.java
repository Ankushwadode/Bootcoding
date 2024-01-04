package org.bootcoding.metric;

import org.bootcoding.metric.collector.MetricCollector;
import org.bootcoding.model.Car;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransmissionMetric implements MetricCollector {

    @Override
    public void collect(List<Car> data) {
        Map<String ,List<Car>> collect = data.stream().collect(Collectors.groupingBy(Car::getTransmission));
        collect.forEach((transmission,carData)-> System.out.println(transmission+" : "+carData.size()));
    }
}
