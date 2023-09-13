package com.priya;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User1 {

	@Id
	private int id;
	private String name;
	
	
	
	public String toString() {
		return name + " : " +id;
	}
	public User1() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	

	
}
