package org.bootCoding.metrics;

import org.bootCoding.entities.House;
import org.bootCoding.metrics.collector.MetricCollector;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NeighbourhoodMetric implements MetricCollector {
    @Override
    public void collect(List<House> data) {
        Map<String,List<House>> collect = data.stream().collect(Collectors.groupingBy(House::getNeighbourhood));
        collect.forEach((neighbourhood,values)-> System.out.println(neighbourhood+":"+values.size()));
    }
}
