package com.springboot.web.security;

import org.springframework.stereotype.Component;

@Component
public class User {
	private static String first_name="ashihs";
	private static String Last_name="dtata";
	public User() {
		super();
	}
	public User(String first_name, String last_name) {
		super();
		this.first_name = first_name;
		Last_name = last_name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return Last_name;
	}
	public void setLast_name(String last_name) {
		Last_name = last_name;
	}
	@Override
	public String toString() {
		return "User [first_name=" + first_name + ", Last_name=" + Last_name + ", getFirst_name()=" + getFirst_name()
				+ ", getLast_name()=" + getLast_name() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
