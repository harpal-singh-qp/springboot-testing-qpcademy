package com.example.training.springboottesting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author Harpal Singh 11/12/21
 */
@SpringBootApplication
public class SpringBootTestingApplication implements CommandLineRunner {

	@Autowired
	CourseService courseService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(courseService.getCourses());
	}
}
