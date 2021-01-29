package com.app.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ScheduleAPI {
	ArrayList<Schedule> changed = new ArrayList<Schedule>();
	ArrayList<Schedule> added = new ArrayList<Schedule>();
	ArrayList<Schedule> deleted = new ArrayList<Schedule>();
	private String action = "";
	@JsonProperty("ParamsObject")
	Params ParamsObject;
	@JsonProperty("StartDate")
	private String StartDate;
	@JsonProperty("EndDate")
	private String EndDate;

	// Getter Methods

	public String getAction() {
		return action;
	}

	public ArrayList<Schedule> getChanged() {
		return changed;
	}

	public ArrayList<Schedule> getAdded() {
		return added;
	}

	public ArrayList<Schedule> getDeleted() {
		return deleted;
	}

	public Params getParamsObject() {
		return ParamsObject;
	}

	public Params getParams() {
		return ParamsObject;
	}

	public String getStartDate() {
		return StartDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	// Setter Methods

	public void setAction(String action) {
		this.action = action;
	}

	public void setParams(Params paramsObject) {
		this.ParamsObject = paramsObject;
	}

	public void setStartDate(String StartDate) {
		this.StartDate = StartDate;
	}

	public void setEndDate(String EndDate) {
		this.EndDate = EndDate;
	}
}

class Params {
	@JsonProperty("StartDate")
private String StartDate;
	@JsonProperty("EndDate")
private String EndDate;

	// Getter Methods

	public String getStartDate() {
		return StartDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	// Setter Methods

	public void setStartDate(String StartDate) {
		this.StartDate = StartDate;
	}

	public void setEndDate(String EndDate) {
		this.EndDate = EndDate;
	}
}