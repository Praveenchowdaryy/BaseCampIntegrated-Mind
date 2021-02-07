package com.mind.Integrated6;

public class TaxiDriver {
	private String taxiNumber;
	private String driverName;
	private int driverId;
	private double distance;
	private boolean isTaxiAvailable;

	public boolean isTaxiAvailable() {
		return isTaxiAvailable;
	}

	public void setTaxiAvailable(boolean isTaxiAvailable) {
		this.isTaxiAvailable = isTaxiAvailable;
	}

	public String getTaxiNumber() {
		return taxiNumber;
	}

	public void setTaxiNumber(String taxiNumber) {
		this.taxiNumber = taxiNumber;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
}
