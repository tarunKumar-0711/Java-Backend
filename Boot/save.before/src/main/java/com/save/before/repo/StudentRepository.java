package com.save.before.repo;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.save.before.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	Page<Student> findAll(Pageable pageable);
	
}
