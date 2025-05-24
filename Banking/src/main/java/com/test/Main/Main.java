package com.test.Main;


import java.util.List;
import java.util.Map;

import com.test.Collections.Customer;
import com.test.Collections.Transaction;
import com.test.MongoDBConnection.MongoDBConnection;
import com.test.MongoToPojo.MongoRecordMapper;
import com.test.Stream.Processing;

public class Main {
    public static void main(String[] args) {
        // Register collection names with record classes
        Map<String, Class<?>> collectionRegistry = Map.of(
            "Transaction", Transaction.class,
            "Customer", Customer.class
        );
        
        // Connect to MongoDB
        var database = MongoDBConnection.getDatabase();

        MongoRecordMapper r = new MongoRecordMapper(database, collectionRegistry);
        
        // Load all collections into a Map
        Map<String, List<?>> loadedData = r.loadAllCollections();
        
        // Fetching the data
        List<Transaction> transactions = (List<Transaction>) loadedData.get("Transaction");
        List<Customer> customers = (List<Customer>) loadedData.get("Customer");
        
        // Create the Processing object
        Processing processing = new Processing(r);
        
        String directoryPath = "transactions";
        
        // Process the Transaction data
        String className = Transaction.class.getSimpleName();
        processing.writeObjectsByDate(transactions, className);
        
        // Write customer transactions (assuming customerId 1001 as an example)
        processing.writeCustomerTransactions(1001, "Customer");

        // Now process transactions grouped by customerId
        processing.groupTransactionsByCustomerId(transactions,customers);
    }
}

