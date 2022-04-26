package com.strankd.myOwnSpringProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class MyOwnSpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyOwnSpringProjectApplication.class, args);
	}

}
