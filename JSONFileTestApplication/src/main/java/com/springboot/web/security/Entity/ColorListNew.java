package com.springboot.web.security.Entity;

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
@Getter
@Setter        
public class ColorListNew {
	private String color;
	private String category;
	private String type;
	@Override
	public String toString() {
		return "ColorListNew [color=" + color + ", category=" + category + ", type=" + type + "]";
	}   

}
