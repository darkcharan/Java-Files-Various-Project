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
import com.Shopingcart.admin.bean.Tv;

public class TvUserDaoImpl implements TvUserDao {
	
	Scanner sc=new Scanner(System.in);
	File orginalFile=new File("Tv.txt");
	File tempFile=new File("temp.txt");

	List<Tv>viewRecords=null;
	List<Tv>tempRecords=null;

	FileInputStream fis=null;
	ObjectInputStream ois=null;
	FileOutputStream fos=null;
	ObjectOutputStream oos=null;
	private int tno;
	
	
	

	@Override
	public List<Tv> viewTvDetails() {
		// TODO Auto-generated method stub
		try {
			fis=new FileInputStream(orginalFile);
		     try {
				ois=new ObjectInputStream(fis);
				Object obj=ois.readObject();
				viewRecords=(List<Tv>) obj;
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
	public void Shopping() {
		// TODO Auto-generated method stub
		

		viewRecords=new ArrayList<Tv>();
		tempRecords=new ArrayList<Tv>();

		try {
			fis=new FileInputStream(orginalFile);
			ois=new ObjectInputStream(fis);
		viewRecords=	(List<Tv>) ois.readObject();
			for(Tv tv : viewRecords)
			{
				System.out.println(tv);
			}
			System.out.println("Select which product u want to Buy");
			int mid=sc.nextInt();
			System.out.println("How many products u want to Buy");
			int mqty=sc.nextInt();
    for(Tv tv : viewRecords)
	{
	if(tv.getTvno()==tno)
	   {
		System.out.println("Tv TvId :"+tv.getTvno());
		System.out.println("Tv Name :"+tv.getTname());
		System.out.println("Tv Price :"+tv.getPrice());
		System.out.println("Tv Qty :"+mqty);
		System.out.println("Total Bill :"+(tv.getPrice()*mqty));
	tv.setQty(tv.getQty()-mqty);	
	tempRecords.add(tv);
	      }
	else
	{
		tempRecords.add(tv);
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


