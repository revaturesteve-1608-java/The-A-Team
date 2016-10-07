package com.ateam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ateam.service.InitService;
import com.ateam.service.InitServiceImpl;

@Controller
public class LoadCtrl {
	@Autowired
	private InitServiceImpl initService;
	
	@RequestMapping(value="/home")
	public String home(ModelMap modelMap){
		System.out.println("home direction");
		return "NewFile";	// not really sure what to return here
	}
	
	
	@RequestMapping(value="/init", method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public String initSetup(ModelMap modelMap){
		
		initService.initSetup();	// run the setup
		return null;	// not really sure what to return here
	}
	
	
}
