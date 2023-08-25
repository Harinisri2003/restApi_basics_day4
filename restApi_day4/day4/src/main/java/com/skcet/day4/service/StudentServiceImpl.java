package com.skcet.day4.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import com.skcet.day4.model.Student;
import com.skcet.day4.repository.StudentRepo;

public class StudentServiceImpl implements StudentService{
   
	@Autowired
	private StudentRepo repo;
	@Override
	public boolean addValue(Student stu) {
		// TODO Auto-generated method stub
		boolean idExist=repo.existsById(stu.getId());
		if(!idExist)
		{
			repo.save(stu);
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public List<Student> getValue() {
		// TODO Auto-generated method stub
		return repo.findAll();		
	}

	@Override
	public boolean updateValue(Long id, Student stu) {
		Optional<Student>existingUserOptional=repo.findById(id);
		if(existingUserOptional.isPresent())
		{
		Student userExists=existingUserOptional.get();
		userExists.setStudentName(stu.getStudentName());
		userExists.setDeptName(stu.getDeptName());
		userExists.setMailId(stu.getMailId());
		repo.save(userExists);
		return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean deleteValue(Long id) {
		// TODO Auto-generated method stub
		Optional<Student> existingUserOptional=repo.findById(id);
		if(existingUserOptional.isPresent())
		{
			repo.deleteById(id);
			return true;
		}
		else
		return false;
	}

}
