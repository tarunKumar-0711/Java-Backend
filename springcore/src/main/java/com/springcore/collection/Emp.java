package com.springcore.collection;
import java.util.*;
public class Emp {
	private String name;
	private List<String> phone;
	private Set<String> address;
	private Map<String,String> course;
	
	public Emp(String name, List<String> phone, Set<String> address, Map<String, String> course) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.course = course;
	}

	
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public List<String> getPhone() {
		return phone;
	}



	public void setPhone(List<String> phone) {
		this.phone = phone;
	}



	public Set<String> getAddress() {
		return address;
	}



	public void setAddress(Set<String> address) {
		this.address = address;
	}



	public Map<String, String> getCourse() {
		return course;
	}



	public void setCourse(Map<String, String> course) {
		this.course = course;
	}



	@Override
	public String toString() {
		return "Emp \nname=" + name + "\nphone=" + phone + "\naddress=" + address + "\ncourse=" + course + "]";
	}



	
	
	
}
