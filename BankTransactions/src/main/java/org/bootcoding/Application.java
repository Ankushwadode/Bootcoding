package org.bootcoding;

import org.bootcoding.metrics.MetricCollector;
import org.bootcoding.metrics.counter.TramsactionByCityMetric;
import org.bootcoding.metrics.counter.TransactionByGenderMetric;
import org.bootcoding.model.BankTransaction;
import org.bootcoding.reader.TransactionFileReader;
import org.bootcoding.utils.FileSplitup;

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

        MetricCollector collector = new TramsactionByCityMetric();
        collector.collect(transactions);

    }
}