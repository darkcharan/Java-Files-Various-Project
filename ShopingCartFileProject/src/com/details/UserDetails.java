package com.details;

import java.util.List;
import java.util.Scanner;

import com.Shopingcart.admin.bean.Mobile;
import com.Shopingcart.user.Dao.MobileUserDaoImpl;
import com.shoping.client.ShopingClient;

public class UserDetails {
	
	  Scanner sc=new Scanner(System.in);
      MobileUserDaoImpl ui=new MobileUserDaoImpl();
public void userMenu(){
while(true){
System.out.println("1)viewMobileDevices");
System.out.println("2)shoping");
System.out.println("3)back");
System.out.println("Enter ur choice");

int choice=sc.nextInt();
switch(choice)
{
case 1:
List<Mobile>Records=ui.viewMobileDetails();
for(Mobile mobile : Records)
   {
	System.out.println(mobile);
    }
  break;
case 2:
	ui.shoping();
	break;
case 3: 
	ShopingClient.main(null);
	break;
default:
	System.out.println("choose 1 to 3 between");
}	
}	
}

}
