package com.ateam.controllers;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ateam.domain.B_Status;
import com.ateam.domain.Batch;
import com.ateam.domain.Curriculum;
import com.ateam.domain.Location;
import com.ateam.domain.Room;
import com.ateam.domain.Topic;
import com.ateam.domain.Trainer;
import com.ateam.service.DaoService;


@RestController
public class BatchCtrl {


	@Autowired
	DaoService daoService;

	@RequestMapping(value = { "/curriculum"}, 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Curriculum>> getCurriculums() {

		List<Curriculum> re = daoService.getAllItem(new Curriculum());

		return new ResponseEntity<List<Curriculum>>(re, HttpStatus.OK);
	}//end getCurriculums()

	@RequestMapping(value = { "/trainer"}, 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Trainer>> getTrainers() {

		List<Trainer> re = daoService.findAllTrainers();

		return new ResponseEntity<List<Trainer>>(re, HttpStatus.OK);
	}//end getTrainers()

	@RequestMapping(value = { "/batches"}, 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Batch>> getBatches() {
		List<Batch> re = daoService.findAllBatches();

		return new ResponseEntity<List<Batch>>(re, HttpStatus.OK);
	}//end getTrainers()
	
	//Get Topics
	@RequestMapping(value = { "/topics"}, 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Topic>> getTopics() {
		List<Topic> topics = daoService.getAllItem(new Topic());

		return new ResponseEntity<List<Topic>>(topics, HttpStatus.OK);
	}
	
	//Get Rooms
		@RequestMapping(value = { "/rooms"}, 
				method = RequestMethod.GET, 
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Room>> getRooms() {
			List<Room> rooms = daoService.getAllItem(new Room());

			return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
		}
	
	//Save batch
	@RequestMapping(value = { "/saveBatch"}, 
			method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Batch> saveBatch(@RequestBody String batchName, @RequestBody Topic topic, 
			@RequestBody Curriculum curr,
			@RequestBody Trainer t, @RequestBody Location l, @RequestBody Room r, @RequestBody Timestamp d1, 
			@RequestBody Timestamp d2){
		
		Batch b = new Batch(d1, d2, topic, curr, r, new B_Status(1), t, l);
		
		daoService.saveItem(b);
		
		return new ResponseEntity<Batch>(b, HttpStatus.OK);
	}
}
