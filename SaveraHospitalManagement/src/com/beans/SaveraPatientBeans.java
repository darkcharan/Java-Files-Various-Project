package com.beans;

import java.io.Serializable;
import java.util.Iterator;

public class SaveraPatientBeans implements Serializable {
	
	private String patientId;
	private String patientName;
	private double age;
	private String gender;
	private long mobileNumber;
	private String address;
	private String emailId;
	private String problemDescription;
	private String regFee;
	public String getRegFee() {
		return regFee;
	}
	public void setRegFee(String regFee) {
		this.regFee = regFee;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getProblemDescription() {
		return problemDescription;
	}
	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}
	@Override
	public String toString() {
		return " [patientId=" + patientId + ", patientName="
				+ patientName + ", age=" + age + ", gender=" + gender
				+ ", mobileNumber=" + mobileNumber + ", address=" + address
				+ ", emailId=" + emailId + ", problemDescription="
				+ problemDescription + ", regFee=" + regFee + "]";
	}
	
	
	
	
	
	
	
	
	

}
