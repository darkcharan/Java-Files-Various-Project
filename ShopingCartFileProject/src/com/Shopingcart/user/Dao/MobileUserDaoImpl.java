package com.Shopingcart.user.Dao;

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

import com.Shopingcart.admin.bean.Mobile;

public class MobileUserDaoImpl implements MobileUserDao {
	Scanner sc=new Scanner(System.in);
	File orginalFile=new File("Mobile.txt");
	File tempFile=new File("temp.txt");

	List<Mobile>viewRecords=null;
	List<Mobile>tempRecords=null;

	FileInputStream fis=null;
	ObjectInputStream ois=null;
	FileOutputStream fos=null;
	ObjectOutputStream oos=null;
	private int mno;
	
	@Override
	public List<Mobile> viewMobileDetails() {
		// TODO Auto-generated method stub
		try {
			fis=new FileInputStream(orginalFile);
		     try {
				ois=new ObjectInputStream(fis);
				Object obj=ois.readObject();
				viewRecords=(List<Mobile>) obj;
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return viewRecords;
		
	    }
		
		
		
		
		
	
	

	@Override
	public void shoping() {
		// TODO Auto-generated method stub
		
		
		

		viewRecords=new ArrayList<Mobile>();
		tempRecords=new ArrayList<Mobile>();

		try {
			fis=new FileInputStream(orginalFile);
			ois=new ObjectInputStream(fis);
		viewRecords=	(List<Mobile>) ois.readObject();
			for(Mobile mobile : viewRecords)
			{
				System.out.println(mobile);
			}
			System.out.println("Select which product u want to Buy");
			int mid=sc.nextInt();
			System.out.println("How many products u want to Buy");
			int mqty=sc.nextInt();
    for(Mobile mobile : viewRecords)
	{
	if(mobile.getMno()==mno)
	   {
		System.out.println("Mobile MobileId :"+mobile.getMno());
		System.out.println("Mobile Name :"+mobile.getMname());
		System.out.println("Mobile Price :"+mobile.getPrice());
		System.out.println("Mobile Qty :"+mqty);
		System.out.println("Total Bill :"+(mobile.getPrice()*mqty));
	mobile.setQty(mobile.getQty()-mqty);	
	tempRecords.add(mobile);
	      }
	else
	{
		tempRecords.add(mobile);
	    }

	fos=new FileOutputStream(tempFile);
	oos=new ObjectOutputStream(fos);
	oos.writeObject(tempRecords);
	oos.flush();
	orginalFile.delete();
	tempFile.renameTo(orginalFile);


	
	}//end for loop


		}//end of try block
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
