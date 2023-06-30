package com.bootValidationCrud.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bootValidationCrud.entity.Student;

public interface StudentCrudRepo extends JpaRepository<Student, Integer>,  JpaSpecificationExecutor<Student>{
	@Query("SELECT s FROM Student s WHERE s.name = :name")
    List<Student> findByFirstName(@Param("name") String name);
	
	List<Student> findByNameAndSubjectAndStateAndRollNoAndEmailAndSports(
            String name, String subject, String state, String rollNo, String email, String sports
    );
	
	
}
