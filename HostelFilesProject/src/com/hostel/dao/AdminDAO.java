package com.hostel.dao;

import java.util.List;

import com.hostel.bean.Hostel;

public interface AdminDAO {
	public void addRooms();
	public Hostel viewRoom(int roomNo);
	public List<Hostel> viewAllrooms();
	public void updateFare(int roomNo);
	public void deleteRoom(int roomNo);

	

}
