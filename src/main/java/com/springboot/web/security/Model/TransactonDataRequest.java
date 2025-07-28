package com.springboot.web.security.Model;

import java.util.List;

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
@ToString
public class TransactonDataRequest {
    private List<Transaction> transactionData;
    private List<TransactionStatus> transactionStatusData;	
}
