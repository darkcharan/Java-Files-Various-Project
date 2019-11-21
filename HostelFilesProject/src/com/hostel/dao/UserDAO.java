package com.hostel.dao;

import java.util.List;

import com.hostel.bean.Hostel;

public interface UserDAO {
	public Hostel viewRoom(int roomNo);
	public List<Hostel> viewAllrooms();
	public void bookRoom(int roomNo);
	

}
