package org.bootCoding.metrics.collector;

import org.bootCoding.entities.House;

import java.util.HashMap;
import java.util.List;

public interface MetricCollector {
    void collect(List<House> data);
}
