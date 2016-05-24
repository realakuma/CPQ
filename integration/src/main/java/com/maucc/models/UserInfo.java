package com.maucc.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInfo {

	private String CustAddress;
	private String CustID;
	private String CustName;
	private String Floor;
	private String Basement;
	private String Garage;
	private String Bedroom;
	private String Livingroom;
	private String Bathroom;
	private String Study;


	private String kitchen;
	
	
	private String FloorArea;
	private String UsableArea;
	private String sessionID;
	
	@JsonProperty(value = "Kitchen")
	public String getKitchen() {
		return kitchen;
	}

	public void setKitchen(String kitchen) {
		this.kitchen = kitchen;
	}

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
	@JsonProperty(value = "Floor")
	public String getFloor() {
		return Floor;
	}

	public void setFloor(String floor) {
		Floor = floor;
	}

	@JsonProperty(value = "Basement")
	public String getBasement() {
		return Basement;
	}

	public void setBasement(String basement) {
		Basement = basement;
	}
	@JsonProperty(value = "Garage")
	public String getGarage() {
		return Garage;
	}

	public void setGarage(String garage) {
		Garage = garage;
	}
	@JsonProperty(value = "Bedroom")
	public String getBedroom() {
		return Bedroom;
	}

	public void setBedroom(String bedroom) {
		Bedroom = bedroom;
	}
	@JsonProperty(value = "Livingroom")
	public String getLivingroom() {
		return Livingroom;
	}

	public void setLivingroom(String livingroom) {
		Livingroom = livingroom;
	}
	@JsonProperty(value = "Bathroom")
	public String getBathroom() {
		return Bathroom;
	}

	public void setBathroom(String Bathroom) {
		this.Bathroom = Bathroom;
	}
	@JsonProperty(value = "Study")
	public String getStudy() {
		return Study;
	}

	public void setStudy(String study) {
		Study = study;
	}

}
