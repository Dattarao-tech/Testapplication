package com.springboot.web.security.Service;
import org.springframework.stereotype.Service;
@Service
public class TransactionService {
//	public String getcutomerwithmaxtotal(List<Transaction> transaction, List<TrasactionStatus> trasactionStatus) {
//		
//		Map<String, Double> collect = transaction.stream().filter(tra ->"Completd".equals(getTransactionStatus(tra.getTransactionId(),trasactionStatus)))
//		.collect(Collectors.groupingBy(Transaction::getCustomerID, Collectors.summarizingDouble(Transaction::getTransactionAmount)));
//	if(collect.isEmpty()) {
//	return "No transaction record";
//	}
////	String cutomerIdwithAmount =collect.entrySet().stream()
//			String cutomerIdwithmaxamunt=collect.entrySet().stream().map(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("no cutomer found");
//			
//	private Object getTransactionStatus(String transactionId, List<TrasactionStatus> trasactionStatus) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
}
