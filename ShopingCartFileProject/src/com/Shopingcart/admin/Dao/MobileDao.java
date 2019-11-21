package com.Shopingcart.admin.Dao;

import java.util.List;

import com.Shopingcart.admin.bean.Mobile;



public interface MobileDao  {
	
	void addMobileDetails();
	List<Mobile> viewMobileDetails();
	Mobile viewSpecificProduct();
	void updateProductDetails();
	void deleteProductDetails();

}
