package com.springboot.web.security.Model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Transactionplaylod {
	  private List<TransactionRequestDto> transactionRequestDtos;
	    private List<TransactionStatus> transactionStatuses;
}
