package com.wip.ims.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wip.ims.dao.DaoIms;
import com.wip.ims.model.Product;

@Component
public class SubmitPoService {

	public List<Product> getProducts()
	{
//		DaoIms dao = new DaoIms();
//		List<Product> products = dao.retrieveAllItem(new Product());	//THE REAL LINE, DOESNT WORK WITH HIB SPRING YET
		List<Product> products = testProductList();	//TESTING ONLY
		return products;
	}
	
	private List<Product> testProductList()
	{
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1, "gears", 10.00));
		products.add(new Product(2, "pipes", 20.00));
		
		
		return products;
	}
	
	//TODO
	// this is a function from Zach's project 1, it's been "updated" but could need some more tweaking
	private void writeJSON(List<Product> products, HttpServletResponse response) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String rlistJSON = mapper.writeValueAsString(products);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.write(rlistJSON);
	}

}
