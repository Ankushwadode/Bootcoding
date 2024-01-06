package org.bootcoding.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class BankTransaction {
    private String transactionId;
    private String customerId;
    private Date customerDob;
    private char gender;
    private String location;
    private double accountBalance;
    private Date transactionDate;
    private long transactionTime;
    private double amountInr;

    @Override
    public String toString() {
        return
                transactionId +
                        "," + customerId +
                        "," + customerDob +
                        "," + gender +
                        "," + location +
                        "," + accountBalance +
                        "," + transactionDate +
                        "," + transactionTime +
                        "," + amountInr;
    }
}