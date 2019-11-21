package com.register;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Shopingcart.admin.bean.Customer;

public class RegistrationImpl {
Scanner sc=new Scanner(System.in);
File originalFile=new File("customer.txt");
File tempFile=new File("temp.txt");

FileOutputStream fos=null;
ObjectOutputStream oos=null;
Customer bean=null;
List<Customer>addRecords=null;
List<Customer>tempRecords=null;

List<Customer>viewRecords=null;
FileInputStream fis=null;
ObjectInputStream ois=null;
	public void register()
	{
		addRecords=new ArrayList<Customer>();
		viewRecords=new ArrayList<Customer>();
		tempRecords=new ArrayList<Customer>();
		int k=1;
while(k==1)
{
	System.out.println("Enter CustomerName");
	String cname=sc.next();
	System.out.println("Enter password");
	String pwd=sc.next();
	System.out.println("MobileNumber");
	long mobileNumber=sc.nextLong();
	bean=new Customer(cname,pwd,mobileNumber);
	addRecords.add(bean);
System.out.println("Do You Want to Add one more Record");
k=sc.nextInt();
}//end while loop
	try {
	if(!originalFile.exists())
	{
	
		fos=new FileOutputStream(originalFile);
		oos=new ObjectOutputStream(fos);
		oos.writeObject(addRecords);
		oos.flush();
	}
	else
	{
		fis=new FileInputStream(originalFile);
		ois=new ObjectInputStream(fis);
		viewRecords=(List<Customer>) ois.readObject();
		for(Customer cust : viewRecords)
		{
		tempRecords.add(cust);	
		}
	fos=new FileOutputStream(tempFile);
	oos=new ObjectOutputStream(fos);
	oos.writeObject(tempRecords);
	originalFile.delete();
tempFile.renameTo(originalFile);
	}
	
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	finally
	{
		if(ois!=null)
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(oos!=null)
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	}
	
	
}
