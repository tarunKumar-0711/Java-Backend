package com.jpa.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
		UserRepository uR = context.getBean(UserRepository.class);
//		User user = new User();
//		user.setCity("Ghaziabad");
//		user.setName("Tarun");
//		user.setStatus("Java Dev");
//	
//		User user2 = new User();
//		user2.setCity("Lucknow");
//		user2.setName("Ujjwal");
//		user2.setStatus("Python dev");
//		
//		User user3 = new User();
//		user3.setCity("Kanpur");
//		user3.setName("Hari");
//		user3.setStatus("Swift dev");
//		
//		User user4 = new User();
//		user4.setCity("Hogwarts");
//		user4.setName("Harry");
//		user4.setStatus("Wizard");
//		
//		
//		List<User> users = List.of(user2,user3,user4);
//		
//		Iterable<User> result = uR.saveAll(users);
//		
//		result.forEach(u ->{
//			System.out.println(u);
//		});
		
		
		//Update  22 
//		Optional<User> opt = uR.findById(11);
//		User u1 = opt.get();
//		u1.setName("Hermoine");
//		u1.setStatus("Muggle");
//		uR.save(u1);
//		System.out.println(u1);
		
		uR.deleteById(12);
		Iterable<User> itr = uR.findAll();
		
		itr.forEach(uu ->{
			if(uu.getName().equals("Tarun") && uu.getId()!=(1)) {
				uR.delete(uu);     
			}
			else {
				System.out.println(uu);
			}
		});
		
		
		//uR.deleteAllById(null);
		
		
	}

}
