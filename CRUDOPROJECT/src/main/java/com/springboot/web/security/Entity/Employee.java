package com.springboot.web.security.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@Getter
@Setter
@Entity
public class Employee {
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    private String department;
	    private String gender;
	    @JsonIgnore
	    @ManyToOne
	    @JoinColumn(name = "college_id")
	    private Collage collage;


	    @OneToMany(cascade = CascadeType.PERSIST)
	    @JoinColumn(name = "employee_id")
	    private List<Address> addresses;

	    // Other fields, getters, setters, and constructors

	    // Example constructor with Jackson annotations
	    @JsonCreator
	    public Employee(
	            @JsonProperty("name") String name,
	            @JsonProperty("department") String department,
	            @JsonProperty("gender") String gender,
	            @JsonProperty("addresses") List<Address> addresses)
	    
	    {
	        this.name = name;
	        this.department = department;
	        this.gender = gender;
	        this.addresses = addresses;
	        
	  }	
}
