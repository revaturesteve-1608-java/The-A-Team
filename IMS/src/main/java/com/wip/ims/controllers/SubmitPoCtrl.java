package com.wip.ims.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wip.ims.model.Product;
import com.wip.ims.service.SubmitPoService;

@Controller
public class SubmitPoCtrl {

	@Autowired
	private SubmitPoService spoService;
	
	//TODO
	@RequestMapping(value="/submitpo" )
	public String defaultPage(ModelMap modelMap)
	{
		// retrieve list of products
System.out.println("Default: ");
		//This function needs to return to AJAX
		return "SubmitPO";
	}
	
	@RequestMapping(value="/getProducts", method=RequestMethod.GET, produces="application/json" )
	@ResponseBody	// this is gonna need looking into need some sort of JSON converter?
	@ResponseStatus(HttpStatus.OK)
	public List<Product> getProducts(ModelMap modelMap)
	{
		// retrieve list of products
		List<Product> products = spoService.getProducts();
System.out.println("Products: ");
System.out.println(products);
		//This function needs to return to AJAX
		return products;
	}
	


	
}
