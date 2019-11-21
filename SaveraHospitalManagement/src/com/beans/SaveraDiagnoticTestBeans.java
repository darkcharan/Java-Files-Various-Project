package com.beans;

import java.io.Serializable;

public class SaveraDiagnoticTestBeans implements Serializable {

	
	private String DiagnoticTestName;
	private double DiagnoticTestCost;
	private String Specialization;
	public String getDiagnoticTestName() {
		return DiagnoticTestName;
	}
	public void setDiagnoticTestName(String diagnoticTestName) {
		DiagnoticTestName = diagnoticTestName;
	}
	public double getDiagnoticTestCost() {
		return DiagnoticTestCost;
	}
	public void setDiagnoticTestCost(double diagnoticTestCost) {
		DiagnoticTestCost = diagnoticTestCost;
	}
	public String getSpecialization() {
		return Specialization;
	}
	public void setSpecialization(String specialization) {
		Specialization = specialization;
	}
	@Override
	public String toString() {
		return "SaveraDiagnoticTestBeans [DiagnoticTestName="
				+ DiagnoticTestName + ", DiagnoticTestCost="
				+ DiagnoticTestCost + ", Specialization=" + Specialization
				+ "]";
	}
	public void setPatientDetails(String next) {
		// TODO Auto-generated method stub
		
	}
	
}
