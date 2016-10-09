package com.ateam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ateam.domain.Location;
import com.ateam.domain.Room;
import com.ateam.domain.Skill;
import com.ateam.domain.Trainer;
import com.ateam.domain.Unavailable;
import com.ateam.rest.RestService;
import com.ateam.rest.RestServiceImpl;

@Service
public class InitServiceImpl implements InitService{
	@Autowired
	private RestService rest;// = new RestServiceImpl();
	// autowiring isnt working... ^ this should not be needed

	@Autowired
	private DaoService dao = new DaoServiceImpl();
	// autowiring isnt working... ^ this should not be needed
	
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

System.out.println("init makes it");
/*		List<Unavailable> unavailableList_BB = new ArrayList<Unavailable>();
		unavailableList_BB.add(arg0);
*/		
		
		
//		List<Trainer> trainerList_DB = dao.getAllItem(new Trainer());
		// grab data from DB
		List<Location> locationList_DB = dao.getAllItem(new Location());
		List<Trainer> trainerList_DB = dao.getAllItem(new Trainer());
		List<Skill> skillList_DB = dao.getAllItem(new Skill());
		System.out.println("trainerList_DB: " + trainerList_DB);
/*		List<Unavailable> unavailableList_DB = dao.getAllItem(new Unavailable());
		List<Room> roomList_DB = dao.getAllItem(new Room());
*/		


		
		// Compare data from BB to data from DB

		if(!isSame(locationList_BB, locationList_DB)){
			//update the db for location
			List<Location> elemList = getDifferences(locationList_BB, locationList_DB);
			for (Location loc : elemList) {
				dao.saveItem(loc);
			}//save all to db
		}
	
		if(!isSame(skillList_BB, skillList_DB)){
			//update the db for skill
			List<Skill> elemList = getDifferences(skillList_BB, skillList_DB);
			for (Skill sk : elemList) {
				dao.saveItem(sk);
			}//save all to db
		}
	
/*		if(!isSame(roomList_BB, roomList_DB)){
			//update the db for room
			List<Room> elemList = getDifferences(roomList_BB, roomList_DB);
			for (Room room : elemList) {
				dao.saveItem(room);
			}//save all to db
			
		}
*/
		if(!isSame(trainerList_BB, trainerList_DB)){
			//update the db for trainer
//			dao.TrainerDao
//			System.out.println("not same, returns what?");
			List<Trainer> elemList = getDifferences(trainerList_BB, trainerList_DB);
			for (Trainer trainer : elemList) {
				dao.saveItem(trainer);
			}//save all to db
			
//			System.out.println(getDifferences(trainerList_BB, trainerList_DB));
		}
	
/*		if(!isSame(unavailableList_BB, unavailableList_DB)){
			//update the db for unavailable
		}
*/	
/*
*/		
		// if anything has changed, update DB
		
		
	}//end initSetup()
	
	private <T> List<T> getDifferences(List<T> a, List<T> b){
		List<T> elemList = new ArrayList<T>();
		int flag = 0;
		
		for (T ta : a) {
			for (T tb : b) {
				if(ta.equals(tb)){
					flag = 1;
					break;
				}
			}
			if(flag == 0){
				elemList.add(ta);
				flag = 0;
			}
		}

		return elemList;
	}//end getDifferences
	
	private <T> boolean isSame(List<T> a, List<T> b){
		if(a.containsAll(b) && !b.isEmpty()){
			return true;
		}
		return false;
	}//end isSame()
	
}
