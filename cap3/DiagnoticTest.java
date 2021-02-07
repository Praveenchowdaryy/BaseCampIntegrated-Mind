package com.mind.cap3;

public class DiagnoticTest {
	private int testPatientId;
	private int testId;
	private String testName;
	private int bill=500;

	public int getBill() {
		return bill;
	}

	public DiagnoticTest(int testPatientId, int testId, String testName) {
		this.testPatientId=testPatientId;
		this.testId=testId;
		this.testName=testName;
	}

	public int getTestPatientId() {
		return testPatientId;
	}

	public void setTestPatientId(int testPatientId) {
		this.testPatientId = testPatientId;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

}
