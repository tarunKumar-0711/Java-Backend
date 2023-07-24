package com.application.task;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan
@EnableScheduling
public class Application {
	
	static Logger logger = LogManager.getLogger(Application.class);
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	
		logger.trace("Trace Message");
		logger.debug("Debug Message");
		logger.info("Info Message");
		logger.warn("Warn Message");
		logger.error("Error Message");
		logger.fatal("Fatal Message");
		
		
	}

}
