package com.ateam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ateam.domain.Batch;

@Service
public class ViewBatchServiceImpl implements ViewBatchService {

	@Autowired
	DaoServiceImpl dao;
	
	public List<Batch> getBatches() {
		List<Batch> batches = dao.BatchDao.findAll();
		return null;
	}
}
