package com.example.training.springboottesting.app;

import com.example.training.springboottesting.app.mockito.CourseService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *----------Schema --------------
 * 	resource -->schema-ddl.sql
 * -------------------------------
 *
 * RabbitMQ Setup
 ###### Download Rabbit MQ Image from DockerHub ##########
 - docker pull rabbitmq:3-management

 ###### Start RabbitMQ ########
 - docker run --rm -it --hostname my-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management

 *
 * @author Harpal Singh 11/12/21
 */
@SpringBootApplication
@Slf4j
public class SpringBootTestingApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestingApplication.class, args);
	}

	@SneakyThrows
	@Override
	public void run(String... args) throws Exception {
		log.info("Started Application..");
      }
}


