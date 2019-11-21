package com.shoping.user.dao;

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

import com.shoping.admin.bean.Product;

public class ProductUserDaoImpl123 implements ProductUserDao {

	File originalFile=new File("product.ser");
	File tempFile=new File("temp.ser");
FileOutputStream fos=null;
ObjectOutputStream oos=null;
	FileInputStream fis=null;
	ObjectInputStream ois=null;
	List<Product> viewRecords=null;
	List<Product> tempRecords=null;

	Scanner sc=new Scanner(System.in);
	@Override
	public List<Product> viewAllProducts() {
		// TODO Auto-generated method stub
		try {
			fis=new FileInputStream(originalFile);
			ois=new ObjectInputStream(fis);
			viewRecords=		(List<Product>) ois.readObject();
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
		return viewRecords;
	}

	@Override
	public void selectProductDetails() {
		// TODO Auto-generated method stub
		try {
			fis=new FileInputStream(originalFile);
			ois=new ObjectInputStream(fis);
			viewRecords=		(List<Product>) ois.readObject();
			tempRecords=new ArrayList<Product>();

			
			for(Product product : viewRecords)
			{
				System.out.println(product);
			}
		
			System.out.println("Do You Want to Continue Shopping press 1 or 0");
		int k=sc.nextInt();
	while(k==1)
		{
		for(Product pro : viewRecords)
		{
			System.out.println(pro);
		}
			
		System.out.println("Select Which product wants to Buy");
		int pid=sc.nextInt();
		System.out.println("How many products u want to Buy");
		int qty=sc.nextInt();
		int s=0;
		for(Product product : viewRecords)
		{
             if(product.getPid()==pid)
             {
           System.out.println("Product Id    :\t"+product.getPid());
           System.out.println("Product name  :\t"+product.getPname());
           System.out.println("Product Price :\t"+product.getPprice());
           System.out.println("Product Quanty:\t"+qty);
           System.out.println("===============================================");
           System.out.println("   Total Bill :\t "+(product.getPprice()*qty));
           System.out.println("===============================================");
           product.setPqty(product.getPqty()-qty);
           tempRecords.add(product);
           s++;
        //   System.out.println(s+"\t"+tempRecords);
             }
             
             else
             {
            	 s++;
                       	 tempRecords.add(product);
                     //  	System.out.println(s+"\t"+tempRecords);
             }
		
		}//end of forloop
		if(s==0)
		{
			System.out.println("Selected ProductId Is Not Avilable");
		}
		
		System.out.println("Do You Want to Continue Shopping press 1 or 0");
		k=sc.nextInt();
		if(k==1)
		{
			fos=new FileOutputStream(tempFile);
			oos=new ObjectOutputStream(fos);
			oos.writeObject(tempRecords);
			oos.flush();
			originalFile.delete();
			tempFile.renameTo(originalFile);	
			tempRecords=new ArrayList<Product>();
		}
		else
		{
			fos=new FileOutputStream(tempFile);
			oos=new ObjectOutputStream(fos);
			oos.writeObject(tempRecords);
			oos.flush();
			originalFile.delete();
			tempFile.renameTo(originalFile);
			tempRecords=new ArrayList<Product>();
		}
		
		
		
		
		}//end of while loop
		
			
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
		
		
	}

}
