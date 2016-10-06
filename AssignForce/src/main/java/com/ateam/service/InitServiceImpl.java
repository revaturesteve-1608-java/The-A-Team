package com.ateam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ateam.domain.Location;
import com.ateam.domain.Room;
import com.ateam.domain.Skill;
import com.ateam.domain.Trainer;
import com.ateam.domain.Unavailable;
import com.ateam.rest.RestService;

@Service
public class InitServiceImpl implements InitService{

	@Autowired
	private RestService rest;

	@Autowired
	private DaoServiceImpl dao;
	
	@Override
	public void initSetup(){
		//TODO
		// grab data from BB
				// trainer, unavailable, skill, room, location
		List<Trainer> trainerList_BB = rest.getItemFromRest(new Trainer());
		List<Unavailable> unavailableList_BB = rest.getItemFromRest(new Unavailable());
		List<Skill> skillList_BB = rest.getItemFromRest(new Skill());
		List<Room> roomList_BB = rest.getItemFromRest(new Room());
		List<Location> locationList_BB = rest.getItemFromRest(new Location());

		// grab data from DB
		List<Trainer> trainerList_DB = null;
		List<Unavailable> unavailableList_DB = null;
		List<Skill> skillList_DB = null;
		List<Room> roomList_DB = null;
		List<Location> locationList_DB = null;

		
		// Compare data from BB to data from DB
		if(!isSame(trainerList_BB, trainerList_DB)){
			//update the db for trainer
		}
	
		if(!isSame(unavailableList_BB, unavailableList_DB)){
			//update the db for unavailable
		}
	
		if(!isSame(skillList_BB, skillList_DB)){
			//update the db for skill
		}
	
		if(!isSame(roomList_BB, roomList_DB)){
			//update the db for room
		}

		if(!isSame(locationList_BB, locationList_DB)){
			//update the db for location
		}
	

		
		// if anything has changed, update DB
		
		
	}
	
	private <T> boolean isSame(List<T> a, List<T> b){

		if(a.containsAll(b)){
			return true;
		}
		return false;
//TODO this might need some tweaking	
	}
	
}
