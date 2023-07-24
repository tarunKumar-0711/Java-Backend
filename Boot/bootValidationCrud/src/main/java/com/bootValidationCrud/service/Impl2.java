package com.bootValidationCrud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bootValidationCrud.entity.Student;

@Service(value = "hello2")
public class Impl2  implements StudentServiceInterface{

	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStudentbyId(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student getStudentById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllStudent() {
		System.out.println("in 2 method");
		return null;
	}

	@Override
	public Student updateStudent(Student newStudent, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> find(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findStudents(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> findRollNo(String rollNo) {
		// TODO Auto-generated method stub
		return null;
	}

}
