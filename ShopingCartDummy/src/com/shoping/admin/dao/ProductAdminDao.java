package com.shoping.admin.dao;

import java.util.List;

import com.shoping.admin.bean.Product;

public interface ProductAdminDao {
void addProductDetails();
List<Product> viewProductDetails();
Product viewProduct(int pno);
void updateProducts(int pno);
void deleteProducts(int pno);
}
