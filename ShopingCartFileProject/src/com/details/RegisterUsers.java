package com.details;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import com.Shopingcart.admin.bean.Customer;
import com.Shopingcart.admin.bean.Mobile;

public class RegisterUsers {
	FileInputStream fis=null;
	ObjectInputStream ois=null;
	List<Customer>viewusers=null;	

	public void viewAllUsers()
	{
		try {
			fis=new FileInputStream("customer.txt");
			ois=new ObjectInputStream(fis);
			viewusers=(List<Customer>) ois.readObject();
			System.out.println("CUSTOMERNAME\tCUSTOMERPASSWORD\tMOBILENUMBER");
			for(Customer customer: viewusers)
			{
				System.out.println(customer);
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

		
	}
}
