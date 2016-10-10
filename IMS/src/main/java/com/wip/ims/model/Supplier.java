package com.wip.ims.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SUPPLIER")
public class Supplier {

	@Id
	@Column(name="S_ID")
	@SequenceGenerator(name="SUPPLIER_SEQ", sequenceName="SUPPLIER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SUPPLIER_SEQ")
	private int sId;
	
	@Column(name="S_NAME")
	private String sName;
	
	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="L_ID")
//	private int lId;
	private Location location;

	public Supplier() {
		super();
	}

	public Supplier(int sId, String sName, Location location) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.location = location;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Supplier [sId=" + sId + ", sName=" + sName + ", location=" + location + "]";
	}

	
}
