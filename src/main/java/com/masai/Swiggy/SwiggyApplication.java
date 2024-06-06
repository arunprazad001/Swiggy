package com.masai.Swiggy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SwiggyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwiggyApplication.class, args);
	}

}
