package com.mind.Integrated5;

public class TravelerAgent {
	private int travelerId;
	private String travelerName;
	private String travelerGender;
	private String travelerSource;
	private String travelerDestination;
	private int travelerAge;
	private boolean istwoWayBooking;
	private String Airlines;
	private String depatureDate;
	private String depatureTime;
	private int preferedDestination=0;

	public int getPreferedDestination() {
		return preferedDestination;
	}

	public void setPreferedDestination(int preferedDestination) {
		this.preferedDestination = preferedDestination;
	}

	public String getAirlines() {
		return Airlines;
	}

	public void setAirlines(String airlines) {
		Airlines = airlines;
	}

	public String getDepatureDate() {
		return depatureDate;
	}

	public void setDepatureDate(String depatureDate) {
		this.depatureDate = depatureDate;
	}

	public String getDepatureTime() {
		return depatureTime;
	}

	public void setDepatureTime(String depatureTime) {
		this.depatureTime = depatureTime;
	}

	public boolean isIstwoWayBooking() {
		return istwoWayBooking;
	}

	public void setIstwoWayBooking(boolean istwoWayBooking) {
		this.istwoWayBooking = istwoWayBooking;
	}

	public TravelerAgent() {

	}

	public TravelerAgent(int travelerId, String travelerName, String gender, int age) {
		this.travelerId = travelerId;
		this.travelerName = travelerName;
		this.travelerGender = gender;
		this.travelerAge = age;
	}

	public int getTravelerAge() {
		return travelerAge;
	}

	public void setTravelerAge(int travelerAge) {
		this.travelerAge = travelerAge;
	}

	public int getTravelerId() {
		return travelerId;
	}

	public void setTravelerId(int travelerId) {
		this.travelerId = travelerId;
	}

	public String getTravelerName() {
		return travelerName;
	}

	public void setTravelerName(String travelerName) {
		this.travelerName = travelerName;
	}

	public String getTravelerGender() {
		return travelerGender;
	}

	public void setTravelerGender(String travelerGender) {
		this.travelerGender = travelerGender;
	}

	public String getTravelerSource() {
		return travelerSource;
	}

	public void setTravelerSource(String travelerSource) {
		this.travelerSource = travelerSource;
	}

	public String getTravelerDestination() {
		return travelerDestination;
	}

	public void setTravelerDestination(String travelerDestination) {
		this.travelerDestination = travelerDestination;
	}

}

