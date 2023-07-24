package com.multipledb.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multipledb.db1entities.Student;

@Repository
public interface db1repository extends JpaRepository<Student, Integer> {
	
}
