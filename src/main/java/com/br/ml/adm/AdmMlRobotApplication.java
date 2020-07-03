package com.br.ml.adm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class AdmMlRobotApplication{// implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AdmMlRobotApplication.class, args);
	}
}
