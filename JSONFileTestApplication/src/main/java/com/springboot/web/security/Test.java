package com.springboot.web.security;

import java.io.IOException;
class Parent{
	void m1() {
		System.out.println("somethfe");
	}
}
class Child extends Parent{
	void m2() throws IOException{
		System.out.println("djsd");
	}
}
public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stu
	
	}
}
