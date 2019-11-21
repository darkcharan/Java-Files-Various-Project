package com.details;

import java.util.Scanner;

import com.Shopingcart.user.Dao.ReportDaoImpl;
import com.shoping.client.ShopingClient;

public class ReportDetails {
Scanner sc=new Scanner(System.in);
ReportDaoImpl daoImpl=new ReportDaoImpl();
public	void reportMenu()
	{
		System.out.println("1)MobileStock");
		System.out.println("2)ComputerStock");
		System.out.println("3)TVStock");
		System.out.println("4)Back");

		int choice=sc.nextInt();
		switch(choice)
		{
			case 1:
				daoImpl.mobileStock();
				reportMenu();
				break;
			case 2:
				daoImpl.computerStock();
				reportMenu();
				break;
			case 3:
				daoImpl.tvStock();
				reportMenu();
				break;
			case 4:
				ShopingClient.main(null);
				break;
			default:
				System.out.println("choose 1 to 3 be");
		}
	}
}
