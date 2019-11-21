package com.shoping.user.dao;

import java.util.List;

import com.shoping.admin.bean.Product;


public interface ProductUserDao {
List<Product> viewAllProducts();
void selectProductDetails();


}
