package com.cognizant.academy.qbthon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.cognizant")
public class QBThonApplication {

	public static void main(String[] args) {
		SpringApplication.run(QBThonApplication.class, args);
	}

}
