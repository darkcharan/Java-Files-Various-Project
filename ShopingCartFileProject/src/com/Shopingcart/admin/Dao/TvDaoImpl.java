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


import com.Shopingcart.admin.bean.Tv;

public class TvDaoImpl implements TvDao {
	Scanner sc=new Scanner(System.in);
	Tv t=null;
	List<Tv>TRecords=null;
	File orginalFile=new File("Tv.txt");
	File tempFile = new File("tempFile.txt");
	List<Tv> tempList = new ArrayList<Tv>();
	FileOutputStream fos=null;
	ObjectOutputStream oos=null;
	FileInputStream fis=null;
	ObjectInputStream ois=null;
	private int Tno;
	private Tv st;
	private int Tvno;
	
	
	
	
	
	
	
	

	@Override
	public void addTvDetails() {
		// TODO Auto-generated method stub
		
		TRecords=new ArrayList<Tv>();
		int k=1;
		while(k==1)
		{
		System.out.println("Enter Tv Number");
		int tno=sc.nextInt();
		System.out.println("Enter Tv Name");
		String tname=sc.next();
		System.out.println("Enter Tv price");
		double tprice=sc.nextDouble();
		System.out.println("Enter Tv quantity");
		int tqty=sc.nextInt();
		t=new Tv(tno,tname,tprice,tqty);
		TRecords.add(t);
		System.out.println("Do You want add One more Record 1)Confirm 2)Cancel");
		k=sc.nextInt();
		}

		try {
			fos=new FileOutputStream(orginalFile,true);
			oos=new ObjectOutputStream(fos);
			oos.writeObject(TRecords);
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
	public List<Tv> viewTvDetails() {
		// TODO Auto-generated method stub
		
		TRecords=new ArrayList<Tv>();
		try {
			fis=new FileInputStream(orginalFile);
			ois=new ObjectInputStream(fis);
			TRecords=(List<Tv>)ois.readObject();
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
		return TRecords;
	}
		
		
	

	@Override
	public Tv viewSpecificTvDetails() {
		// TODO Auto-generated method stub
		TRecords=new ArrayList<Tv>();
		Tv Tv=null;
		try {
			System.out.println("Enter Tvno");
			int Tvno=sc.nextInt();
			fis=new FileInputStream(orginalFile);
			ois=new ObjectInputStream(fis);
			TRecords=(List<Tv>)ois.readObject();
for(Tv st : TRecords)
{
	if (st.getTvno() == Tvno)
	{
		Tv=st;
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
		return Tv ;
	}		
		
		
		
		
		
		

	

	@Override
	public void updateTvDetails() {
		// TODO Auto-generated method stub

		try {
			TRecords = new ArrayList<Tv>();
			fis = new FileInputStream(orginalFile);
			ois = new ObjectInputStream(fis);
			TRecords=(List<Tv>)ois.readObject();


			for(Tv st :TRecords)
			{
			if (st.getTvno() == Tno)
				{
					System.out.println("select which file do you want to update 1. Name  2. price 3.quantity");
					int choice = sc.nextInt();
					switch (choice) {
					case 1:
						System.out.println("Enter Updated Tv Name ?");
						t.setTname(sc.next());
						break;
					case 2:
						System.out.println("Enter Updated  Tv price?");
						t.setPrice(sc.nextDouble());
						break;
					case 3:
						System.out.println("Enter Updated   Tv quantity?");
						t.setQty(sc.nextInt());
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
	public void DeleteTvDetails() {
		// TODO Auto-generated method stub
		
		tempList = new ArrayList<Tv>();
		Tv Tv=null;
		try {
			TRecords = new ArrayList<Tv>();
			
			fis = new FileInputStream(orginalFile);
			ois = new ObjectInputStream(fis);
			TRecords = (List<Tv>) ois.readObject();
			Iterator<Tv> it = TRecords.iterator();
			// Student updatedStudent = new Student();
			while (it.hasNext()) {
				Tv = it.next();
				if (st.getTvno() == Tvno) {
					
				} else {
					tempList.add(Tv);
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


