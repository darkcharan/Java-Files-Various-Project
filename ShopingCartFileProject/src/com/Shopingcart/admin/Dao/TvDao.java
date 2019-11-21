package com.Shopingcart.admin.Dao;

import java.util.List;

import com.Shopingcart.admin.bean.Tv;

public interface TvDao {
	
	void addTvDetails();
	List<Tv> viewTvDetails();
	Tv viewSpecificTvDetails();
	void updateTvDetails();
	void DeleteTvDetails();

}
