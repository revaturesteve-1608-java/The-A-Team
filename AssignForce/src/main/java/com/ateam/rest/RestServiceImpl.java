package com.ateam.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ateam.domain.Location;
import com.ateam.domain.Room;
import com.ateam.domain.Skill;
import com.ateam.domain.Trainer;
import com.ateam.domain.Unavailable;

@Service
public class RestServiceImpl implements RestService{

	private static final String BASE_URL  = "";
	
	@SuppressWarnings("unchecked")
	public  <T> List<T> getItemFromRest(T type){
		RestTemplate restTemplate = new RestTemplate();
		URI url = null;
		
		//append different end to url based on input type
		String tail = checkType(type);
		
		try {
			url = new URI(BASE_URL + tail);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		ResponseEntity<List<T>> rateResponse = 
				restTemplate.exchange(url, HttpMethod.GET, null,
						new ParameterizedTypeReference<List<T>>() {
		            });
		
		
		//puts the response in a list
		List<T> respList = rateResponse.getBody();

		// not sure this is correct?
//		type = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", (T) type.getClass());
//		type = restTemplate.getForObject(url, (Class<T>) type.getClass());

		return respList;
	}
	
	@SuppressWarnings("unchecked")
	private static <T> String checkType(T type){
		//TODO 
		// need proper URLs for the test data
		if((Class<T>) type.getClass() == Trainer.class){
			return BASE_URL + "/trainer";
		}
		else if((Class<T>) type.getClass() == Unavailable.class){
			return BASE_URL + "/unavailable";
		}
		else if((Class<T>) type.getClass() == Skill.class){
			return BASE_URL + "/skill";
		}
		else if((Class<T>) type.getClass() == Room.class){
			return BASE_URL + "/room";
		}
		else if((Class<T>) type.getClass() == Location.class){
			return BASE_URL + "/location";
		}
		
		
		return BASE_URL;
	}
	
	
}
