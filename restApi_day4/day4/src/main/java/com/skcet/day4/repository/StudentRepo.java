package com.skcet.day4.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skcet.day4.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	boolean existsById(int id);

	Optional<Student> findById(Long id);
	
    void deleteById(Long id);
}
