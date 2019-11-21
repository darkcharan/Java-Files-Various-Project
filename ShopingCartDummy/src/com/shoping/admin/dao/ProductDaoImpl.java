package com.shoping.admin.dao;

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

public class ProductDaoImpl implements ProductAdminDao {

	Scanner sc=new Scanner(System.in);
	Product product=null;
	List<Product>addRecords=new ArrayList<Product>();

	List<Product>tempRecords=null;

	File orignalFile=new File("product.ser");
	File tempFile=new File("temp.ser");

	FileOutputStream fos=null;
	ObjectOutputStream oos=null;
	FileInputStream fis=null;
	ObjectInputStream ois=null;
	@Override
	public void addProductDetails() {
		// TODO Auto-generated method stub
		int k=1;
		addRecords=new ArrayList<Product>();
		while(k==1)
		{
System.out.println("Enter ProductNumber");
int pno=sc.nextInt();
System.out.println("Enter ProductName");
String pname=sc.next();
System.out.println("Enter Prodcut price");
double pprice=sc.nextDouble();
System.out.println("Enter Prodcut pqnty");
int pqnty=sc.nextInt();
product=new Product(pno,pname,pprice,pqnty);
addRecords.add(product);
System.out.println("Do you want to add one more Record press 1 or 0");
k=sc.nextInt();
		}
if(!orignalFile.exists())
{
	try {
		fos=new FileOutputStream(orignalFile);
		oos=new ObjectOutputStream(fos);
		oos.writeObject(addRecords);
		oos.flush();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
finally
{
	if(oos!=null)
		try {
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}//end of if condition
else
{
	tempRecords=new ArrayList<Product>();
	
	try {
		fis=new FileInputStream(orignalFile);
		ois=new ObjectInputStream(fis);
		Object obj=ois.readObject();
		tempRecords=(List<Product>) obj;
		for(Product product : tempRecords)
		{
			addRecords.add(product);
		}
		fos=new FileOutputStream(tempFile);
		oos=new ObjectOutputStream(fos);
		oos.writeObject(addRecords);
		orignalFile.delete();
		tempFile.renameTo(orignalFile);
		
		
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

	@Override
	public List<Product> viewProductDetails() {
		// TODO Auto-generated method stub
		addRecords=new ArrayList<Product>();

	try {
		fis=new FileInputStream(orignalFile);
		ois=new ObjectInputStream(fis);
		addRecords=	(List<Product>) ois.readObject();
			
		
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
	
		return addRecords;
	}

	@Override
	public Product viewProduct(int pno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProducts(int pno) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProducts(int pno) {
		// TODO Auto-generated method stub

	}

}
