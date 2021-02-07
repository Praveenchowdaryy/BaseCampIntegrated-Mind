package com.mind.Integrated1;

public class Parking {

	private boolean isParkingAvailable;
	private String vehicalNumber;
	private String entryTime;
	private String exitTime;

	public boolean isParkingAvailable() {
		return isParkingAvailable;
	}

	public void setParkingAvailable(boolean isParkingAvailable) {
		this.isParkingAvailable = isParkingAvailable;
	}

	public String getVehicalNumber() {
		return vehicalNumber;
	}

	public void setVehicalNumber(String vehicalNumber) {
		this.vehicalNumber = vehicalNumber;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getExitTime() {
		return exitTime;
	}

	public void setExitTime(String exitTime) {
		this.exitTime = exitTime;
	}

}

