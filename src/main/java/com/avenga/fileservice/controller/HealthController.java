package com.avenga.fileservice.controller;

import org.openapitools.api.HealthApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController implements HealthApi {
	
	@Override
	public ResponseEntity<String> health() {
		return new ResponseEntity<>("File serice is alive", HttpStatus.OK); 
	}

}
