/**
 * 
 */
package com.springboot.web.security.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Microsoft
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Address {
	 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<String> homeAddress;

    private String salary;
    private String statusCode;

    // Constructors, getters, setters

    // Example constructor with Jackson annotations
    @JsonCreator
    public Address(
            @JsonPropertyDescription("homeAddress") List<String> homeAddress,
            @JsonProperty("salary") String salary,
            @JsonProperty("statusCode") String statusCode) {
        this.homeAddress = homeAddress;
        this.salary = salary;
        this.statusCode = statusCode;
    }
	public void setEmployee(Employee savedEmployee) {
		// TODO Auto-generated method stub	
	}	  
}
