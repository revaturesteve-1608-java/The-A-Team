package com.wip.ims.driver;

import java.sql.Timestamp;
import java.util.Calendar;

import com.wip.ims.dao.DaoIms;
import com.wip.ims.model.Categories;
import com.wip.ims.model.Inventory;
import com.wip.ims.model.Location;
import com.wip.ims.model.PoLine;
import com.wip.ims.model.Product;
import com.wip.ims.model.PurchaseOrder;
import com.wip.ims.model.Retailer;
import com.wip.ims.model.Sales;
import com.wip.ims.model.Status;
import com.wip.ims.model.Supplier;

public class Driver {

	public static void main(String[] args) {
		DaoIms dao = new DaoIms();
		
		// set to current timestamp
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		Timestamp t = new Timestamp(now.getTime());
		
		Status status = new Status(50, "Pending");	//success
		Location location = new Location(100, "Potlatch");	//success
		Supplier supplier = new Supplier(150, "Walmart", location);	
		Retailer retailer = new Retailer(100, "Joe's Morgue", location);
		Product product = new Product(1, "waffles", 7.00);
		Categories category = new Categories(1,"breakfast");
		Inventory inventory = new Inventory(0, retailer, 2, 9, product);
		Sales sales = new Sales(1, retailer, product, 43, 65.55, t);
		PurchaseOrder po = new PurchaseOrder(1, supplier, retailer, t, status);
		PoLine poline = new PoLine(1, 100, product, 23, 34);
		
		System.out.println(dao.retrieveAllItem(new Supplier()));
//		dao.createItem(location);
		
		// Presentation
		// Retrieve
/*		System.out.println("RETREIVE: ");
		System.out.println(dao.retrieveItemById(50, new Location()));

		//Update
		System.out.println("UPDATE: ");
		location = new Location(50, "Reston");
		dao.updateItem(location);
		System.out.println(dao.retrieveItemById(50, new Location()));
		
		// Retrieve All
		System.out.println("RETRIEVE ALL: ");
		System.out.println(dao.retrieveAllItem(new Supplier()));

		// Create
		System.out.println("CREATE: ");
		dao.createItem(retailer);
		System.out.println(dao.retrieveAllItem(new Retailer()));
		
		// Delete
		System.out.println("DELETE: ");
		dao.deleteItem(retailer);
		System.out.println(dao.retrieveAllItem(new Retailer()));
//	*/	
	}

}
