package com.ateam.service;

<<<<<<< HEAD
import java.util.List;
import java.util.Optional;
import java.io.Serializable;

=======
>>>>>>> 26f99757ec57e7c8fa789554691ce1f0f64fe241
public interface DaoService {

	public <T> void delete(T sample);
	
	//TODO?
	public <T> List<T> getAllItem(T Sample);
	
	//TODO?
//	public <T> Optional<T> findOne(ID id);
	
	public <T> T save(T persisted);
	
}
