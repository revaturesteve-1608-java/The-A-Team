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

import com.ateam.domain.Trainer;
import com.ateam.service.TrainerService;

@RestController
public class TrainerCtrl {
	
	//Inject trainer service 
	@Autowired
	TrainerService trainerServiceImpl;
	
	//Returns Trainer List JSON data
	@RequestMapping(value="/viewtrainers", method=RequestMethod.GET, 
					produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Trainer>> getTrainers(){
		
		List<Trainer> trainers = trainerServiceImpl.getTrainers();
		
		return new ResponseEntity<List<Trainer>>(trainers, HttpStatus.OK);
	}
	
	//Throws an exception when there's an error with the other rest controllers
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Exception> trainerException(Exception e){
		
		return new ResponseEntity<Exception>(e, HttpStatus.CONFLICT);
	}
	
}
