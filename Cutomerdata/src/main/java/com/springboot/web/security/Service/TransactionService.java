package com.springboot.web.security.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springboot.web.security.Model.Transaction;
import com.springboot.web.security.Model.TransactionStatus;

@Service
public class TransactionService {
	
    private List<Transaction> transactionData;
    private List<TransactionStatus> transactionStatusData;

    public TransactionService(List<Transaction> transactionData, List<TransactionStatus> transactionStatusData) {
        this.transactionData = transactionData;
        this.transactionStatusData = transactionStatusData;
    }
    
//    public String getMaxCustomer() {
//        // Combine the two datasets based on transactionId
//        List<Transaction> combinedData = new ArrayList<>();
//        for (Transaction tData : transactionData) {
//            TransactionStatus tStatus = findTransactionStatus(tData.getTransactionId());
//            if (tStatus != null) {
//                tData.setTransactionStatus(tStatus.getTransactionStatus());
//                combinedData.add(tData);
//            }
//        }
//
//        // Filter only the completed transactions
//        List<Transaction> completedTransactions = new ArrayList<>();
//        for (Transaction transaction : combinedData) {
//            if ("Completed".equals(transaction.getTransactionStatus())) {
//                completedTransactions.add(transaction);
//            }
//        }
//
//        // Group transactions by CustomerID and calculate total amount for each customer
//        Map<String, Double> customerTotals = new HashMap<>();
//        for (Transaction transaction : completedTransactions) {
//            String customerId = transaction.getCustomerID();
//            double transactionAmount = transaction.getTransactionAmount();
//            if (customerTotals.containsKey(customerId)) {
//                customerTotals.put(customerId, customerTotals.get(customerId) + transactionAmount);
//            } else {
//                customerTotals.put(customerId, transactionAmount);
//            }
//        }
//
//        // Find the customer with the maximum total amount
//        String maxCustomer = null;
//        double maxAmount = Double.MIN_VALUE;
//        for (Map.Entry<String, Double> entry : customerTotals.entrySet()) {
//            if (entry.getValue() > maxAmount) {
//                maxAmount = entry.getValue();
//                maxCustomer = entry.getKey();
//            }
//        }
//
//        return "Customer with the maximum total amount for successful transactions: " + maxCustomer;
//    }
//
//    private TransactionStatus findTransactionStatus(String transactionId) {
//        for (TransactionStatus tStatus : transactionStatusData) {
//            if (tStatus.getTransactionId().equals(transactionId)) {
//                return tStatus;
//            }
//        }
//        return null;
//    }
//
//	public void setTransactionData(List<Transaction> transactionData2) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void setTransactionStatusData(List<TransactionStatus> transactionStatusData2) {
//		// TODO Auto-generated method stub
		
//    public String getMaxCustomer() {
//        if (transactionData == null || transactionStatusData == null) {
//            return "Transaction data or status data is null.";
//        }
//
//        // Combine the two datasets based on transactionId
//        Map<String, Transaction> combinedDataMap = new HashMap<>();
//        for (Transaction tData : transactionData) {
//            combinedDataMap.put(tData.getTransactionId(), tData);
//        }
//
//        for (TransactionStatus tStatus : transactionStatusData) {
//            String transactionId = tStatus.getTransactionId();
//            if (combinedDataMap.containsKey(transactionId)) {
//                combinedDataMap.get(transactionId).setTransactionStatus(tStatus.getTransactionStatus());
//            }
//        }
//
//        // Filter only the completed transactions
//        List<Transaction> completedTransactions = getCompletedTransactions(combinedDataMap);
//
//        // Check if there are no completed transactions
//        if (completedTransactions.isEmpty()) {
//            return "No successful transactions found.";
//        }
//
//        // Group transactions by CustomerID and calculate total amount for each customer
//        Map<String, Double> customerTotals = calculateCustomerTotals(completedTransactions);
//
//        // Find the customer with the maximum total amount
//        String maxCustomer = findMaxCustomer(customerTotals);
//
//        return "Customer with the maximum total amount for successful transactions: " + maxCustomer;
//    }
//
//    private List<Transaction> getCompletedTransactions(Map<String, Transaction> combinedDataMap) {
//        // Existing code for filtering completed transactions...
//    	
//    	return combinedDataMap.values().stream()
//        .filter(transaction -> "Completed".equals(transaction.getTransactionStatus()))
//        .collect(Collectors.toList());
//    }
//    private Map<String, Double> calculateCustomerTotals(List<Transaction> completedTransactions) {
//        // Existing code for calculating customer totals...
//        Map<String, Double> customerTotals = new HashMap<>();
//        for (Transaction transaction : completedTransactions) {
//            String customerId = transaction.getCustomerID();  // Corrected attribute name
//            double transactionAmount = transaction.getTransactionAmount();
//            customerTotals.put(customerId, customerTotals.getOrDefault(customerId, 0.0) + transactionAmount);
//        }
//        return customerTotals;    	    
//    }
//    private String findMaxCustomer(Map<String, Double> customerTotals) {
//        // Existing code for finding max customer...
//        if (customerTotals.isEmpty()) {
//            return null;  // No successful transactions found
//        }
//
//        // Find the customer with the maximum total amount
//        String maxCustomer = customerTotals.entrySet().stream()
//                .max(Map.Entry.comparingByValue())
//                .map(Map.Entry::getKey)
//                .orElse(null);
//
//        return maxCustomer;
//
//    }
//		public void setTransactionData(List<Transaction> transactionData) {
//	    this.transactionData = transactionData;
//	}
//
//	public void setTransactionStatusData(List<TransactionStatus> transactionStatusData) {
//	    this.transactionStatusData = transactionStatusData;
    
//    public String getMaxCustomer(List<Transaction> transactionData, List<TransactionStatus> transactionStatusData) {
//        if (transactionData == null || transactionStatusData == null) {
//            return "Transaction data or status data is null.";
//        }
//
//        Map<String, Transaction> combinedDataMap = new HashMap<>();
//        for (Transaction tData : transactionData) {
//            combinedDataMap.put(tData.getTransactionId(), new Transaction(tData));
//        }
//        for (TransactionStatus tStatus : transactionStatusData) {
//            String transactionId = tStatus.getTransactionId();
//            if (combinedDataMap.containsKey(transactionId)) {
//                combinedDataMap.get(transactionId).setTransactionStatus(tStatus.getTransactionStatus());
//            }
//        }
//
//        List<Transaction> completedTransactions = getCompletedTransactions(combinedDataMap);
//
//        if (completedTransactions.isEmpty()) {
//            return "No successful transactions found.";
//        }
//
//        Map<String, Double> customerTotals = calculateCustomerTotals(completedTransactions);
//
//        String maxCustomer = findMaxCustomer(customerTotals);
//
//        return "Customer with the maximum total amount for successful transactions: " + maxCustomer;
//    }
//
//    private List<Transaction> getCompletedTransactions(Map<String, Transaction> combinedDataMap) {
//        return combinedDataMap.values().stream()
//                .filter(transaction -> "Completed".equals(transaction.getTransactionStatus()))
//                .collect(Collectors.toList());
//    }
//
//    private Map<String, Double> calculateCustomerTotals(List<Transaction> completedTransactions) {
//        Map<String, Double> customerTotals = new HashMap<>();
//        for (Transaction transaction : completedTransactions) {
//            String customerId = transaction.getCustomerID();
//            double transactionAmount = transaction.getTransactionAmount();
//            customerTotals.put(customerId, customerTotals.getOrDefault(customerId, 0.0) + transactionAmount);
//        }
//        return customerTotals;
//    }
//
//    private String findMaxCustomer(Map<String, Double> customerTotals) {
//        if (customerTotals.isEmpty()) {
//            return null;
//        }
//
//        return customerTotals.entrySet().stream()
//                .max(Map.Entry.comparingByValue())
//                .map(Map.Entry::getKey)
//                .orElse(null);
//    }

//    public String getMaxCustomer() {
//        if (transactionData == null || transactionStatusData == null) {
//            return "Transaction data or status data is null.";
//        }
//
//        Map<String, Transaction> combinedDataMap = new HashMap<>();
//        for (Transaction tData : transactionData) {
//            combinedDataMap.put(tData.getTransactionId(), tData);
//        }
//
//        for (TransactionStatus tStatus : transactionStatusData) {
//            String transactionId = tStatus.getTransactionId();
//            if (combinedDataMap.containsKey(transactionId)) {
//                combinedDataMap.get(transactionId).setTransactionStatus(tStatus.getTransactionStatus());
//            }
//        }
//
//        System.out.println("Combined Data Map: " + combinedDataMap);
//
//        List<Transaction> completedTransactions = getCompletedTransactions(combinedDataMap);
//
//        System.out.println("Completed Transactions: " + completedTransactions);
//
//        if (completedTransactions.isEmpty()) {
//            return "No successful transactions found.";
//        }
//
//        Map<String, Double> customerTotals = calculateCustomerTotals(completedTransactions);
//
//        System.out.println("Customer Totals: " + customerTotals);
//
//        String maxCustomer = findMaxCustomer(customerTotals);
//
//        return "Customer with the maximum total amount for successful transactions: " + maxCustomer;
//    } 
//    private List<Transaction> getCompletedTransactions(Map<String, Transaction> combinedDataMap) {
//        return combinedDataMap.values().stream()
//                .filter(transaction -> "Completed".equals(transaction.getTransactionStatus()))
//                .collect(Collectors.toList());
//    }
//
//    private Map<String, Double> calculateCustomerTotals(List<Transaction> completedTransactions) {
//        Map<String, Double> customerTotals = new HashMap<>();
//        for (Transaction transaction : completedTransactions) {
//            String customerId = transaction.getCustomerId();
//            double transactionAmount = transaction.getTransactionAmount();
//            customerTotals.put(customerId, customerTotals.getOrDefault(customerId, 0.0) + transactionAmount);
//        }
//        return customerTotals;
//    }
//
//    private String findMaxCustomer(Map<String, Double> customerTotals) {
//        if (customerTotals.isEmpty()) {
//            return null;  // No successful transactions found
//        }
//
//        return customerTotals.entrySet().stream()
//                .max(Map.Entry.comparingByValue())
//                .map(Map.Entry::getKey)
//                .orElse(null);
//    }
//
//    public void setTransactionData(List<Transaction> transactionData) {
//        this.transactionData = transactionData;
//    }
//
//    public void setTransactionStatusData(List<TransactionStatus> transactionStatusData) {
//        this.transactionStatusData = transactionStatusData;
//    }
//}


    

