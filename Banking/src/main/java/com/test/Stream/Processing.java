package com.test.Stream;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.test.Collections.Customer;
import com.test.Collections.Transaction;
import com.test.MongoToPojo.MongoRecordMapper;
import com.test.WriteInTxt.WriteInTxt;

public class Processing {
	

	private final MongoRecordMapper r;
    private final List<Customer> customers;
    private final List<Transaction> transactions;

    public Processing(MongoRecordMapper r) {
        this.r = r;

        Map<String, List<?>> data = r.loadAllCollections();
        this.customers = (List<Customer>) data.get("Customer");
        this.transactions = (List<Transaction>) data.get("Transaction");
    }
	
	
    
    
	public static <T> void writeObjectsByDate(List<T> objects, String directoryPath) {

        // Group transactions by date
        Map<Object, List<T>> groupByDate = objects.stream()
                .collect(Collectors.groupingBy(tx -> ((Transaction) tx).timestamp(), TreeMap::new, Collectors.toList()));

        // For each grouped date, create a filename and write the transactions
        groupByDate.forEach((date, transactions) -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String fileName = ((LocalDateTime) date).format(formatter);
            try {
                // Write the transactions to the file with the generated filename
                WriteInTxt.writeToFile(transactions, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    } 
    
    // This method writes customer transactions grouped by date
    public void writeCustomerTransactions(int customerId, String directoryPath) {

        // Fetch all customers and transactions from the database
        

        // Find the customer by ID
        Customer customer = customers.stream().filter(c -> c.customerId() == customerId).findFirst().orElse(null);

        if (customer == null) {
            System.out.println("Customer not found: " + customerId);
            return;
        }

        // Filter transactions for the given customer (both as Payer and Payee)
        List<Transaction> customerTransactions = transactions.stream()
                .filter(tx -> tx.Payer() == customer.customerId() || tx.Payee() == customer.customerId())
                .collect(Collectors.toList());

        if (customerTransactions.isEmpty()) {
            System.out.println("No transactions found for customer: " + customerId);
            return;
        }

        // Group transactions by date (only LocalDate)
        Map<LocalDate, List<Transaction>> groupedTransactions = customerTransactions.stream()
                .collect(Collectors.groupingBy(tx -> tx.timestamp().toLocalDate(), TreeMap::new, Collectors.toList()));

        // For each grouped date, create a filename and write the transactions
        groupedTransactions.forEach((date, txs) -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String fileName = customerId+"_"+customer.customerName()+"_"+date.format(formatter);  // Use the LocalDate here
            try {
                // Write the transactions to the file with the generated filename
                WriteInTxt.writeToFile(txs, fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    
    public static void groupTransactionsByCustomerId(List<Transaction> transactions,List<Customer> customer) {
        Map<Integer,List<Transaction>> groupByCustomer =  transactions.stream()
                .flatMap(tx -> Stream.of(tx.Payer(), tx.Payee()))  // Create a stream of Payer and Payee customer IDs
                .distinct()  // Ensure each customer ID appears only once
                .collect(Collectors.toMap(
                        customerId -> customerId,  // Use customerId as the key
                        customerId -> transactions.stream()
                                .filter(tx -> tx.Payer() == customerId || tx.Payee() == customerId)  // Filter transactions for the current customerId
                                .collect(Collectors.toList())  // Collect the filtered transactions into a list
                ));
       
        
        groupByCustomer.forEach((custId,tx)->
        {
        	
        	String fileName = custId+"";
        	try {
                // Write the transactions to the file with the generated filename
                WriteInTxt.writeToFile(tx,fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
