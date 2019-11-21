package com.beans;

import java.io.Serializable;

public class SaveraReportsBeans implements Serializable {
	private String patientID;
	private String patientName;
	private String doctorName;
	private String specialization;
	private String date;
	private String time;
	private String amountFee;
	public String getPatientID() {
		return patientID;
	}
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAmountFee() {
		return amountFee;
	}
	public void setAmountFee(String amountFee) {
		this.amountFee = amountFee;
	}
	@Override
	public String toString() {
		return " [patientID=" + patientID + ", patientName="
				+ patientName + ", doctorName=" + doctorName
				+ ", specialization=" + specialization + ", date=" + date
				+ ", time=" + time + ", amountFee=" + amountFee + "]";
	}
	
	
	

}
