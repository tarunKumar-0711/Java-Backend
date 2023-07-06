package com.jpa.test.dao;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.CrudRepository;

import com.jpa.test.BootjpaexampleApplication;
import com.jpa.test.entities.User;

public interface UserRepository extends CrudRepository<User, Integer>{
	
	

}
