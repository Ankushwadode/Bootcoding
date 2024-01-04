package org.bootCoding.metrics.counter;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NeighbouthoodCount {
    private long total;
    private long rural;
    private long urban;
    private long suburb;
}
