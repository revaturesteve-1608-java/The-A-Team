package com.revature.dto;

public class BatchDTO {

	private String batchName;
	private String topic;
	private String curr;
	private String trainerName;
	private String roomName;
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getCurr() {
		return curr;
	}
	public void setCurr(String curr) {
		this.curr = curr;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	@Override
	public String toString() {
		return "BatchDTO [batchName=" + batchName + ", topic=" + topic + ", curr=" + curr + ", trainerName="
				+ trainerName + ", roomName=" + roomName + "]";
	}
	
	
	
	
}
