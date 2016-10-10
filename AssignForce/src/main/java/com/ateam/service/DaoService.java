package com.ateam.service;

import java.util.List;
import java.util.Optional;
import java.io.Serializable;

public interface DaoService{

	public <T> void delete(T sample);
	
	//TODO?
	public <T> List<T> getAllItem(T Sample);
	
	//TODO?
//	public <T> Optional<T> findOne(ID id);
	
	public <T> T saveItem(T persisted);
	
}
