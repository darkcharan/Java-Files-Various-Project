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

import com.Shopingcart.admin.bean.Computer;




public class ComputerUserDaoImpl implements ComputerUserDao {
	
	Scanner sc=new Scanner(System.in);
	File orginalFile=new File("Computer.txt");
	File tempFile=new File("temp.txt");

	List<Computer>viewRecords=null;
	List<Computer>tempRecords=null;

	FileInputStream fis=null;
	ObjectInputStream ois=null;
	FileOutputStream fos=null;
	ObjectOutputStream oos=null;
	private int cno;
	private String cqnty;
	
	

	@Override
	public List<Computer> ViewComputerDetails() {
		// TODO Auto-generated method stub
		
		
		
		try {
			fis=new FileInputStream(orginalFile);
		     try {
				ois=new ObjectInputStream(fis);
				Object obj=ois.readObject();
				viewRecords=(List<Computer>) obj;
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

		viewRecords=new ArrayList<Computer>();
		tempRecords=new ArrayList<Computer>();

		try {
			fis=new FileInputStream(orginalFile);
			ois=new ObjectInputStream(fis);
		viewRecords=	(List<Computer>) ois.readObject();
			for(Computer computer : viewRecords)
			{
				System.out.println(computer);
			}
			System.out.println("Select which product u want to Buy");
			int mid=sc.nextInt();
			System.out.println("How many products u want to Buy");
			int mqty=sc.nextInt();
    for(Computer computer : viewRecords)
	{
	if(computer.getCno()==cno)
	   {
		System.out.println("Computer ComputerId :"+computer.getCno());
		System.out.println("Computer Name :"+computer.getCnmae());
		System.out.println("Computer Price :"+computer.getCprice());
		System.out.println("Computer Qty :"+cqnty);
		System.out.println("Total Bill :"+(computer.getCprice()*mqty));
	computer.setCqnty(computer.getCqnty()-mqty);	
	tempRecords.add(computer);
	      }
	else
	{
		tempRecords.add(computer);
	    }

	fos=new FileOutputStream(tempFile);
	oos=new ObjectOutputStream(fos);
	oos.writeObject(tempRecords);
	oos.flush();
	orginalFile.delete();
	tempFile.renameTo(orginalFile);


	
	}


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


