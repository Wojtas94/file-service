package com.avenga.fileservice.controller;

import org.openapitools.api.CountApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import com.avenga.fileservice.service.FileService;

@RestController
public class CountController implements CountApi {

	private final FileService fileService;

	@Autowired
	public CountController(FileService fileService) {
		this.fileService = fileService;
	}

    @Override
	public ResponseEntity<Long> countFiles() {	
        long count = fileService.countFiles();
        return new ResponseEntity<>(count, HttpStatus.OK);	
    }    
}
