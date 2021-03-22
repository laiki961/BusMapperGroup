package com.fsse.busmapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class BusmapperApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusmapperApplication.class, args);
	}

}
