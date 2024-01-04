package org.bootCoding.metrics.result;

import lombok.Builder;
import lombok.Data;
import org.bootCoding.metrics.counter.BedroomCounter;

import java.util.List;

@Data
@Builder
public class MetricResult {
    private List<BedroomCounter> bedroomCounter;
}
