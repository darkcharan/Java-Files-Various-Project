package com.Shopingcart.user.Dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import com.Shopingcart.admin.bean.Mobile;

public class ReportDaoImpl implements ReportDao {

FileInputStream fis=null;
ObjectInputStream ois=null;
List<Mobile>viewStock=null;	
@Override
	public void mobileStock() {
		// TODO Auto-generated method stub
try {
	fis=new FileInputStream("Mobile.txt");
	ois=new ObjectInputStream(fis);
	viewStock=(List<Mobile>) ois.readObject();
	System.out.println("PID\tPRNAME\tPRICE\tQUANTITY");
	for(Mobile mobile: viewStock)
	{
		System.out.println(mobile);
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

	@Override
	public void computerStock() {
		// TODO Auto-generated method stub

	}

	@Override
	public void tvStock() {
		// TODO Auto-generated method stub

	}

}
