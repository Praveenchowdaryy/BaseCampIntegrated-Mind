package com.mind.cap3;

public class Patient {
	private int patientId;
	private String patientName;
	private String patientAddress;
	private String patientPhno;

	public Patient(int patientId, String patientName, String patientAddress, String patientPhno) {
		this.patientId=patientId;
		this.patientName=patientName;
		this.patientAddress=patientAddress;
		this.patientPhno=patientPhno;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public String getPatientPhno() {
		return patientPhno;
	}

	public void setPatientPhno(String patientPhno) {
		this.patientPhno = patientPhno;
	}
	

}
