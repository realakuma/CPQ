package com.maucc.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInfo {

	private String CustAddress;
	private String CustID;
	private String CustName;
	private String FloorArea;
	private String UsableArea;
	private String sessionID;

	@JsonProperty(value = "CustAddress")
	public void setCustAddress(String CustAddress) {
		this.CustAddress = CustAddress;
	}

	public String getCustAddress() {
		return this.CustAddress;
	}

	@JsonProperty(value = "CustID")
	public void setCustID(String CustID) {
		this.CustID = CustID;
	}

	public String getCustID() {
		return this.CustID;
	}

	@JsonProperty(value = "CustName")
	public void setCustName(String CustName) {
		this.CustName = CustName;
	}

	public String getCustName() {
		return this.CustName;
	}

	@JsonProperty(value = "FloorArea")
	public void setFloorArea(String FloorArea) {
		this.FloorArea = FloorArea;
	}

	public String getFloorArea() {
		return this.FloorArea;
	}

	@JsonProperty(value = "sessionID")
	public void setsessionID(String sessionID) {
		this.sessionID = sessionID;
	}

	public String getSessionID() {
		return this.sessionID;
	}

	@JsonProperty(value = "UsableArea")
	public void setUsableArea(String UsableArea) {
		this.UsableArea = UsableArea;
	}

	public String getUsableArea() {
		return this.UsableArea;
	}

}
