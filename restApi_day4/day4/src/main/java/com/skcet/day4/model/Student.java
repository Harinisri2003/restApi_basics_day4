package com.skcet.day4.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
      private int id;
      private String studentName;
      private String deptName;
      private String mailId;
      
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public Student(int id, String studentName, String deptName, String mailId) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.deptName = deptName;
		this.mailId = mailId;
	}
	public Student() {
		super();
	}
    
}
