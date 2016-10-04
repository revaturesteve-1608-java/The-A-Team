package com.wip.ims.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="INVENTORY")
public class Inventory {
	
	@Id
	@Column(name="IN_ID")
	@SequenceGenerator(name="INVENTORY_SEQ", sequenceName="INVENTORY_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INVENTORY_SEQ")
	private int inId;
	
	//rId
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="R_ID")
	private Retailer retailer;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="P_ID")
	private Product product;
	
	@Column(name="IN_QNTY")
	private int inQty;
	
	@Column(name="THRESHOLD")
	private int threshold;

	public Inventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Inventory(int inId, Retailer retailer, int inQty, int threshold, Product product) {
		super();
		this.inId = inId;
		this.retailer = retailer;
		this.inQty = inQty;
		this.threshold = threshold;
		this.product = product;
	}

	public int getInId() {
		return inId;
	}

	public void setInId(int inId) {
		this.inId = inId;
	}

	public Retailer getRetailer() {
		return retailer;
	}

	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}

	public int getInQty() {
		return inQty;
	}

	public void setInQty(int inQty) {
		this.inQty = inQty;
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Inventory [inId=" + inId + ", retailer=" + retailer + ", inQty=" + inQty + ", threshold=" + threshold
				+ ", product=" + product + "]";
	}

	
	

}
