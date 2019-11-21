package com.Shopingcart.admin.Dao;

import java.util.List;

import com.Shopingcart.admin.bean.Computer;

public interface ComputerDao {
	 void addComputerDetails();
	 List<Computer>viewComputerDetails();
	 Computer viewSpecificComputerDetails();
	 void updateComputerDetails();
	 void deleteComputerDetails();

}
