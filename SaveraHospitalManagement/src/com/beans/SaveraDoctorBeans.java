package com.beans;

import java.io.Serializable;

public class SaveraDoctorBeans implements Serializable {
	
	
	private String doctorId;
	private long registrationNumber;
	private String doctorName;
	private String specializationName;
	private String certificationDate;
	private int age;
	private String Gender;
	private long mobileNumber;
	private String Address;
	private String emailId;
	private String password;
	private String confirmPassWord;
	
	
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public long getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(long registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpecializationName() {
		return specializationName;
	}
	public void setSpecializationName(String specializationName) {
		this.specializationName = specializationName;
	}
	public String getCertificationDate() {
		return certificationDate;
	}
	public void setCertificationDate(String certificationDate) {
		this.certificationDate = certificationDate;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public String setPassword(String password) {
		return this.password = password;
	}
	public String getConfirmPassWord() {
		return confirmPassWord;
	}
	public void setConfirmPassWord(String confirmPassWord) {
		this.confirmPassWord = confirmPassWord;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "SaveraDoctorBeans [doctorId=" + doctorId
				+ ", registrationNumber=" + registrationNumber
				+ ", doctorName=" + doctorName + ", specializationName="
				+ specializationName + ", certificationDate="
				+ certificationDate + ", age=" + age + ", Gender=" + Gender
				+ ", mobileNumber=" + mobileNumber + ", Address=" + Address
				+ ", emailId=" + emailId + ", password=" + password
				+ ", confirmPassWord=" + confirmPassWord + "]";
	}
	
	
	

}
