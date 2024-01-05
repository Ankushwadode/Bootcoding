package org.bootcoding.reader;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.lang3.StringUtils;
import org.bootcoding.model.BankTransaction;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



public class TransactionFileReader {

    public List<BankTransaction> allBankTransactions = new ArrayList<>();

    public List<BankTransaction> getAllBankTransactions() {
        return allBankTransactions;
    }

    public void readAllFiles(String filePath){
        try{
            File file = new File(filePath);
            if (file.isDirectory()){
                File[] files =file.listFiles();
                for (File f : files){
                    if (f.isDirectory()) {
                        readAllFiles(f.getAbsolutePath());
                    }else {
                        allBankTransactions.addAll(processData(f));
                    }
                }
            }else {
                allBankTransactions.addAll(processData(file));
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    private List<BankTransaction> processData(File file){
        try{
            CSVReader reader = new CSVReader(new FileReader(file.getPath()));
            List<String[]> data = reader.readAll();
            return convert(data);
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
    }

    private List<BankTransaction> convert(List<String[]> data) {
        //return data.stream().map(row -> buildTransaction(row)).collect(Collectors.toList());

        //this line can be written as above line
        return data.stream().map(this::buildTransaction).collect(Collectors.toList());
    }

//    private void printArray(String[] data){
//        for(String d : data){
//            System.out.print(d + ",");
//        }
//        System.out.println();
//    }
    private BankTransaction buildTransaction(String[] row) {
//        printArray(row);
        return BankTransaction.builder()
                .transactionId(row[0])
                .customerId(row[1])
                .customerDob(row[2])
                .gender(StringUtils.isEmpty(row[3]) ? 'N' : row[3].charAt(0))
                .location(row[4])
                .accountBalance(StringUtils.isEmpty(row[5]) ? 0 : Double.valueOf(row[5]))
                .transactionDate(row[6])
                .transactionTime(StringUtils.isEmpty(row[7]) ? 0 : Long.valueOf(row[7]))
                .amountInr(StringUtils.isEmpty(row[8]) ? 0 : Double.valueOf(row[8]))
                .build();
    }

}
