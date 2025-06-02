package com.sts.springboot.topiccontroller;

public class Topic {
	private String id;
	private String name;
	private String descripation;
	
	public Topic() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescripation() {
		return descripation;
	}
	public void setDescripation(String descripation) {
		this.descripation = descripation;
	}
	public Topic(String id, String name, String descripation) {
		super();
		this.id = id;
		this.name = name;
		this.descripation = descripation;
	}
}