    public String getMaxCustomer() {
        if (transactionData == null || transactionStatusData == null) {
            return "Transaction data or status data is null.";
        }
        Map<String, Transaction> combinedDataMap = new HashMap<>();
        for (Transaction tData : transactionData) {
            combinedDataMap.put(tData.getTransactionId(), tData);
        }
        for (TransactionStatus tStatus : transactionStatusData) {
            String transactionId = tStatus.getTransactionId();
            if (combinedDataMap.containsKey(transactionId)) {
                combinedDataMap.get(transactionId).setTransactionStatus(tStatus.getTransactionStatus());
                // Set the customerId in Transaction using TransactionStatus
                String customerId = tStatus.getCustomerId();
                if (customerId != null) {
                    combinedDataMap.get(transactionId).setCustomerId(customerId);
                }
            }
        }
        System.out.println("Combined Data Map: " + combinedDataMap);

        List<Transaction> completedTransactions = getCompletedTransactions(combinedDataMap);

        System.out.println("Completed Transactions: " + completedTransactions);

        if (completedTransactions.isEmpty()) {
            return "No successful transactions found.";
        }
        Map<String, Double> customerTotals = calculateCustomerTotals(completedTransactions);

        System.out.println("Customer Totals: " + customerTotals);

        String maxCustomer = findMaxCustomer(customerTotals);

        return "Customer with the maximum total amount for successful transactions: " + maxCustomer;
    }
    private List<Transaction> getCompletedTransactions(Map<String, Transaction> combinedDataMap) {
        return combinedDataMap.values().stream()
                .filter(transaction -> "Completed".equals(transaction.getTransactionStatus()))
                .collect(Collectors.toList());
    }
    private Map<String, Double> calculateCustomerTotals(List<Transaction> completedTransactions) {
        Map<String, Double> customerTotals = new HashMap<>();
        for (Transaction transaction : completedTransactions) {
            String customerId = transaction.getCustomerId();
            double transactionAmount = transaction.getTransactionAmount();
            customerTotals.put(customerId, customerTotals.getOrDefault(customerId, 0.0) + transactionAmount);
        }
        return customerTotals;
    }
    private String findMaxCustomer(Map<String, Double> customerTotals) {
        if (customerTotals.isEmpty()) {
            return null;  // No successful transactions found
        }
        return customerTotals.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public void setTransactionData(List<Transaction> transactionData) {
        this.transactionData = transactionData;
    }
    public void setTransactionStatusData(List<TransactionStatus> transactionStatusData) {
        this.transactionStatusData = transactionStatusData;
    }
    // You may have other setter/getter methods for the attributes in your Transaction and TransactionStatus classes.
}



