package com.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TransactionServiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionServiveApplication.class, args);
	}

}
