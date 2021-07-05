package com.adswaresystem.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.adswaresystem.clever.hotelier.clients.entity")
public class SalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesApplication.class, args);
	}

}
