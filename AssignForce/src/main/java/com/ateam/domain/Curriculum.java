package com.ateam.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CURRICULUM")
public class Curriculum {

	@Id
	@Column(name = "CUR_ID")
	@SequenceGenerator(allocationSize = 1, name = "curriculumSeq", sequenceName = "CURRICULUM_SEQ")
	@GeneratedValue(generator = "curriculumSeq", strategy = GenerationType.SEQUENCE)
	private int curriculumID;
	
	@Column(name = "CUR_NAME", unique=true)
	private String curriculumName;
	
	@ManyToMany(mappedBy="curriculum", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Skill> skill;

	public Curriculum() {
		super();
		this.skill = new ArrayList<Skill>();
	}

	public Curriculum(int curriculumID, String curriculumName) {
		super();
		this.curriculumID = curriculumID;
		this.curriculumName = curriculumName;
	}

	public Curriculum(int curriculumID, String curriculumName, List<Skill> skill) {
		super();
		this.curriculumID = curriculumID;
		this.curriculumName = curriculumName;
		this.skill = skill;
	}

	public int getCurriculumID() {
		return curriculumID;
	}

	public void setCurriculumID(int curriculumID) {
		this.curriculumID = curriculumID;
	}

	public String getCurriculumName() {
		return curriculumName;
	}

	public void setCurriculumName(String curriculumName) {
		this.curriculumName = curriculumName;
	}

	public List<Skill> getSkill() {
		return skill;
	}

	public void setSkill(List<Skill> skill) {
		this.skill = skill;
	}

	@Override
	public String toString() {
		return "Curriculum [curriculumID=" + curriculumID + ", curriculumName=" + curriculumName + ", skill=" + skill
				+ "]";
	}
	
}
