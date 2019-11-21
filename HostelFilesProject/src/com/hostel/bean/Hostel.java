package com.hostel.bean;

import java.io.Serializable;

public class Hostel implements Serializable {
	private int roomNo;
	private String roomType;
	private String acNonac;
	private int roomFare;
	private String availability;
	
	


	public Hostel()
	{
		
	}
	

	
	public Hostel(int roomNo, String roomType, String acNonac, int roomFare,
			String availability) {
		super();
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.acNonac = acNonac;
		this.roomFare = roomFare;
		this.availability = availability;
	}

	

	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
		public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getAcNonac() {
		return acNonac;
	}
	public void setAcNonac(String acNonac) {
		this.acNonac = acNonac;
	}
	public int getRoomFare() {
		return roomFare;
	}
	public void setRoomFare(int roomFare) {
		this.roomFare = roomFare;
	}
public String toString()
{
	return roomNo+"\t"+roomType+"\t"+acNonac+"\t"+roomFare+"\t"+availability;
}

	

}
