package com.ateam.dao;


import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

//Spring data BaseRepository for other DAOs to extends
@NoRepositoryBean
interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {
	
	public void delete(T deleted);
	 
    public List<T> findAll();
     
    public Optional<T> findOne(ID id);
 
    public T save(T persisted);

}
