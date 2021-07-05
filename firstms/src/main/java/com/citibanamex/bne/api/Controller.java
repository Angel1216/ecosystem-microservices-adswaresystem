package com.citibanamex.bne.api;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class Controller {
	private static final Logger logger = LoggerFactory.getLogger(Controller.class);
	
	@RequestMapping(value = "/test/endpoint1")
	public ResponseEntity<Object> test() {	
		
		logger.info("Calling /test/endpoint1");
		
		return new ResponseEntity<>("Calling /test/endpoint1", HttpStatus.OK);
	}
}
