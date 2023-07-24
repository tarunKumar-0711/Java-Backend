package com.save.before.service;

import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.save.before.entities.Student;
import com.save.before.repo.StudentRepository;

@Service
public class serviceImpl {

	@Autowired
	private StudentRepository saveRepository;
	private static final Random random = new Random();

//	@PostConstruct
	public void saveData() {
//		int i = 0;
//		Student student = new Student();
//		for(i = 0; i < 1000; i++) {
//			student.setRollNo(i);
//			student.setName("name "+i);
//			saveRepository.save(student);
//		}

		Integer i = 0;
		String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcefdghijklmnopqrstuvwxyz";
		while (i++ < 1000) {
			StringBuilder sb = new StringBuilder();
			Integer rollNo = random.nextInt(1000);
			Integer copy = rollNo;
			while (copy > 0) {
				sb.append(s.charAt(copy % 52));
				copy /= 10;
			}

			saveRepository.save(new Student(rollNo, sb.toString()));
		}
	}
}
