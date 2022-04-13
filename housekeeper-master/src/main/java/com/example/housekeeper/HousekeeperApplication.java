package com.example.housekeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;



@SpringBootApplication
@EnableScheduling
public class HousekeeperApplication {


	public static void main(String[] args) {
		SpringApplication.run(HousekeeperApplication.class, args);
	}

}
