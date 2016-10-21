package com.ateam.controllers;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ateam.domain.B_Status;
import com.ateam.domain.Batch;
import com.ateam.domain.Curriculum;
import com.ateam.domain.Room;
import com.ateam.domain.Topic;
import com.ateam.domain.Trainer;
import com.ateam.service.BatchService;
import com.ateam.service.DaoService;
import com.revature.dto.BatchDTO;

//Controller for the createbatch.html

@RestController
public class BatchCtrl {


	//Get the dao service
	@Autowired
	DaoService daoService;
	
	//Get the batch service
	@Autowired
	BatchService bServ;

	
	//Gets a list of Curriculums and converts them to JSON format when called by AJAX
	@RequestMapping(value = { "/curriculum"}, 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Curriculum>> getCurriculums() {
		List<Curriculum> re = daoService.getAllItem(new Curriculum());

		return new ResponseEntity<List<Curriculum>>(re, HttpStatus.OK);
	}//end getCurriculums()

	
	//Gets a list of Trainers and converts them to JSON format when called by AJAX
	@RequestMapping(value = { "/trainer"}, 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Trainer>> getTrainers() {

		List<Trainer> re = daoService.findAllTrainers();
System.out.println(re);
		return new ResponseEntity<List<Trainer>>(re, HttpStatus.OK);
	}//end getTrainers()

	
	//Gets a list of Batches and converts them to JSON format when called by AJAX
	@RequestMapping(value = { "/batches"}, 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Batch>> getBatches() {

		List<Batch> re = daoService.findAllBatchStartDate();

		return new ResponseEntity<List<Batch>>(re, HttpStatus.OK);
	}//end getTrainers()
	
	//Gets a list of Topics and converts them to JSON format when called by AJAX
	@RequestMapping(value = { "/topics"}, 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Topic>> getTopics() {
		//Retrieves all topic data from the database
		List<Topic> topics = daoService.getAllItem(new Topic());

		//Returns the list of topics as JSON data
		return new ResponseEntity<List<Topic>>(topics, HttpStatus.OK);
	}
	
	//Gets a list of Rooms and converts them to JSON format when called by AJAX
		@RequestMapping(value = { "/rooms"}, 
				method = RequestMethod.GET, 
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<Room>> getRooms() {
			//Retrieves all room data from the database
			List<Room> rooms = daoService.getAllItem(new Room());

			return new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);
		}
	
		//Retrieves the form data from createbatch.html into the BatchDTO object
		@RequestMapping(value = { "/savebatch"}, 
				method = RequestMethod.POST, 
				consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Batch> saveBatch(@RequestBody BatchDTO batchObj) throws InterruptedException{
			
			//Transfer BatchDTO data into object data 
			Trainer t = bServ.getTrainerByName(batchObj.getTrainer());
			Room room = bServ.getRoomByName(batchObj.getRoom());
			Curriculum c = bServ.getCurriculumByName(batchObj.getCurr());
			Topic topic = bServ.getTopicByName(batchObj.getTopic());
			
			//Create a batch object with the object data
			Batch b = new Batch(batchObj.getBatchName(), new Timestamp(batchObj.getDate().getTime()), 
					new Timestamp(batchObj.getDate2().getTime()), topic,
					c, room, 
					new B_Status(1), t);
			b.setBatchID(batchObj.getBatchId());
			
			//Put the batch data into the database 
			bServ.saveBatch(b);
		
		//Return the new batch as JSON data	
		return new ResponseEntity<Batch>(b, HttpStatus.OK);
		}
	
		//Get a batch JSON data by ID 
	@RequestMapping(value = { "/getbatch"}, 
			method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Batch> getBatchById(@RequestParam("bId") String bId) throws InterruptedException{
		
		//Get batch object by ID
		Batch batch = daoService.findByBatchID(Integer.parseInt(bId));

		
		//Tell the thread to sleep to 2 seconds
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Sends over the BatchJSON data along with a successful status code
		return new ResponseEntity<Batch>(batch, HttpStatus.OK);

	}
	
	
	
}
