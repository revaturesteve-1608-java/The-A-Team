package com.ateam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ateam.domain.Location;
import com.ateam.service.DaoService;

@RestController
public class LocationCtrl {

	@Autowired
	DaoService daoService;

	@RequestMapping(value = { "/getlocations"}, 
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Location>> getLocations() {

		List<Location> re = daoService.getAllItem(new Location());

		return new ResponseEntity<List<Location>>(re, HttpStatus.OK);
	}//end getCurriculums()


}
