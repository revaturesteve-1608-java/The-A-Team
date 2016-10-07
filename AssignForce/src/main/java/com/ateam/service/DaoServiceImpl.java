package com.ateam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ateam.dao.BStatusDao;
import com.ateam.dao.BatchDao;
import com.ateam.dao.CurriculumDao;
import com.ateam.dao.LocationDao;
import com.ateam.dao.RStatusDao;
import com.ateam.dao.RoomDao;
import com.ateam.dao.SkillDao;
import com.ateam.dao.TopicDao;
import com.ateam.dao.TrainerDao;
import com.ateam.dao.UnavailableDao;
import com.ateam.domain.B_Status;
import com.ateam.domain.Batch;
import com.ateam.domain.Curriculum;
import com.ateam.domain.Location;
import com.ateam.domain.R_Status;
import com.ateam.domain.Room;
import com.ateam.domain.Skill;
import com.ateam.domain.Topic;
import com.ateam.domain.Trainer;
import com.ateam.domain.Unavailable;

@Transactional
@Service
public class DaoServiceImpl{
	@Autowired
	BatchDao BatchDao;
	@Autowired
	BStatusDao BStatusDao;
	@Autowired
	CurriculumDao CurriculumDao;
	@Autowired
	LocationDao LocationDao;
	@Autowired
	RoomDao RoomDao;
	@Autowired
	RStatusDao RStatusDao;
	@Autowired
	SkillDao SkillDao;
	@Autowired
	TopicDao TopicDao;
	@Autowired
	TrainerDao TrainerDao;
	@Autowired
	UnavailableDao UnavailableDao;

	@SuppressWarnings("unchecked")
	public <T> List<T> getAllItem(T sample) {

		if ((Class<T>) sample.getClass() == Batch.class) {
			return (List<T>) BatchDao.findAll();
		} else if ((Class<T>) sample.getClass() == BStatusDao.class) {
			return (List<T>) BStatusDao.findAll();
		} else if ((Class<T>) sample.getClass() == CurriculumDao.class) {
			return (List<T>) CurriculumDao.findAll();
		} else if ((Class<T>) sample.getClass() == LocationDao.class) {
			return (List<T>) LocationDao.findAll();
		} else if ((Class<T>) sample.getClass() == RoomDao.class) {
			return (List<T>) RoomDao.findAll();
		} else if ((Class<T>) sample.getClass() == RStatusDao.class) {
			return (List<T>) RStatusDao.findAll();
		} else if ((Class<T>) sample.getClass() == SkillDao.class) {
			return (List<T>) SkillDao.findAll();
		} else if ((Class<T>) sample.getClass() == TopicDao.class) {
			return (List<T>) TopicDao.findAll();
		} else if ((Class<T>) sample.getClass() == TrainerDao.class) {
			return (List<T>) TrainerDao.findAll();
		} else if ((Class<T>) sample.getClass() == UnavailableDao.class) {
			return (List<T>) UnavailableDao.findAll();
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T save(T sample) {
		if ((Class<T>) sample.getClass() == Batch.class) {
			return (T) BatchDao.save((Batch) sample);
		} else if ((Class<T>) sample.getClass() == BStatusDao.class) {
			return (T) BStatusDao.save( (B_Status) sample);
		} else if ((Class<T>) sample.getClass() == CurriculumDao.class) {
			return (T) CurriculumDao.save((Curriculum) sample);
		} else if ((Class<T>) sample.getClass() == LocationDao.class) {
			return (T) LocationDao.save((Location) sample);
		} else if ((Class<T>) sample.getClass() == RoomDao.class) {
			return (T) RoomDao.save((Room) sample);
		} else if ((Class<T>) sample.getClass() == RStatusDao.class) {
			return (T) RStatusDao.save((R_Status) sample);
		} else if ((Class<T>) sample.getClass() == SkillDao.class) {
			return (T) SkillDao.save((Skill) sample);
		} else if ((Class<T>) sample.getClass() == TopicDao.class) {
			return (T) TopicDao.save((Topic) sample);
		} else if ((Class<T>) sample.getClass() == TrainerDao.class) {
			return (T) TrainerDao.save((Trainer) sample);
		} else if ((Class<T>) sample.getClass() == UnavailableDao.class) {
			return (T) UnavailableDao.save((Unavailable) sample);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public <T> void delete(T sample) {
		if ((Class<T>) sample.getClass() == Batch.class) {
			BatchDao.delete((Batch) sample);
		} else if ((Class<T>) sample.getClass() == BStatusDao.class) {
			BStatusDao.delete( (B_Status) sample);
		} else if ((Class<T>) sample.getClass() == CurriculumDao.class) {
			CurriculumDao.delete((Curriculum) sample);
		} else if ((Class<T>) sample.getClass() == LocationDao.class) {
			LocationDao.delete((Location) sample);
		} else if ((Class<T>) sample.getClass() == RoomDao.class) {
			RoomDao.delete((Room) sample);
		} else if ((Class<T>) sample.getClass() == RStatusDao.class) {
			RStatusDao.delete((R_Status) sample);
		} else if ((Class<T>) sample.getClass() == SkillDao.class) {
			SkillDao.delete((Skill) sample);
		} else if ((Class<T>) sample.getClass() == TopicDao.class) {
			TopicDao.delete((Topic) sample);
		} else if ((Class<T>) sample.getClass() == TrainerDao.class) {
			TrainerDao.delete((Trainer) sample);
		} else if ((Class<T>) sample.getClass() == UnavailableDao.class) {
			UnavailableDao.delete((Unavailable) sample);
		}
	
	}
	
	
	
	
	
	
	
	
}
