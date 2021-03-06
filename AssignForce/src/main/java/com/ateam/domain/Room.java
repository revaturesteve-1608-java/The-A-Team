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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "ROOM")
public class Room {

	@Id
	@Column(name = "R_ID")
	@SequenceGenerator(allocationSize = 1, name = "roomSeq", sequenceName = "ROOM_SEQ")
	@GeneratedValue(generator = "roomSeq", strategy = GenerationType.SEQUENCE)
	private int roomID;

	@Column(name = "R_NAME", unique = true, nullable = false)
	private String roomName;

	@ManyToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Unavailable> unavailable;

	// @ManyToOne(fetch=FetchType.LAZY)
	// @ManyToOne(fetch=FetchType.EAGER)
	@ManyToOne
	@JoinColumn(name = "RS_ID")
	@Fetch(FetchMode.JOIN)
	private R_Status roomStatusID;

	// @ManyToOne(fetch=FetchType.LAZY)
	// @ManyToOne(fetch=FetchType.EAGER)
	@ManyToOne
	@JoinColumn(name = "L_ID")
	@Fetch(FetchMode.JOIN)
	private Location roomLocationID;

	public Room() {
		super();
		this.unavailable = new ArrayList<Unavailable>();
	}

	public Room(int roomID, String roomName, R_Status roomStatusID, Location roomLocationID) {
		this();
		this.roomID = roomID;
		this.roomName = roomName;
		this.roomStatusID = roomStatusID;
		this.roomLocationID = roomLocationID;
	}

	public Room(String roomName, Location roomLocationID, List<Unavailable> unavailable) {
		super();
		this.roomName = roomName;
		this.roomLocationID = roomLocationID;
		this.unavailable = unavailable;
	}

	public Room(int roomID, String roomName, List<Unavailable> unavailable, R_Status roomStatusID, Location roomLocationID) {
		super();
		this.roomID = roomID;
		this.roomName = roomName;
		this.unavailable = unavailable;
		this.roomStatusID = roomStatusID;
		this.roomLocationID = roomLocationID;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public List<Unavailable> getUnavailable() {
		return unavailable;
	}

	public void setUnavailable(List<Unavailable> unavailable) {
		this.unavailable = unavailable;
	}

	public R_Status getRoomStatusID() {
		return roomStatusID;
	}

	public void setRoomStatusID(R_Status roomStatusID) {
		this.roomStatusID = roomStatusID;
	}

	public Location getLocationID() {
		return roomLocationID;
	}

	public void setLocationID(Location roomLocationID) {
		this.roomLocationID = roomLocationID;
	}

	@Override
	public String toString() {
		return "Room [roomID=" + roomID + ", roomName=" + roomName + ", unavailable=" + unavailable + ", roomStatusID="
				+ roomStatusID + ", locationID=" + roomLocationID + "]";
	}
}
