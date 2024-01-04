package org.bootCoding.metrics.counter;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class BedroomCounter {
    private Map<Integer, NeighbouthoodCount> bedroomCount;
}
