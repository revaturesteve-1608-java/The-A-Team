package com.wip.ims.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LOCATIONS")
public class Location {

	@Id
	@Column(name="L_ID")
	@SequenceGenerator(name="LOCATIONS_SEQ", sequenceName="LOCATIONS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="LOCATIONS_SEQ")
	private int lId;
	
	@Column(name="L_NAME")
	String name;

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Location(int lId, String name) {
		super();
		this.lId = lId;
		this.name = name;
	}

	public int getlId() {
		return lId;
	}

	public void setlId(int lId) {
		this.lId = lId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Location [lId=" + lId + ", name=" + name + "]";
	}

	
	
}
