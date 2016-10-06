package com.ateam.rest;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.springframework.web.client.RestTemplate;

public class RestService {

	private static final String BASE_URL  = "";
	
	@SuppressWarnings("unchecked")
	public static <T> T getItemFromRest(T type){
		RestTemplate restTemplate = new RestTemplate();
		URI url = null;
		
		//append different end to url based on input type
		String tail = checkType(type);
		
		try {
			url = new URI(BASE_URL + tail);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		type = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", (T) type.getClass());
		restTemplate.getForObject(url, (Class<T>) type.getClass());

		return type;
	}
	
	@SuppressWarnings("unchecked")
	private static <T> String checkType(T type){
		//TODO 
		// need pojos finished in order to fix this
		if((Class<T>) type.getClass() == String.class){
			return BASE_URL + "/trainer";
		}
		else if((Class<T>) type.getClass() == String.class){
			return BASE_URL + "/room";
		}
		
		
		return BASE_URL;
	}
	
	
}
