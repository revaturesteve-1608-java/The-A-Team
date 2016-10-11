package com.ateam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ateam.domain.Curriculum;
import com.ateam.service.BatchService;

@RestController
public class BatchCtrl {

	@Autowired
	BatchService bService;
	
	@RequestMapping(value="/curriculums", method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Curriculum>> getCurriculums(){
		System.out.println("Getting Curriculums");
		
		List<Curriculum> c = bService.getCurriculums();
		
		return new ResponseEntity<List<Curriculum>>(c, HttpStatus.OK);
		
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Exception> batchException(Exception e){
		System.out.println("Getting Exception....");
		
		return new ResponseEntity<Exception>(e, HttpStatus.CONFLICT);
	}
}
