package com.ateam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ateam.domain.Curriculum;
import com.ateam.domain.Trainer;
import com.ateam.service.DaoService;

@RestController
public class BatchCtrl {

	@Autowired
	DaoService daoService;

	@RequestMapping(value = { "/curriculum"}, 
			method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Curriculum>> getCurriculums() {

		List<Curriculum> re = daoService.getAllItem(new Curriculum());

		return new ResponseEntity<List<Curriculum>>(re, HttpStatus.OK);
	}//end getCurriculums()

	@RequestMapping(value = { "/trainer"}, 
			method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Trainer>> getTrainers() {

		List<Trainer> re = daoService.getAllItem(new Trainer());

		return new ResponseEntity<List<Trainer>>(re, HttpStatus.OK);
	}//end getTrainers()

	
	
}
