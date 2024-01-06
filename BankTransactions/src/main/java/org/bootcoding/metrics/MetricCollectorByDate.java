package org.bootcoding.metrics;

import org.bootcoding.model.BankTransaction;

import java.util.List;

public interface MetricCollectorByDate {
    public void collect(List<BankTransaction> transactions, int startYear, int endYear);

}
