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

import com.ateam.domain.Batch;
import com.ateam.service.ViewBatchService;

@RestController
public class ViewBatchCtrl {
	
	//Inject ViewBatchServiceImpl
	@Autowired
	ViewBatchService viewBatchService;

	
	//Returns a list of batches as JSON data
	@RequestMapping(value = "/viewbatches", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Batch>> getTrainers() {

		//Retrieves batch data from the database
		List<Batch> batches = viewBatchService.getBatches();

		//Returns the List of batches along with the status code
		return new ResponseEntity<List<Batch>>(batches, HttpStatus.OK);
	}
	

	//When there in error accessing a controller, throw exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Exception> batchException(Exception e) {

		return new ResponseEntity<Exception>(e, HttpStatus.CONFLICT);
	}

}
