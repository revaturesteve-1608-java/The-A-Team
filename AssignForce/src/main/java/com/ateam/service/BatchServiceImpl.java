package com.ateam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ateam.domain.Batch;
import com.ateam.domain.Curriculum;
import com.ateam.domain.Room;
import com.ateam.domain.Topic;
import com.ateam.domain.Trainer;

@Service
public class BatchServiceImpl implements BatchService{

	@Autowired
	DaoService dao;
	
	public List<Curriculum> getCurriculums(){
		return dao.getAllItem(new Curriculum());
	}

	@Override
	@Transactional
	public void saveBatch(Batch b) {
		
		dao.saveItem(b);
		
	}

	@Override
	public Trainer getTrainerByName(String name) {
		
		List<Trainer> trainers = dao.getAllItem(new Trainer());
		for(int i = 0; i < trainers.size(); i++){
			System.out.println("-----------------batchObj----------------\n" + name);
			System.out.println("-------------Trainer----------------\n" + trainers.get(i).getTrainerFirstName());
			if(name.trim().equals(trainers.get(i).getTrainerFirstName())){
				
				return trainers.get(i);
			} else {
				System.out.println("---------------------------------NOT EQUAL SOMEHOW---------------------------");
			}
		}
		
		return null;
	}

	@Override
	public Topic getTopicByName(String name) {
		
		List<Topic> topics = dao.getAllItem(new Topic());
		for(int i = 0; i < topics.size(); i++){
			if(name.equals(topics.get(i).getTopicName())){
				return topics.get(i);
			}
		}
		
		return null;
	}

	@Override
	public Curriculum getCurriculumByName(String name) {
		
		List<Curriculum> cs = dao.getAllItem(new Curriculum());
		for(int i = 0; i < cs.size(); i++){
			if(name.equals(cs.get(i).getCurriculumName())){
				return cs.get(i);
			}
		}
		
		return null;
	}

	@Override
	public Room getRoomByName(String name) {
		
		List<Room> rooms = dao.getAllItem(new Room());
		for(int i = 0; i < rooms.size(); i++){
			if(name.equals(rooms.get(i).getRoomName())){
				return rooms.get(i);
			}
		}
		
		return null;
	}
	
	
	
	
}
