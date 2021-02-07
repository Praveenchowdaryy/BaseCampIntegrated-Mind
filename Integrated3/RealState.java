package com.mind.Integrated3;

public class RealState {
	private String saleType;
	private String houseSize;
	private String houseType;

	public RealState(String saleType, String houseSize, String houseType) {
	this.saleType=saleType;
	this.houseType=houseType;
	this.houseSize=houseSize;
	}

	public String getSaleType() {
		return saleType;
	}

	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}

	public String getHouseSize() {
		return houseSize;
	}

	public void setHouseSize(String houseSize) {
		this.houseSize = houseSize;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

}

