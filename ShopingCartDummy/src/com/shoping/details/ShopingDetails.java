package com.shoping.details;

import java.util.List;
import java.util.Scanner;

import com.shoping.admin.bean.Product;
import com.shoping.admin.dao.ProductDaoImpl;
import com.shoping.user.dao.ProductUserDaoImpl1234;
import com.shopping.dummy.Shoppingclient;

public class ShopingDetails {

	Scanner sc = new Scanner(System.in);
	ProductDaoImpl dao = new ProductDaoImpl();
	ProductUserDaoImpl1234 userdao = new ProductUserDaoImpl1234();

	public void adminMenu() {
		while (true) {
			System.out.println("-------------------------|");
			System.out.println("|    CART ADMIN MENU     |");
			System.out.println("-------------------------|");

			System.out.println("|	1)AddProducts		 |");
			System.out.println("|   2)viewProducts		 |");
			System.out.println("|	3)viewProductItem    |");
			System.out.println("|	4)updateProducts     |");
			System.out.println("|	5)delteProducts		 |");
			System.out.println("|	6)Back				 |");
			System.out.println("--------------------------");

			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				dao.addProductDetails();
				break;
			case 2:
				System.out.println("ITEM_ID" + "\t" + "NAME" + "\t" + "PRICE"
						+ "\t" + "QTY");

				List<Product> addRecords = dao.viewProductDetails();
				for (Product product : addRecords) {
					System.out.println(product);
				}
			}
		}
	}// adminMenuclose

	public void userMenu() {
		while (true) {
			System.out.println("-------------------------|");
			System.out.println("|    CART ADMIN MENU     |");
			System.out.println("-------------------------|");
			System.out.println("|	1)ViewProducts		 |");
			System.out.println("|	2)Shoping            |");
			System.out.println("|	3)Back				 |");
			System.out.println("-------------------------|");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("ITEM_ID" + "\t" + "NAME" + "\t" + "PRICE"
						+ "\t" + "QTY");

				List<Product> viewRecords = userdao.viewAllProducts();
				for (Product product : viewRecords) {
					System.out.println(product);
				}
				break;
			case 2:
				userdao.selectProductDetails();
				break;
			case 3:
				Shoppingclient.main(null);

			default:
				System.out.println("choose 1 to 3 between");
			}

		}
	}
		
		public void reportMenu()
		{
			while (true) {
				System.out.println("-------------------------|");
				System.out.println("|    REPORTS     |");
				System.out.println("-------------------------|");
				System.out.println("|	1)Stock		 		 |");
				System.out.println("|	2)Transactions       |     |");
				System.out.println("|	3)Back				 |");
				System.out.println("-------------------------|");
				int choice = sc.nextInt();
				System.out.println("Enter Choice");
				switch (choice) {
				case 1:
					
					userdao.totalStock();
					break;
				case 2:
					userdao.trasactionReports();
					break;
				case 3:
					Shoppingclient.main(null);

				default:
					System.out.println("choose 1 to 3 between");
				}			
		}
	
}
}