package com.shopping.dummy;

import java.util.Scanner;

import com.shoping.details.ShopingDetails;
import com.shoping.user.dao.ProductUserDaoImpl1234;

public class Shoppingclient {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ShopingDetails details=new ShopingDetails();
		ProductUserDaoImpl1234 userdao=new ProductUserDaoImpl1234();

		while (true) {
			System.out.println("-------------------------------");
			System.out.println("|       PRODUCT BOOKING       |");
			System.out.println("-------------------------------");
			System.out.println("|  1. ADMIN                   |");
			System.out.println("|  2. USER                    |");
			System.out.println("|  3. REPORTS                 |");

			System.out.println("|  4. EXIT                    |");
			System.out.println("--------------------------------");
			System.out.println("Enter Your Choice ?");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				details.adminMenu();
				break;
			case 2:
				details.userMenu();
				break;
			case 3:
				details.reportMenu();
				break;	
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("Please select choice range 1-3 only");
				break;

			}
		}

	}

}
