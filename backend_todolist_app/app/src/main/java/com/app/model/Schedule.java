package com.app.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Schedule {

	@JsonProperty("Id")
	private float Id;
	@JsonProperty("Subject")
	private String Subject;
	@JsonProperty("StartTime")
	private Date StartTime;
	@JsonProperty("EndTime")
	private Date EndTime;
	@JsonProperty("IsAllDay")
	private boolean IsAllDay;

	public Schedule(float id, String subject, Date startTime, Date endTime, boolean isAllDay) {
		super();
		Id = id;
		Subject = subject;
		StartTime = startTime;
		EndTime = endTime;
		IsAllDay = isAllDay;
	}

	public float getId() {
		return Id;
	}

	public void setId(float id) {
		Id = id;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public Date getStartTime() {
		return StartTime;
	}

	public void setStartTime(Date startTime) {
		StartTime = startTime;
	}

	public Date getEndTime() {
		return EndTime;
	}

	public void setEndTime(Date endTime) {
		EndTime = endTime;
	}

	public boolean isIsAllDay() {
		return IsAllDay;
	}

	public void setIsAllDay(boolean isAllDay) {
		IsAllDay = isAllDay;
	}

	// Getter Methods

}
