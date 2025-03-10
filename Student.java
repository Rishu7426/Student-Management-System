//contains Column names(private data members and public methods to access them).
package com.student.manage;

public class Student {
	private int studentId;
	private String studentName;
	private String studentPhone;
	private String studentCity;

	// getter method id
	public int getStudentId() {
		return studentId;
	}

	// setter method id
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	// getter method name
	public String getStudentname() {
		return studentName;
	}

	// setter method name
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	// getter method phone
	public String getstudentPhone() {
		return studentPhone;
	}

	// setter method phone
	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}

	// getter method city
	public String getStudentCity() {
		return studentCity;
	}

	// setter method city
	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}

	public Student(int studentId, String studentName, String studentPhone, String studentCity) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentPhone = studentPhone;
		this.studentCity = studentCity;
	}

	public Student(String studentName, String studentPhone, String studentCity) {
		super();
		this.studentName = studentName;
		this.studentPhone = studentPhone;
		this.studentCity = studentCity;
	}

	public Student() {
		super();
	}

	// ToString method
	@Override
	public String toString() {
		return "Student [studentId= " + studentId + " , studentName= " + studentName + " , studentPhone= "
				+ studentPhone + " , studentCity= " + studentCity + "]";
	}

	public static void main(String[] args) {

	}
}
