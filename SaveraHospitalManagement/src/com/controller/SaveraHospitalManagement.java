package com.controller;

import java.util.Scanner;
import com.daoimpl.*;

public class SaveraHospitalManagement {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		while(true){
			System.out.println("*********************************************");
			System.out.println("|     Savera Hospital Management System     |");
			System.out.println("*********************************************");
			System.out.println("|         1.Front Office Department         |");
			System.out.println("|         2.Administrative Department       |");
			System.out.println("|         3.Doctor Department               |");
			System.out.println("|         4.Exit                            |");
			System.out.println("*********************************************");
			System.out.println("Enter your choice ");
			int choice=sc.nextInt();
			if(choice==3)
			{
				System.out.println("Enter user name");
				String userName=sc.next();
				System.out.println("Enter password");
				String password=sc.next();
				
				if(userName.equals("SVRDR0001") && password.equals("Dr1@") )
				{
					System.out.println("Welcome to doctor fields");
					SaveraDaoimpl sdiD=new SaveraDaoimpl();

					sdiD.doctor();
				}
				else 
				{
					System.out.println("UserName and PassWord are not matches!....");
				}
				
			}
			else if(choice==2)
			{
				System.out.println("Enter user name");
				String userName=sc.next();
				System.out.println("Enter password");
				String password=sc.next();
				
				if(userName.equals("SVRAD0001") && password.equals("Ad1@") )
				{
					System.out.println("welcome to Admin work");
					System.out.println("1.Front Office");
					System.out.println("2.Doctor");
					System.out.println("3.Admin");
					System.out.println("4.Reports");
					System.out.println("Enter your choice");
					int ch=sc.nextInt();
					
					switch (ch) {
					case 1:
						
						SaveraDaoimpl sdi=new SaveraDaoimpl();
						sdi.frontOffice();
						
						
						
						break;
					case 2:
						SaveraDaoimpl sdiD=new SaveraDaoimpl();

						sdiD.doctor();
						
						
						break;
					case 3:
						
						SaveraDaoimpl sdiA=new SaveraDaoimpl();
						sdiA.admin();
					case 4:
						SaveraDaoimpl sdiR=new SaveraDaoimpl();
						sdiR.reports();
						
						

					default:
						break;
					}
					
				}
				else 
				{
					System.out.println("UserName and PassWord are not matches!....");
				}

			}
			else if(choice==1)
			{
				
				System.out.println("Enter user name");
				String userName=sc.next();
				System.out.println("Enter password");
				String password=sc.next();
		
		if(userName.equals("SVRFT0001") && password.equals("FT1@") )
		{
			System.out.println("******************************");
			System.out.println("Welcome to Front office Module");
			System.out.println("******************************");
			SaveraDaoimpl sdi=new SaveraDaoimpl();
			sdi.frontOffice();
		}
		else 
		{
			System.out.println("UserName and PassWord are not matches!....");
		}
		}
			else
			{
				System.out.println("***************************");
				System.out.println("Thank You For Using Savera\n Hospital Management System");
				System.out.println("***************************");
				System.exit(0);
			}
			}
	}
}



