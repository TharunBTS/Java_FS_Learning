package com.test.WriteInTxt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import com.test.Collections.Transaction;
import com.test.annotation.FixedWidthFormatter;

public class WriteInTxt {

    // Method to write the transactions in a tabular format using streams
    public static <T> void writeToFile(List<T> transactions, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            // Write the header
            writer.write("HDR|"+fileName+"|");
            writer.newLine();
            writer.newLine();

           
            //writer.write(Transaction.header());
            writer.newLine();
            // Write the formatted transactions to the file
            for (T transaction : transactions) {
            	String formattedTransaction = FixedWidthFormatter.formatRecord(transaction);
                writer.write(formattedTransaction);
                writer.newLine();
            }

            System.out.println("Transactions have been written to the file: " + fileName);
        }
    }
}
