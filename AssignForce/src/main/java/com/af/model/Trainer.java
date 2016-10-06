package com.af.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "TRAINER")
public class Trainer {

	@Id
	@Column(name = "T_ID")
	@SequenceGenerator(allocationSize = 1, name = "trainerSeq", sequenceName = "TRAINER_SEQ")
	@GeneratedValue(generator = "trainerSeq", strategy = GenerationType.SEQUENCE)
	private int trainerID;

	@Column(name = "T_FIRSTNAME", nullable = false)
	private String trainerFirstName;

	@Column(name = "T_LASTNAME", nullable = false)
	private String trainerLastName;

	// @ManyToOne(fetch=FetchType.LAZY)
	// @ManyToOne(fetch=FetchType.EAGER)
	@ManyToOne
	@JoinColumn(name = "TS_ID")
	@Fetch(FetchMode.JOIN)
	private int trainerStatusID;

	// @OneToOne(fetch=FetchType.LAZY)
	// @OneToOne(fetch=FetchType.EAGER)
	@OneToOne
	@JoinColumn(name = "L_ID")
	@Fetch(FetchMode.JOIN)
	private int trainerLocationID;

	@ManyToMany(mappedBy="trainer", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Unavailable> unavailable;

	@ManyToMany(mappedBy="trainer", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Skill> skill;

	public Trainer() {
		super();
		this.unavailable = new ArrayList<Unavailable>();
		this.skill = new ArrayList<Skill>();
	}

	public Trainer(int trainerID, String trainerFirstName, String trainerLastName, int trainerStatusID,
			int trainerLocationID) {
		super();
		this.trainerID = trainerID;
		this.trainerFirstName = trainerFirstName;
		this.trainerLastName = trainerLastName;
		this.trainerStatusID = trainerStatusID;
		this.trainerLocationID = trainerLocationID;
	}

	public Trainer(int trainerID, String trainerFirstName, String trainerLastName, int trainerStatusID,
			int trainerLocationID, List<Unavailable> unavailable, List<Skill> skill) {
		super();
		this.trainerID = trainerID;
		this.trainerFirstName = trainerFirstName;
		this.trainerLastName = trainerLastName;
		this.trainerStatusID = trainerStatusID;
		this.trainerLocationID = trainerLocationID;
		this.unavailable = unavailable;
		this.skill = skill;
	}

	public int getTrainerID() {
		return trainerID;
	}

	public void setTrainerID(int trainerID) {
		this.trainerID = trainerID;
	}

	public String getTrainerFirstName() {
		return trainerFirstName;
	}

	public void setTrainerFirstName(String trainerFirstName) {
		this.trainerFirstName = trainerFirstName;
	}

	public String getTrainerLastName() {
		return trainerLastName;
	}

	public void setTrainerLastName(String trainerLastName) {
		this.trainerLastName = trainerLastName;
	}

	public int getTrainerStatusID() {
		return trainerStatusID;
	}

	public void setTrainerStatusID(int trainerStatusID) {
		this.trainerStatusID = trainerStatusID;
	}

	public int getTrainerLocationID() {
		return trainerLocationID;
	}

	public void setTrainerLocationID(int trainerLocationID) {
		this.trainerLocationID = trainerLocationID;
	}

	public List<Unavailable> getUnavailable() {
		return unavailable;
	}

	public void setUnavailable(List<Unavailable> unavailable) {
		this.unavailable = unavailable;
	}

	public List<Skill> getSkill() {
		return skill;
	}

	public void setSkill(List<Skill> skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "Trainer [trainerID=" + trainerID + ", trainerFirstName=" + trainerFirstName + ", trainerLastName="
				+ trainerLastName + ", trainerStatusID=" + trainerStatusID + ", trainerLocationID=" + trainerLocationID
				+ ", unavailable=" + unavailable + ", skill=" + skill + "]";
	}
	
}
