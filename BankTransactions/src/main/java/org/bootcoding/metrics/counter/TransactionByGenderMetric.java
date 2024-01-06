package org.bootcoding.metrics.counter;

import org.bootcoding.metrics.MetricCollector;
import org.bootcoding.model.BankTransaction;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionByGenderMetric implements MetricCollector {
    @Override
    public void collect(List<BankTransaction> transactions) {
        Map<Character,List<BankTransaction>> genderGroup = transactions.stream()
                .collect(Collectors.groupingBy(BankTransaction::getGender));

        System.out.println("....................................................");
        System.out.println("Transaction by Male: "+genderGroup.get('M').size());
        System.out.println("Transaction by Female: "+genderGroup.get('F').size());
    }
}
