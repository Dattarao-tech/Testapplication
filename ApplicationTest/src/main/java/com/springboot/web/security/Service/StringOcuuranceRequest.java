package com.springboot.web.security.Service;

import java.util.List;
public class StringOcuuranceRequest {
	private List <String> inputeString;
	private List<String> quearyString;
	public StringOcuuranceRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StringOcuuranceRequest(List<String> inputeString, List<String> quearyString) {
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
		return "StringOcuuranceRequest [inputeString=" + inputeString + ", quearyString=" + quearyString + "]";
	}
}
