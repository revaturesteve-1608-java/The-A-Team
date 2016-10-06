package com.ateam.service;

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

@Transactional
@Service
public class DaoServiceImpl implements DaoService{
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
	
	
	
	
	
}
