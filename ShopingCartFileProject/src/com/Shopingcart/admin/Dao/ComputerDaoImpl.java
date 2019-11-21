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

import com.Shopingcart.admin.bean.Computer;
import com.Shopingcart.admin.bean.Mobile;


public class ComputerDaoImpl implements ComputerDao {
	Scanner sc=new Scanner(System.in);
	Computer c=null;
	List<Computer>comRecords=null;
	File orginalFile=new File("Computer.txt");
	File tempFile = new File("tempFile.txt");
	List<Computer> tempList = new ArrayList<Computer>();
	FileOutputStream fos=null;
	ObjectOutputStream oos=null;
	FileInputStream fis=null;
	ObjectInputStream ois=null;
	private int cno;
	private Computer st;
	
	
	
	
	
	
	

	@Override
	public void addComputerDetails() {
		// TODO Auto-generated method stub
		comRecords=new ArrayList<Computer>();
		int k=1;
		while(k==1)
		{
		System.out.println("Enter computer Number");
		int cno=sc.nextInt();
		System.out.println("Enter computer Name");
		String cname=sc.next();
		System.out.println("Enter computer price");
		double cprice=sc.nextDouble();
		System.out.println("Enter computer quantity");
		int cqty=sc.nextInt();
		c=new Computer(cno,cname,cprice,cqty);
		comRecords.add(c);
		System.out.println("Do You want add One more Record 1)Confirm 2)Cancel");
		k=sc.nextInt();
		}

		try {
			fos=new FileOutputStream(orginalFile,true);
			oos=new ObjectOutputStream(fos);
			oos.writeObject(comRecords);
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
	public List<Computer> viewComputerDetails() {
		// TODO Auto-generated method stub
		comRecords=new ArrayList<Computer>();
		try {
			fis=new FileInputStream(orginalFile);
			ois=new ObjectInputStream(fis);
			comRecords=(List<Computer>)ois.readObject();
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
		return comRecords;
	}

	

	

	@Override
	public Computer viewSpecificComputerDetails() {
		// TODO Auto-generated method stub
		comRecords=new ArrayList<Computer>();
		Computer Computer=null;
		try {
			System.out.println("Enter cno");
			int cno=sc.nextInt();
			fis=new FileInputStream(orginalFile);
			ois=new ObjectInputStream(fis);
			comRecords=(List<Computer>)ois.readObject();
for(Computer st : comRecords)
{
	if (st.getCno() == cno)
	{
		Computer=st;
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
		return Computer;

	}
		
		
		
		
		

	

	@Override
	public void updateComputerDetails() {
		// TODO Auto-generated method stub
		try {
			comRecords = new ArrayList<Computer>();
			fis = new FileInputStream(orginalFile);
			ois = new ObjectInputStream(fis);
			comRecords=(List<Computer>)ois.readObject();


			for(Computer ct :comRecords)
			{
			if (ct.getCno() == cno)
				{
					System.out.println("select which file do you want to update 1. Name  2. price 3.quantity");
					int choice = sc.nextInt();
					switch (choice) {
					case 1:
						System.out.println("Enter Updated Computer Name ?");
						ct.setCnmae(sc.next());
						break;
					case 2:
						System.out.println("Enter Updated  computer price?");
						ct.setCprice(sc.nextDouble());
						break;
					case 3:
						System.out.println("Enter Updated  computer quantity?");
						ct.setCqnty(sc.nextInt());
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
	public void deleteComputerDetails() {
		// TODO Auto-generated method stub
		tempList = new ArrayList<Computer>();
		Computer Computer=null;
		try {
			comRecords = new ArrayList<Computer>();
			
			fis = new FileInputStream(orginalFile);
			ois = new ObjectInputStream(fis);
			comRecords = (List<Computer>) ois.readObject();
			Iterator<Computer> it = comRecords.iterator();
			// Student updatedStudent = new Student();
			while (it.hasNext()) {
				Computer = it.next();
				if (st.getCno() == cno) {
					
				} else {
					tempList.add(Computer);
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


