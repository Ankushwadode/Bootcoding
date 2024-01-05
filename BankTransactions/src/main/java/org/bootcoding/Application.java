package org.bootcoding;

import org.bootcoding.utils.FileSplitup;

public class Application {
    public static void main(String[] args) {
        System.out.println("Starting......");

        FileSplitup fileSplitup = new FileSplitup();
        fileSplitup.splitFile("src/main/resources/Input/bank_transactions.csv",50000,
                "src/main/resources/Output");
    }
}