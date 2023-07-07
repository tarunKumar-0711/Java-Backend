package com.bootValidationCrud.service;

import com.bootValidationCrud.entity.Student;

import java.util.List;

public interface StudentServiceInterface {
	public Student addStudent(Student student);
	public void deleteStudentbyId(int id);
	public Student getStudentById(Integer id);
	public List<Student> getAllStudent();
	public Student updateStudent(Student newStudent, int id);
	public List<Student> getByName(String name);
	public List<Student> find(Student student);
	public List<Student> findStudents(Student student);
	public List<Student> findRollNo(String rollNo);
}
