package com.example.monitoringNss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MonitoringNssApplication {

	public static void main(String[] args) {

		SpringApplication.run(MonitoringNssApplication.class, args);

	}

}
