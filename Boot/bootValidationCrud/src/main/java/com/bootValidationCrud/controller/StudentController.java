package com.bootValidationCrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootValidationCrud.customException.EmptyListException;
import com.bootValidationCrud.customException.NoSuchStudentExists;
import com.bootValidationCrud.entity.Student;
import com.bootValidationCrud.repo.StudentCrud;
import com.bootValidationCrud.repo.StudentCrudRepo;
import com.bootValidationCrud.service.StudentServiceInterface;
import com.bootValidationCrud.service.ExtractFromJsonInterface;

import java.util.List;

import javax.validation.Valid;
@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentServiceInterface studentServiceInterface;
	//private ExtractFromJsonInterface extractFromJsonInterface;
	
	@Autowired
	private StudentCrudRepo studentCrudRepo;
	@Autowired
	private StudentCrud studentCrud;
	
	@PostMapping("/save")
	public ResponseEntity<?> addEmployee(@Valid @RequestBody Student student){
		try {
			Student studentsaved = studentServiceInterface.addStudent(student);
			return new ResponseEntity<Student>(studentsaved,HttpStatus.CREATED);
		}
		catch (IllegalArgumentException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudent(){
		
		List<Student> listOfAllStudents = studentServiceInterface.getAllStudent();
		if(listOfAllStudents.size()==0 || listOfAllStudents.isEmpty())
			throw new NoSuchStudentExists("601", "There is no student present by this id.");
		return new ResponseEntity<List<Student>>(listOfAllStudents,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteStudentById(@PathVariable("id") Integer id) {
		studentServiceInterface.deleteStudentbyId(id);
	}
	
	@GetMapping("/fetchOne/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id")  Integer id){
		try {
			Student student = studentServiceInterface.getStudentById(id);
			if(student==null) {
				throw new NoSuchStudentExists("601", "There is no student present by this id.");
			}
			return new ResponseEntity<Student>(student, HttpStatus.OK);
		}
		catch(NoSuchStudentExists e){
			throw new NoSuchStudentExists("601", "There is no student present by this id.");
		}	
	}
	
	@PutMapping("/updateStudent/{id}")
	public ResponseEntity<Student> updateStudent(@Valid @RequestBody Student student, @PathVariable("id") int id){
		Student studentSaved = studentServiceInterface.updateStudent(student,id);
		return new ResponseEntity<Student>(studentSaved, HttpStatus.CREATED);
	}
	
	@GetMapping("/fetchByName/{name}")
	public ResponseEntity<List<Student>> getStudentsByName(@PathVariable("name") String name){
		
		List<Student> listOfAllStudents = studentServiceInterface.getByName(name);
		if(listOfAllStudents.isEmpty())
			throw new EmptyListException("607","No student with the given name exists.");
		return new ResponseEntity<List<Student>>(listOfAllStudents,HttpStatus.OK);
	}
	
	@PostMapping("/find")
	public ResponseEntity<List<Student>> getStudents(@RequestBody Student student){
//		System.out.println((name));
//		name = extractFromJsonInterface.extractNameFromJson(name);
//		if(name==null)
//			System.out.println(name);
//		System.out.println(student.getEmail());
//		System.out.println(student.getRollNo());
//		System.out.println(student.getSubject());
//		System.out.println(student.getSports());
//		System.out.println(student.getState());
		
		List<Student> listOfAllStudents = studentServiceInterface.find(student);
		
		if(listOfAllStudents.isEmpty())
			throw new EmptyListException("607","No student with the given name exists.");
		
		return new ResponseEntity<List<Student>>(listOfAllStudents,HttpStatus.OK);
	}
	
	@GetMapping("/students/{name}")
    public ResponseEntity<List<Student>> getUsersByFirstName(@PathVariable String name) {
        List<Student> students = studentCrudRepo.findByFirstName(name);
        // Further processing or returning the users as needed
        if(students.isEmpty())
        	throw new EmptyListException("607","No student with the given name exists.");
        return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
    }
	
	 @PostMapping("/findStudents")
	    public ResponseEntity<List<Student>> findStudents(@RequestBody Student student) {
		 List<Student> listStudents = studentServiceInterface.findStudents(student);
	        return new ResponseEntity<List<Student>>(listStudents,HttpStatus.OK);
	    }
	 
	 @PostMapping("/findStudentsFromRepo")
	 public ResponseEntity<List<Student>> findStudentsFrpmRepo(@RequestBody Student student){
		 List<Student> listStudents = studentCrudRepo.findByNameAndSubjectAndStateAndRollNoAndEmailAndSports(
				 student.getName(), student.getSubject(), 
				 student.getState(), student.getRollNo(), 
				 student.getEmail(), student.getSports());
		 
		 return new ResponseEntity<List<Student>>(listStudents,HttpStatus.OK);
	 }
	 
	 @PostMapping("/students/search")
	 public ResponseEntity<List<Student>> searchStudents(@RequestBody Student student) {
		 Integer id = student.getId();
	     String name = student.getName();
	     String subject = student.getSubject();
	     String state = student.getState();
	     String rollNo = student.getRollNo();
	     String email = student.getEmail();
	     String sports = student.getSports();

	     List<Student> matchingStudents = studentCrud.findStudents(id,name, subject, state, rollNo, email, sports);

	     if(matchingStudents.isEmpty()){
	         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	     }
	     else{
	         return ResponseEntity.ok(matchingStudents);
	     }
	 }
}


