package org.bootcoding.metric.collector;

import org.bootcoding.model.Car;

import java.util.List;

public interface MetricCollector {
    void collect(List<Car> data);
}
