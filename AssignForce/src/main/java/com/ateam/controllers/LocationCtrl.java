package com.ateam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ateam.domain.Location;
import com.ateam.service.DaoService;

@RestController
public class LocationCtrl {

	//Inject DaoServiceImpl
	@Autowired
	DaoService daoService;

	//Returns a List of Locations as JSON data 
	@RequestMapping(value = { "/getlocations"}, 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Location>> getLocations() {

		//Retrieves a list of locations from the database 
		List<Location> re = daoService.getAllItem(new Location());

		//Returns the List as JSON data with the HttpStatus
		return new ResponseEntity<List<Location>>(re, HttpStatus.OK);
	}//end getCurriculums()

	//Receives the data from the location.html "Add Location" option
	@RequestMapping(value = { "/saveLocation"}, 
			method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Location> saveLocation(@RequestBody Location loc) {

		//After the location object is received 
		//from the @RequestBody in the parameter
		//Store it in the database
		loc = daoService.saveItem(loc);
		
		//Return that location object to be displayed on the location.html page
		return new ResponseEntity<Location>(loc, HttpStatus.OK);
	}//end getCurriculums()


}
