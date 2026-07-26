package com.springboot.web.security.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Entity
@Getter
@Setter
public class TransactionStatus {
	@Id
	private String transactionId;
	private String  transactionStatus;
	private String customerId;
	@Override
	public String toString() {
		return "TransactionStatus [transactionId=" + transactionId + ", transactionStatus=" + transactionStatus
				+ ", customerId=" + customerId + "]";
	}
	public String getTransactionName() {
		// TODO Auto-generated method stub
		return null;
	}
}
