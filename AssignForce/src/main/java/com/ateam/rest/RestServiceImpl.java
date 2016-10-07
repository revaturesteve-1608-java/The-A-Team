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

	//put this on a random server application for the time being
	private static final String BASE_URL  = "http://localhost:8080/AssignForce/resources/js/json";
	// Zach's local
//	private static final String BASE_URL  = "C:/Users/Zach/Repositories/The-A-Team/AssignForce/src/main/webapp/resources/js/json";
	
	@SuppressWarnings("unchecked")
	@Override
	public  <T> List<T> getItemFromRest(T type){
		RestTemplate restTemplate = new RestTemplate();
		URI url = null;
		//append different end to url based on input type
		System.out.println("uhhh");
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
			return "/TrainerJSON.json";
		}
		else if((Class<T>) type.getClass() == Unavailable.class){
			return  "/UnavailableJSON.json";
		}
		else if((Class<T>) type.getClass() == Skill.class){
			return  "/SkillJSON.json";
		}
		else if((Class<T>) type.getClass() == Room.class){
			return  "/RoomJSON.json";
		}
		else if((Class<T>) type.getClass() == Location.class){
			return "/LocationJSON.json";
		}
		
		
		return BASE_URL;
	}
	
	
}
