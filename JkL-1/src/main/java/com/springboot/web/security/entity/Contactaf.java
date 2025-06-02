package com.springboot.web.security.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.boot.convert.DataSizeUnit;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contactaf {

	@NotNull
	@Pattern(regexp = "^(Mr/Mrs/Miss/Dr)$", message ="title must have like")
	private String title;
	
	@NotNull 
	@Size(min=3, message = "firstname have only three character")
	private String firstname;
	
	@NotNull
	@Size(min=3, message = "last name must have only three character")
	private String lastname;

	@NotNull
	private Date dateofbirth;
}
