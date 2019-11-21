package com.hostel.DAOImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.hostel.bean.Hostel;
import com.hostel.dao.UserDAO;

public class UserDAOImpl implements UserDAO {
	File original = new File("hostel.txt");
	File tempFile = new File("temp.txt");
    Scanner sc = new Scanner(System.in);
	Hostel hostel = null;
	List<Hostel> rooms = new ArrayList<Hostel>();
	List<Hostel> tempList = new ArrayList<Hostel>();
	FileInputStream fis = null;
	FileOutputStream fos = null;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	
	
	@Override
	public Hostel viewRoom(int roomNo) {
		Hostel h = null;
		try {
			fis = new FileInputStream(original);
			ois = new ObjectInputStream(fis);
			List<Hostel> rooms = (List<Hostel>)ois.readObject();
			Iterator<Hostel> it = rooms.iterator();
			while(it.hasNext())
			{
				h=it.next();
				if(h.getRoomNo()==roomNo)
				{
					break;
				}
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				fis.close();
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return h;
		
	}

	@Override
	public List<Hostel> viewAllrooms() {
       List<Hostel> latest = new ArrayList<Hostel>();
		
		try {
			fis = new FileInputStream(original);
			ois = new ObjectInputStream(fis);
			latest = (List<Hostel>)ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				fis.close();
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return latest;
		
	}

	@Override
	public void bookRoom(int roomNo) {
		// TODO Auto-generated method stub
		
			try {
				List<Hostel> rooms = new ArrayList<Hostel>();
				List<Hostel> tempList = new ArrayList<Hostel>();
				
				Hostel selected = new Hostel();
				
				fis = new FileInputStream(original);
				ois = new ObjectInputStream(fis);
				
				rooms = (List<Hostel>)ois.readObject();
		
				selected.setRoomNo(roomNo);
				Hostel confirm = new Hostel();
				Iterator<Hostel> it =  rooms.iterator();
				while(it.hasNext())
				{
					confirm = it.next();
					if(confirm.getRoomNo()==selected.getRoomNo())
					{
						System.out.println("Enter payment: 1.Done 2.NotDone");
						int choice = sc.nextInt();
						switch(choice)
						{
						case 1: System.out.println("Check into room No"+selected.getRoomNo());
						        System.out.println("Carry your Payment receipt");
						        for(Hostel c:rooms)
						        {
						        	
						           if(c.getRoomNo()==selected.getRoomNo())
						           {
						        	 c.setAvailability("BOOKED");
						        	 tempList.add(c);
						           }
						           else
						           {
						        	tempList.add(c);
						           }
						        }
						        fos = new FileOutputStream(tempFile);
						        oos = new ObjectOutputStream(fos);
						        oos.writeObject(tempList);
						        oos.flush();
						        original.delete();
						        tempFile.renameTo(original);
						        break;
						case 2:System.out.println("First Proceed with payement");
						       break;
						default:System.out.println("Enter choice from 1 to 2");
						       break;
						      
						}
						break;
					}
					else
					{
						System.out.println("Already room booked so enter another room number: ");
						int r=sc.nextInt();
						bookRoom(r);
					}
				}		
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		finally{
			    try {
					fis.close();
					fos.close();
					ois.close();
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    
		}
		
	}

}
