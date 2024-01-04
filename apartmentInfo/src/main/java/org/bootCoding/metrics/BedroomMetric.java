package org.bootCoding.metrics;

import org.bootCoding.entities.House;
import org.bootCoding.metrics.collector.MetricCollector;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BedroomMetric implements MetricCollector {
    @Override
    public void collect(List<House> data) {
        Map<Integer,List<House>> collect = data.stream().collect(Collectors.groupingBy(House::getBedrooms));
        collect.forEach((bedroom,value)-> System.out.println(bedroom+" BHK:"+value.size()));
    }
}
