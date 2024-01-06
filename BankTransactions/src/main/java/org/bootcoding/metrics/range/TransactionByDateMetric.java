package org.bootcoding.metrics.range;

import org.bootcoding.metrics.MetricCollectorByDate;
import org.bootcoding.model.BankTransaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionByDateMetric implements MetricCollectorByDate {
    @Override
    public void collect(List<BankTransaction> transactions, int startYear, int endYear) {
        List<BankTransaction> transactionList = new ArrayList<>();
        for (BankTransaction transaction : transactions) {
            if (isWithRange(transaction.getCustomerDob(), startYear, endYear)) {
                transactionList.add(transaction);
            }
        }
        System.out.println("....................................................");
        System.out.println("Year between 1960 to 1970 transaction count is: "+ transactionList.size());
    }
    private boolean isWithRange(Date date , int startYear, int endYear)
    {
//        System.out.println(date.getYear());
        if( date.getYear()>= startYear && date.getYear()<=endYear)
        {
            return true;
        }
        return false;
    }
}
