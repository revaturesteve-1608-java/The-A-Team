package com.wip.ims.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="STATUS")
public class Status {

	@Id
	@Column(name="ST_ID")
	@SequenceGenerator(name="STATUS_SEQ", sequenceName="STATUS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="STATUS_SEQ")
	int stId;
	
	@Column(name="ST_NAME")
	String stName;
	
	public Status() {
		super();
	}

	public Status(int stId, String stName) {
		super();
		this.stId = stId;
		this.stName = stName;
	}

	public int getStId() {
		return stId;
	}

	public void setStId(int stId) {
		this.stId = stId;
	}

	public String getStName() {
		return stName;
	}

	public void setStName(String stName) {
		this.stName = stName;
	}

	@Override
	public String toString() {
		return "Status [stId=" + stId + ", stName=" + stName + "]";
	}

	
}
