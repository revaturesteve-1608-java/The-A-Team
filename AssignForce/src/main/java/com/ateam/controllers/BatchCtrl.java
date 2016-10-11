package com.ateam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.ExceptionHandler;
=======
>>>>>>> cfe89db6eec7d138883b62045c84e1b43cd88feb
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ateam.domain.Batch;
import com.ateam.domain.Curriculum;
<<<<<<< HEAD
import com.ateam.service.BatchService;
=======
import com.ateam.domain.Trainer;
import com.ateam.service.DaoService;
>>>>>>> cfe89db6eec7d138883b62045c84e1b43cd88feb

@RestController
public class BatchCtrl {

	@Autowired
<<<<<<< HEAD
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
=======
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

		List<Trainer> re = daoService.findAllTrainers();

		return new ResponseEntity<List<Trainer>>(re, HttpStatus.OK);
	}//end getTrainers()

	@RequestMapping(value = { "/batchTest"}, 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Batch>> getBatches() {

//		List<Batch> re = daoService.findAllTrainers();
		List<Batch> re = daoService.getAllItem(new Batch());
System.out.println("re: " + re);
		return new ResponseEntity<List<Batch>>(re, HttpStatus.OK);
	}//end getTrainers()

	
	
>>>>>>> cfe89db6eec7d138883b62045c84e1b43cd88feb
}
