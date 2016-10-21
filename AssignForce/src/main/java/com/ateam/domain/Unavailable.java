package com.ateam.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "UNAVAILABLE")
public class Unavailable {

	

	@Id
	@Column(name = "UN_ID")
	@SequenceGenerator(allocationSize = 1, name = "unavailableSeq", sequenceName = "UNAVAILABLE_SEQ")
	@GeneratedValue(generator = "unavailableSeq", strategy = GenerationType.SEQUENCE)
	private int unavailableID;

	

	@Column(name = "UN_START_DATE", nullable=false)
	private Timestamp unavailableStartDate;



	@Column(name = "UN_END_DATE", nullable=false)
	private Timestamp unavailableEndDate;

	public Unavailable() {

		super();

	}



	public Unavailable(int unavailableID, Timestamp unavailableStartDate, Timestamp unavailableEndDate) {

		super();

		this.unavailableID = unavailableID;

		this.unavailableStartDate = unavailableStartDate;

		this.unavailableEndDate = unavailableEndDate;

	}



	public Unavailable(Timestamp unavailableStartDate, Timestamp unavailableEndDate) {

		super();

		this.unavailableStartDate = unavailableStartDate;

		this.unavailableEndDate = unavailableEndDate;

	}



	public Unavailable(int unavailableID, Timestamp unavailableStartDate, Timestamp unavailableEndDate,


			List<Room> room) {


		super();

		this.unavailableID = unavailableID;

		this.unavailableStartDate = unavailableStartDate;

		this.unavailableEndDate = unavailableEndDate;

	}



	public int getUnavailableID() {

		return unavailableID;

	}



	public void setUnavailableID(int unavailableID) {

		this.unavailableID = unavailableID;

	}



	public Timestamp getUnavailableStartDate() {

		return unavailableStartDate;

	}



	public void setUnavailableStartDate(Timestamp unavailableStartDate) {

		this.unavailableStartDate = unavailableStartDate;

	}



	public Timestamp getUnavailableEndDate() {

		return unavailableEndDate;

	}



	public void setUnavailableEndDate(Timestamp unavailableEndDate) {

		this.unavailableEndDate = unavailableEndDate;


	}

	@Override
	public String toString() {
		return "Unavailable [unavailableID=" + unavailableID + ", unavailableStartDate=" + unavailableStartDate
				+ ", unavailableEndDate=" + unavailableEndDate + "]";
	}
}
