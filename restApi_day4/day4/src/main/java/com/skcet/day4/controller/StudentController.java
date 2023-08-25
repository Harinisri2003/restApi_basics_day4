package com.skcet.day4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skcet.day4.model.Student;
import com.skcet.day4.service.StudentService;


@RestController
@RequestMapping("/api/v1/controller")
public class StudentController {
   @Autowired
   private StudentService stus;
   
   @GetMapping("/getUser")
	public ResponseEntity<List<Student>> getValue(){
		return ResponseEntity.status(200).body(stus.getValue());
	}
	
	@PostMapping("/addUser")
	public ResponseEntity<String> addValue(@RequestBody Student stu){
		boolean dataSaved = stus.addValue(stu);
		if(dataSaved) {
			return ResponseEntity.status(200).body("User added successfully!");
		}else {
			return ResponseEntity.status(404).body("Something went wrong!");
		}
	}
	
	@PutMapping("/addput/{id}")
	public ResponseEntity<String> updateValue(@PathVariable Long id,@RequestBody Student stu)
	{
		boolean userData=stus.updateValue(id, stu);
		if(userData)
		{
			return ResponseEntity.status(200).body("updated successfully");
		}
		else
		{
			return ResponseEntity.status(404).body("not updated successfully");
		}
//		return null;
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteValue(@RequestParam Long id)
	{
		boolean userDeleted=stus.deleteValue(id);
		if(userDeleted)
		{
			return ResponseEntity.status(200).body("deleted successfully");
		}
		else
		{
			return ResponseEntity.status(404).body("No records found");
		}
	}
}
