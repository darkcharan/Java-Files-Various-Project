package com.Shopingcart.admin.Dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.Shopingcart.admin.bean.Mobile;

public class MobileDaoImpl implements MobileDao {
	Scanner sc=new Scanner(System.in);
	Mobile mb=null;
	List<Mobile>mobRecords=null;
	File orginalFile=new File("Mobile.txt");
	File tempFile = new File("tempFile.txt");
	List<Mobile> tempList = new ArrayList<Mobile>();
	FileOutputStream fos=null;
	ObjectOutputStream oos=null;
	FileInputStream fis=null;
	ObjectInputStream ois=null;
	private int Mno;
	private Mobile st;
	


	@Override
	public void addMobileDetails() {
		// TODO Auto-generated method stub
		mobRecords=new ArrayList<Mobile>();
		int k=1;
		while(k==1)
		{
		System.out.println("Enter Mobile Number");
		int mno=sc.nextInt();
		System.out.println("Enter Mobile Name");
		String mname=sc.next();
		System.out.println("Enter Mobile price");
		double mprice=sc.nextDouble();
		System.out.println("Enter Mobile quantity");
		int mqty=sc.nextInt();
		mb=new Mobile(mno,mname,mprice,mqty);
		mobRecords.add(mb);
		System.out.println("Do You want add One more Record 1)Confirm 2)Cancel");
		k=sc.nextInt();
		}

		try {
			fos=new FileOutputStream(orginalFile,true);
			oos=new ObjectOutputStream(fos);
			oos.writeObject(mobRecords);
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
	}

	@Override
	public List<Mobile> viewMobileDetails() {
		// TODO Auto-generated method stub
		mobRecords=new ArrayList<Mobile>();
		try {
			fis=new FileInputStream(orginalFile);
			ois=new ObjectInputStream(fis);
			mobRecords=(List<Mobile>)ois.readObject();
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
		}
		return mobRecords;
	}

	@Override
	public Mobile viewSpecificProduct() {
		// TODO Auto-generated method stub
		mobRecords=new ArrayList<Mobile>();
		Mobile Mobile=null;
		try {
			System.out.println("Enter mno");
			int mno=sc.nextInt();
			fis=new FileInputStream(orginalFile);
			ois=new ObjectInputStream(fis);
			mobRecords=(List<Mobile>)ois.readObject();
for(Mobile st : mobRecords)
{
	if (st.getMno() == mno)
	{
		Mobile=st;
		break;
	}
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
		}
		return Mobile;
	}		
		
	
	@Override
	public void updateProductDetails() {
		// TODO Auto-generated method stub
		try {
			mobRecords = new ArrayList<Mobile>();
			fis = new FileInputStream(orginalFile);
			ois = new ObjectInputStream(fis);
			mobRecords=(List<Mobile>)ois.readObject();


			for(Mobile st :mobRecords)
			{
			if (st.getMno() == Mno)
				{
					System.out.println("select which file do you want to update 1. Name  2. price 3.quantity");
					int choice = sc.nextInt();
					switch (choice) {
					case 1:
						System.out.println("Enter Updated Mobile Name ?");
						mb.setMname(sc.next());
						break;
					case 2:
						System.out.println("Enter Updated price?");
						mb.setPrice(sc.nextDouble());
						break;
					case 3:
						System.out.println("Enter Updated quantity?");
						mb.setQty(sc.nextInt());
						break;
					default:
						System.out.println("Please select choice range 1-3 only");
						break;

					}//switch close
					tempList.add(st);
				} //if close
				
				else {
					tempList.add(st);
				}//else close
			}//while close
			fos = new FileOutputStream(tempFile);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(tempList);
			oos.flush();
			orginalFile.delete();
			tempFile.renameTo(orginalFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Successfully Record updated");
	}


	@Override
	public void deleteProductDetails() {
		// TODO Auto-generated method stub
		
		tempList = new ArrayList<Mobile>();
		Mobile Mobile=null;
		try {
			mobRecords = new ArrayList<Mobile>();
			
			fis = new FileInputStream(orginalFile);
			ois = new ObjectInputStream(fis);
			mobRecords = (List<Mobile>) ois.readObject();
			Iterator<Mobile> it = mobRecords.iterator();
			// Student updatedStudent = new Student();
			while (it.hasNext()) {
				Mobile = it.next();
				if (st.getMno() == Mno) {
					
				} else {
					tempList.add(Mobile);
				}
			}
			fos = new FileOutputStream(tempFile);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(tempList);
			oos.flush();
			orginalFile.delete();
			tempFile.renameTo(orginalFile);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Successfully Record Deleted");
	}


	}




