package com.ateam.driver;

import com.ateam.domain.Trainer;
import com.ateam.rest.RestServiceImpl;
import com.ateam.service.InitServiceImpl;


public class Driver {

	public static void main(String[] args) {
		// TODO Test stuff

		//TODO test InitService and RestService
		InitServiceImpl isi = new InitServiceImpl();
		RestServiceImpl rsi = new RestServiceImpl();
		
		rsi.getItemFromRest(new Trainer());
//		isi.initSetup();// tests the init setup pieces
		
	}

}
