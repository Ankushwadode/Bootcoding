package org.bootcoding;

import org.bootcoding.metrics.MetricCollector;
import org.bootcoding.metrics.counter.TramsactionByCityMetric;
import org.bootcoding.metrics.counter.TransactionByGenderMetric;
import org.bootcoding.model.BankTransaction;
import org.bootcoding.metrics.range.TransactionByDateMetric;
import org.bootcoding.reader.TransactionFileReader;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("Starting......");

//        FileSplitup fileSplitup = new FileSplitup();
//        fileSplitup.splitFile("src/main/resources/Input/bank_transactions.csv",50000,
//         "src/main/resources/Output");

        TransactionFileReader transactionFileReader = new TransactionFileReader();
        transactionFileReader.readAllFiles("src/main/resources/Output/");

        List<BankTransaction> transactions = transactionFileReader.getAllBankTransactions();

        MetricCollector metricCollector = new TransactionByGenderMetric();
        metricCollector.collect(transactions);

        MetricCollector collectorCity = new TramsactionByCityMetric();
        collectorCity.collect(transactions);

        TransactionByDateMetric transactionByDateMetric = new TransactionByDateMetric();
        transactionByDateMetric.collect(transactions,60,70);
        transactionByDateMetric.collect(transactions,70,80);
        transactionByDateMetric.collect(transactions,80,90);
    }
}