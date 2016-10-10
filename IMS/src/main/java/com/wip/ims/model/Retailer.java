package com.wip.ims.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="RETAILER")
public class Retailer {
	
	@Id
	@Column(name="R_ID")
	int rId;

	@Column(name="R_NAME")
	String name;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="L_ID")
	Location location;

	public Retailer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retailer(int rId, String name, Location location) {
		super();
		this.rId = rId;
		this.name = name;
		this.location = location;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Retailer [rId=" + rId + ", name=" + name + ", location=" + location + "]";
	}
	
	
	
	
}
