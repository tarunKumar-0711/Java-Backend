package com.springcore;

public class Student {
	
	private String studentName;
	private int studentId;
	private String studentAddress;
	
	
	
	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public String getStudentAddress() {
		return studentAddress;
	}


	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}


	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Student(String studentName, int studentId, String studentAddress) {
		super();
		this.studentName = studentName;
		this.studentId = studentId;
		this.studentAddress = studentAddress;
	}


	@Override
	public String toString() {
		return "Current Student \nStudent Name = " + studentName + "\nStudent Id = " + studentId + "\nStudent Address = " + studentAddress;
	}
	
	
}
