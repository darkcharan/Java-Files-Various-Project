package com.details;

import java.util.List;
import java.util.Scanner;

import com.Shopingcart.admin.Dao.ComputerDaoImpl;
import com.Shopingcart.admin.Dao.MobileDaoImpl;
import com.Shopingcart.admin.Dao.TvDaoImpl;
import com.Shopingcart.admin.bean.Computer;
import com.Shopingcart.admin.bean.Mobile;
import com.Shopingcart.admin.bean.Tv;
import com.shoping.client.ShopingClient;

public class ShopingDetails {
Scanner sc=new Scanner(System.in);
MobileDaoImpl mobileDao=new MobileDaoImpl();
ComputerDaoImpl ComputerDao=new ComputerDaoImpl();
TvDaoImpl TvDao=new TvDaoImpl();
RegisterUsers users=new RegisterUsers();



public	void addAdminMenu()
	{
System.out.println("1)Electronics");
System.out.println("2)Electricals");
System.out.println("3)RegistredUsers");
System.out.println("4)Back");
System.out.println("Enter choice");
int choice=sc.nextInt();
switch(choice)
{
case 1:
	electronicsMenu();
	break;
case 2:
	electricalsMenu();
	break;
case 3:
	users.viewAllUsers();
	break;
case 4:
	ShopingClient.main(null);
	break;
	default:
		System.out.println("Choose 1 to 2 in between");
		break;
	
}

	}
	
void electronicsMenu()
{
	System.out.println("1)Mobile");
	System.out.println("2)computer");
	System.out.println("3)Back");
System.out.println("Ener your choice");
	int choice=sc.nextInt();
	switch(choice)
	{
	case 1:
		mobileMenu();
		break;
	case 2:
		ComputerMenu();
		break;
	case 3:
		addAdminMenu();
		default:
			System.out.println("Choose 1 to 2 in between");
			break;
		
	}

		}

void mobileMenu()
{
	System.out.println("1)AddMobiles");
	System.out.println("2)viewMobiles");
	System.out.println("3)viewSpecificMobiles");
	System.out.println("4)updateMobiles");
	System.out.println("5)deleteMobiles");
	System.out.println("6)back");
	System.out.println("Ener your choice");
	int choice=sc.nextInt();
	switch(choice)
	{
	case 1:
		mobileDao.addMobileDetails();
		mobileMenu();
		break;
	case 2:
		List<Mobile>viewRecords=mobileDao.viewMobileDetails();
	for(Mobile mobile : viewRecords)
	{
		System.out.println(mobile);
	}
	mobileMenu();
		break;
	case 3:
	Mobile mobile=	mobileDao.viewSpecificProduct();
	if(mobile!=null)
	System.out.println(mobile);

		else
			System.out.println("Given Number is not avilabel Try once again");
		
		mobileMenu();
	case 4:
		mobileDao.updateProductDetails();
		mobileMenu();
		break;
	case 5:
		mobileDao.deleteProductDetails();
		mobileMenu();
	case 6:
		electronicsMenu();
		default:
			System.out.println("Choose 1 to 2 in between");
			break;
		
	}

		}

void ComputerMenu()
{
	System.out.println("1)AddComputer");
	System.out.println("2)viewComputer");
	System.out.println("3)viewSpecificComputer");
	System.out.println("4)updateComputer");
	System.out.println("5)deleteComputer");
	System.out.println("6)back");
	System.out.println("Ener your choice");
	int choice=sc.nextInt();
	switch(choice)
	{
	case 1:
		ComputerDao.addComputerDetails();
		ComputerMenu();
		break;
	case 2:
		List<Computer>viewRecords=ComputerDao.viewComputerDetails();
	for(Computer Computer : viewRecords)
	{
		System.out.println(Computer);
	}
		ComputerMenu();
		break;
	case 3:
		Computer computer=ComputerDao.viewSpecificComputerDetails();
	if(computer!=null)
	System.out.println(computer);

		else
			System.out.println("Given Number is not avilabel Try once again");
		
	ComputerMenu();
	case 4:
		ComputerDao.updateComputerDetails();
		ComputerMenu();
		break;
	case 5:
		ComputerDao.deleteComputerDetails();
		ComputerMenu();
	case 6:
		electronicsMenu();
		default:
			System.out.println("Choose 1 to 2 in between");
			break;
		
	}
}
void electricalsMenu()
{
	System.out.println("1)TV");

	int choice=sc.nextInt();
	switch(choice)
	{
	case 1:
		tvMenu();
		break;
		default:
			System.out.println("Choose 1 to 2 in between");
			break;
		
	}

		}

void tvMenu()
{
	
		System.out.println("1)Addtv");
		System.out.println("2)viewtv");
		System.out.println("3)viewSpecifictv");
		System.out.println("4)updatetv");
		System.out.println("5)deletetv");
		System.out.println("6)back");
		System.out.println("Ener your choice");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			TvDao.addTvDetails();
			tvMenu();
			break;
		case 2:
			List<Tv>viewRecords=TvDao.viewTvDetails();
		for(Tv tv : viewRecords)
		{
			System.out.println(tv);
		}
		tvMenu();
		break;
		case 3:
		Tv tv=	TvDao.viewSpecificTvDetails();
		if(tv!=null)
		System.out.println(tv);

			else
				System.out.println("Given Number is not avilabel Try once again");
			
		tvMenu();
		case 4:
			TvDao.updateTvDetails();
			tvMenu();
			break;
		case 5:
			TvDao.DeleteTvDetails();
			tvMenu();
		case 6:
			electricalsMenu();		
			default:
				System.out.println("Choose 1 to 2 in between");
				break;
			
		}

}
	
}