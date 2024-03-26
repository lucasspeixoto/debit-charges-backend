package com.lspeixotodev.debitcharges.utils;

import java.util.Arrays;
import java.util.List;

public class CSVProcessor implements Runnable {

    private final List<String[]> batch;

    public CSVProcessor(List<String[]> batch) {
        this.batch = batch;
    }

    @Override
    public void run() {

        int sum = 0;
        for (String[] record : batch) {
            // Process each record
            //Arrays.stream(record).map(item -> System.out.printf("Item: " + item + "\n"));
            System.out.printf("Record: " + Arrays.toString(record) + "\n");
            sum += 1;
        }

        System.out.printf("Total Debits: " + sum + "\n");
    }
}
