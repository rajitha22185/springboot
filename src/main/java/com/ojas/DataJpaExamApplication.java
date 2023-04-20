package com.ojas;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;

import com.ojas.entity.BookEntity;
import com.ojas.repositories.BookRepository;
//@EntityScan("com.ojas.entity")
@SpringBootApplication
public class DataJpaExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataJpaExamApplication.class, args);
	}

}
