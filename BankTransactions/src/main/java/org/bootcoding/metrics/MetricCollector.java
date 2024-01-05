package org.bootcoding.metrics;

import org.bootcoding.model.BankTransaction;

import java.util.List;

public interface MetricCollector {
    public void collect(List<BankTransaction> transactions);
}
