package com.ateam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ateam.domain.Trainer;

@Service
public class TrainerServiceImpl implements TrainerService{

	@Autowired
	DaoServiceImpl dao;
	
	public List<Trainer> getTrainers() {
		List<Trainer> trainers = dao.TrainerDao.findAll();
		return trainers;
	}

	public void saveTrainer(Trainer t) {
		dao.TrainerDao.save(t);
		
	}

}
