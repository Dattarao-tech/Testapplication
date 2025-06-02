package com.springboot.web.security.Sevice;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
public class StringOccuranceRequst {
	
	private List <String> inputeString;
	private List<String> quearyString;
	public StringOccuranceRequst() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StringOccuranceRequst(List<String> inputeString, List<String> quearyString) {
		super();
		this.inputeString = inputeString;
		this.quearyString = quearyString;
	}
	public List<String> getInputeString() {
		return inputeString;
	}
	public void setInputeString(List<String> inputeString) {
		this.inputeString = inputeString;
	}
	public List<String> getQuearyString() {
		return quearyString;
	}
	public void setQuearyString(List<String> quearyString) {
		this.quearyString = quearyString;
	}
	@Override
	public String toString() {
		return "StringOccuranceRequst [inputeString=" + inputeString + ", quearyString=" + quearyString + "]";
	}
}
