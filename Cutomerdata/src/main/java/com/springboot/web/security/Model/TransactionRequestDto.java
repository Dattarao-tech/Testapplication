package com.springboot.web.security.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TransactionRequestDto {
	private String transactionName;
	private double amount;
	public Object getTransactionId() {
		// TODO Auto-generated method stub
		return getCustomerId();
	}
	public double getTransactionAmount() {
		// TODO Auto-generated method stub
		return getAmount();
	}
	public String getTransactionDate() {
		// TODO Auto-generated method stub
		return getTransactionDate();
	}
	public Object getCustomerId() {
		// TODO Auto-generated method stub
		return getCustomerId();
		
	}
}