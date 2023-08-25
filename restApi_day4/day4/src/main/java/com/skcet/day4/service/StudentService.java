package com.skcet.day4.service;

import java.util.List;

import com.skcet.day4.model.Student;

public interface StudentService {
	public boolean addValue(Student stu);
	public List<Student> getValue();
	
	public boolean updateValue(Long id,Student stu);
	public boolean deleteValue(Long id);
}
