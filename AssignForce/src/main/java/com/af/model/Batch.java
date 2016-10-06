package com.af.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "BATCH")
public class Batch {

	@Id
	@Column(name = "B_ID")
	@SequenceGenerator(allocationSize = 1, name = "batchSeq", sequenceName = "BATCH_SEQ")
	@GeneratedValue(generator = "batchSeq", strategy = GenerationType.SEQUENCE)
	private int batchID;

	@Column(name = "B_START_DATE", nullable=false)
	private Timestamp batchStartDate;

	@Column(name = "B_END_DATE", nullable=false)
	private Timestamp batchEndDate;

	//@ManyToOne(fetch=FetchType.LAZY)
	//@ManyToOne(fetch=FetchType.EAGER)
	@ManyToOne
	@JoinColumn(name = "TOP_ID")
	@Fetch(FetchMode.JOIN)
	private int batchTopicID;

	//@ManyToOne(fetch=FetchType.LAZY)
	//@ManyToOne(fetch=FetchType.EAGER)
	@ManyToOne
	@JoinColumn(name = "CUR_ID")
	@Fetch(FetchMode.JOIN)
	private int batchCurriculumID;
	
	//@OneToOne(fetch=FetchType.LAZY)
	//@OneToOne(fetch=FetchType.EAGER)
	@OneToOne
	@JoinColumn(name = "R_ID")
	@Fetch(FetchMode.JOIN)
	private int batchRoomID;
	
	//@ManyToOne(fetch=FetchType.LAZY)
	//@ManyToOne(fetch=FetchType.EAGER)
	@ManyToOne
	@JoinColumn(name = "BS_ID")
	@Fetch(FetchMode.JOIN)
	private int batchStatusID;
	
	//@ManyToOne(fetch=FetchType.LAZY)
	//@ManyToOne(fetch=FetchType.EAGER)
	@OneToOne
	@JoinColumn(name = "T_ID")
	@Fetch(FetchMode.JOIN)
	private int batchTrainerID;

	public Batch() {
		super();
	}

	public Batch(int batchID, Timestamp batchStartDate, Timestamp batchEndDate, int batchTopicID, int batchCurriculumID,
			int batchRoomID, int batchStatusID, int batchTrainerID) {
		super();
		this.batchID = batchID;
		this.batchStartDate = batchStartDate;
		this.batchEndDate = batchEndDate;
		this.batchTopicID = batchTopicID;
		this.batchCurriculumID = batchCurriculumID;
		this.batchRoomID = batchRoomID;
		this.batchStatusID = batchStatusID;
		this.batchTrainerID = batchTrainerID;
	}

	public int getBatchID() {
		return batchID;
	}

	public void setBatchID(int batchID) {
		this.batchID = batchID;
	}

	public Timestamp getBatchStartDate() {
		return batchStartDate;
	}

	public void setBatchStartDate(Timestamp batchStartDate) {
		this.batchStartDate = batchStartDate;
	}

	public Timestamp getBatchEndDate() {
		return batchEndDate;
	}

	public void setBatchEndDate(Timestamp batchEndDate) {
		this.batchEndDate = batchEndDate;
	}

	public int getBatchTopicID() {
		return batchTopicID;
	}

	public void setBatchTopicID(int batchTopicID) {
		this.batchTopicID = batchTopicID;
	}

	public int getBatchCurriculumID() {
		return batchCurriculumID;
	}

	public void setBatchCurriculumID(int batchCurriculumID) {
		this.batchCurriculumID = batchCurriculumID;
	}

	public int getBatchRoomID() {
		return batchRoomID;
	}

	public void setBatchRoomID(int batchRoomID) {
		this.batchRoomID = batchRoomID;
	}

	public int getBatchStatusID() {
		return batchStatusID;
	}

	public void setBatchStatusID(int batchStatusID) {
		this.batchStatusID = batchStatusID;
	}

	public int getBatchTrainerID() {
		return batchTrainerID;
	}

	public void setBatchTrainerID(int batchTrainerID) {
		this.batchTrainerID = batchTrainerID;
	}

	@Override
	public String toString() {
		return "Batch [batchID=" + batchID + ", batchStartDate=" + batchStartDate + ", batchEndDate=" + batchEndDate
				+ ", batchTopicID=" + batchTopicID + ", batchCurriculumID=" + batchCurriculumID + ", batchRoomID="
				+ batchRoomID + ", batchStatusID=" + batchStatusID + ", batchTrainerID=" + batchTrainerID + "]";
	}

}
