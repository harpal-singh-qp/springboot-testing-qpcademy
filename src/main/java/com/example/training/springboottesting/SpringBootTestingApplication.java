package com.example.training.springboottesting;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author Harpal Singh 11/12/21
 */
@SpringBootApplication
@Slf4j
public class SpringBootTestingApplication implements CommandLineRunner {

	@Autowired
	CourseService courseService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info(courseService.getCourses().toString());

	}
}
