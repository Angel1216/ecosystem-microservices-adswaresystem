package com.example.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.entity.WelcomeEntity;
import com.example.jpa.model.request.WelcomeRequest;
import com.example.jpa.repository.WelcomeRepository;

@RestController
public class Welcome {
	
	@Autowired
	private WelcomeRepository welcomeRepository;
	
	@PostMapping(value = "welcome")
	public String welcome(@RequestBody WelcomeRequest request) {
		WelcomeEntity entity = WelcomeEntity.builder()
				.name(request.getName())
				.build();
		welcomeRepository.save(entity);
		System.out.println("Mensaje de Perueba");
		return "Mensaje de Prueba";
	}
	
}
