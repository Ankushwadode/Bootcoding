package org.bootcoding.metrics.counter;

import org.bootcoding.metrics.MetricCollector;
import org.bootcoding.model.BankTransaction;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionByDateMetric implements MetricCollector {
    @Override
    public void collect(List<BankTransaction> transactions) {
        Map<Date,List<BankTransaction>> dateGroup = transactions.stream()
                .collect(Collectors.groupingBy(BankTransaction::getTransactionDate));

        //logic to find data in date range......
    }
}
