package com.mind.Integrated16;

public class Hotel {
	private String name;
	private String mobileNumber;
	private String membershipType;
	private int fromDate;
	private int toDate;
	private double totalBill;

	public Hotel(String name, String mobileNumber, String membership, int fromDate2, int toDate2) {
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.membershipType = membership;
		this.fromDate = fromDate2;
		this.toDate = toDate2;
	}

	public double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String membershipType) {
		this.membershipType = membershipType;
	}

	public int getFromDate() {
		return fromDate;
	}

	public void setFromDate(int fromDate) {
		this.fromDate = fromDate;
	}

	public int getTodate() {
		return toDate;
	}

	public void setTodate(int todate) {
		toDate = todate;
	}

}
