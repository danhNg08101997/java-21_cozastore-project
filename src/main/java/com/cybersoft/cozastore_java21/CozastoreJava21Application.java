package com.cybersoft.cozastore_java21;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CozastoreJava21Application {

	public static void main(String[] args) {
		SpringApplication.run(CozastoreJava21Application.class, args);
	}

}
