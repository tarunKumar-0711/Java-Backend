package com.bootValidationCrud.service;
import org.springframework.data.jpa.domain.Specification;

import org.springframework.data.domain.Sort;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.bootValidationCrud.customException.CannotBeAdded;
import com.bootValidationCrud.customException.EmptyListException;
import com.bootValidationCrud.customException.NoSuchStudentExists;
import com.bootValidationCrud.entity.Student;
import com.bootValidationCrud.repo.StudentCrudRepo;


@Service
public class StudentService implements StudentServiceInterface{

	@Autowired
	private StudentCrudRepo crudRepo;
	
	
	public Student addStudent(Student student)
	{
		try {
			Student savedStudent = crudRepo.save(student);
			return savedStudent;
		}
		catch (CannotBeAdded e) {
			throw new CannotBeAdded("604","Item cannot be added"); 
		}
	}
	public void deleteStudentbyId(int id) {
		try {
			Student student = crudRepo.findById(id).get();
			crudRepo.delete(student);
		}
		catch(NoSuchElementException e) {
			throw new NoSuchStudentExists("601", "There is no student present by this id.");
		}
	}
	public Student getStudentById(Integer id) {
		try {
			Student student = crudRepo.findById(id).get();
			System.out.println(student);
			if(student==null) {
				throw new NoSuchStudentExists("601", "There is no student present by this id.");
			}
			return student;
		}
		catch(NoSuchElementException e){
			throw new NoSuchStudentExists("601", "There is no student present by this id.");
			}
		
	}
	public List<Student> getAllStudent(){
		List<Student> studentList = null;
		try {
			studentList = crudRepo.findAll();
			return studentList;
		}
		catch(EmptyListException e){
			throw new EmptyListException("602", "The List is Empty");
		}
		
		catch (Exception e) {
		    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No value is present in the database", e);
		}
	}
	
	public Student updateStudent(Student newStudent, int id) {
		
		try {
			Student oldStudent = crudRepo.findById(id).get();
			oldStudent.setEmail(newStudent.getEmail());
			oldStudent.setRollNo(newStudent.getRollNo());
			oldStudent.setName(newStudent.getName());
			
			oldStudent.setAddress(newStudent.getAddress());
			crudRepo.save(oldStudent);
			return oldStudent;
		}
		catch(NoSuchStudentExists e) {
			throw new NoSuchStudentExists("601", "There is no student present by this id.");
		}
	}
	
	public List<Student> getByName(String name) {
	    List<Student> listStudents = new ArrayList<>();
//	    
//	    for (Student student : crudRepo.findAll()) {
//	        if (student.getName().equals(name)) {
//	            listStudents.add(student);
//	        }
//	    }
//	    
	    listStudents = crudRepo.findAll().stream()
	    				.filter(student -> student.getName().equals(name))
	    				.collect(Collectors.toList());
	    
	    if(listStudents.isEmpty())
	    	throw new EmptyListException("607","No student with the given name exists.");
	    return listStudents;
	}
	
	public List<Student> find(Student student) {
		List<Student> listStudents = crudRepo.findAll();
		//System.out.println("Complete List was generated");
			
		if(student==null && !listStudents.isEmpty()) {
			return listStudents;
		}
		
		//System.out.println("Complete List generated was not empty");
		
		if(listStudents.isEmpty())
			throw new EmptyListException("607","No student with the given name exists.");
		

		
		List<Student> filtereList = listStudents.stream()
				.filter( s -> ((s.getName()!=null) && (s.getName().equals( (student.getName()==null || student.getName().length()==0) ? s.getName(): student.getName())))
						    &&((s.getEmail()!=null)&& (s.getEmail().equals((student.getEmail()==null  || student.getEmail().length()==0 )? s.getEmail() : student.getEmail())))
						    &&((s.getSports()!=null) && (s.getSports().equals((student.getSports()==null || student.getSports().length()==0)? s.getSports() : student.getSports())))
						    &&((s.getState()!=null) && (s.getState().equals((student.getState()==null || student.getState().length()==0)? s.getState() : student.getState())))
						    &&((s.getRollNo()!=null)&& (s.getRollNo().equals((student.getRollNo()==null || student.getRollNo().length()==0)? s.getRollNo() : student.getRollNo())))
						    &&((s.getSubject()!=null) && (s.getSubject().equals((student.getSubject()==null || student.getSubject().length()==0)? s.getSubject() : student.getSubject())))
						)
				.collect(Collectors.toList());
		
//		System.out.println("Email "+student.getEmail());
//		System.out.println(student.getRollNo());
//		System.out.println(student.getSubject());
//		System.out.println(student.getSports());
//		System.out.println(student.getState());
		
		if(filtereList.isEmpty())
			throw new EmptyListException("607","No student with the given name exists.");
		
		return filtereList;
	}
	
	public List<Student> findStudents(Student student){
		   Specification<Student> spec = (root, query, criteriaBuilder) -> {
	            List<Predicate> predicates = new ArrayList<>();

	            if (student.getName() != null && !student.getName().isEmpty()) {
	                predicates.add(criteriaBuilder.equal(root.get("name"), student.getName()));
	            }

	            if (student.getSubject() != null && !student.getSubject().isEmpty()) {
	                predicates.add(criteriaBuilder.equal(root.get("subject"), student.getSubject()));
	            }

	            if (student.getState() != null && !student.getState().isEmpty()) {
	                predicates.add(criteriaBuilder.equal(root.get("state"), student.getState()));
	            }

	            if (student.getRollNo() != null && !student.getRollNo().isEmpty()) {
	                predicates.add(criteriaBuilder.equal(root.get("rollNo"), student.getRollNo()));
	            }

	            if (student.getEmail() != null && !student.getEmail().isEmpty()) {
	                predicates.add(criteriaBuilder.equal(root.get("email"), student.getEmail()));
	            }

	            if (student.getSports() != null && !student.getSports().isEmpty()) {
	                predicates.add(criteriaBuilder.equal(root.get("sports"), student.getSports()));
	            }

	            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
	        };
	        
	        Sort sort = Sort.by(Sort.Direction.ASC, "name");
	        
	        return crudRepo.findAll(spec,sort);
	    }
		
	}

