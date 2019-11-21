package com.beans;

public class Appointment {

	
	private String patientId;
	private String specilization;
	private String appointmentDate;
	private String time;
	public Appointment() {
		super();
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getSpecilization() {
		return specilization;
	}
	public void setSpecilization(String specilization) {
		this.specilization = specilization;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Appointment [patientId=" + patientId + ", specilization="
				+ specilization + ", appointmentDate=" + appointmentDate
				+ ", time=" + time + "]";
	}
	
	
	
	
}
