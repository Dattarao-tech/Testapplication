package com.springboot.web.securityModel;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonCreator;

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
@Getter
@Setter
public class Employee {
	
	private String name;
	private String department;
	private String gender;
	private Addresses addresses;
}
