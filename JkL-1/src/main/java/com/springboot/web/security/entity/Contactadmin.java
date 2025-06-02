package com.springboot.web.security.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Contactadmin {
	@Id
	@Generated(value = {""})
	private Integer contactId;
	
	private String fullname;
	
	private long contactNumber;
	
	private String contactype;

}
