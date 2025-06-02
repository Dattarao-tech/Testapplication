package com.springboot.web.security.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {
	   @Id
	   private String transactionId;
       private double transactionAmount;
       private LocalDate transactionDate;
       private String customerId;
       private String transactionStatus;
	  public String getCustomerId() {
	        return customerId;
	    }
	    public void setCustomerId(String customerId) {
	        this.customerId = customerId;
	    }
	public Transaction(Transaction tData) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionAmount=" + transactionAmount
				+ ", transactionDate=" + transactionDate + ", customerId=" + customerId + ", transactionStatus="
				+ transactionStatus + "]";
	}
}
