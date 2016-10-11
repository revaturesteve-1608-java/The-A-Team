package com.ateam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ateam.domain.Curriculum;

@Service
public class BatchServiceImpl {

	@Autowired
	DaoService dao;
	
	public List<Curriculum> getCurriculums(){
		return dao.getAllItem(new Curriculum());
	}
}
