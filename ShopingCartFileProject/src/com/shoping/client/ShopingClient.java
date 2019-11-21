package com.shoping.client;

import java.util.Scanner;

import com.details.ReportDetails;
import com.details.ShopingDetails;
import com.details.UserDetails1;
import com.register.RegistrationImpl;

public class ShopingClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		ShopingDetails details=new ShopingDetails();
		UserDetails1 userdetails=new UserDetails1();
		ReportDetails reportDetails=new ReportDetails();
		RegistrationImpl register=new RegistrationImpl();
		while(true)
		{
System.out.println("1)Admin");
System.out.println("2)Customer");

System.out.println("3)Reports");
System.out.println("4)CustomerRegistration");

System.out.println("5)Exit");
System.out.println("Enter choice");
	int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
		details.addAdminMenu();
		break;
		case 2:
			userdetails.addUserMenu();
			break;
		case 3:
			reportDetails.reportMenu();
			break;
		case 4:
			register.register();
			break;
		case 5:
			System.out.println("Thx for using application");
			System.exit(0);
			break;
		default:
			System.out.println("Choose 1 to 3 beween");
		}
		
		
		}
	}
}
