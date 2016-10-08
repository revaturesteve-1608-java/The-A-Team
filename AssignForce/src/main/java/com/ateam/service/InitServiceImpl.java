package com.ateam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ateam.domain.Location;
import com.ateam.domain.Room;
import com.ateam.domain.Skill;
import com.ateam.domain.Trainer;
import com.ateam.rest.RestService;
import com.ateam.rest.RestServiceImpl;

@Service
public class InitServiceImpl implements InitService{

	@Autowired
	private RestService rest = new RestServiceImpl();

	@Autowired
	private DaoServiceImpl dao;
	
	public void initSetup(){
		//TODO
		// grab data from BB
				// trainer, unavailable, skill, room, location
//		dao.getAllItem(new Trainer());
//		rest.getItemFromRest(new Trainer());
		List<Location> locationList_BB = rest.getItemFromRest(new Location());
		List<Trainer> trainerList_BB = rest.getItemFromRest(new Trainer());
		List<Room> roomList_BB = rest.getItemFromRest(new Room());
		List<Skill> skillList_BB = rest.getItemFromRest(new Skill());
		System.out.println("SkillList_BB" + skillList_BB);
/*		List<Unavailable> unavailableList_BB = rest.getItemFromRest(new Unavailable());
*/
		/*
		// grab data from DB
		List<Trainer> trainerList_DB = dao.getAllItem(new Trainer());
		List<Unavailable> unavailableList_DB = dao.getAllItem(new Unavailable());
		List<Skill> skillList_DB = dao.getAllItem(new Skill());
		List<Room> roomList_DB = dao.getAllItem(new Room());
		List<Location> locationList_DB = dao.getAllItem(new Location());
		
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
	
*/
		
		// if anything has changed, update DB
		
		
	}
	
//	private <T> boolean isSame(List<T> a, List<T> b){
//
//		if(a.containsAll(b)){
//			return true;
//		}
//		return false;
////TODO this might need some tweaking	
//	}
	
}
