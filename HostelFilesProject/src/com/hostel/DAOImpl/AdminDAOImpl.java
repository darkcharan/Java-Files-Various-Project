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
import java.util.regex.Pattern;

import com.hostel.bean.Hostel;
import com.hostel.dao.AdminDAO;

public class AdminDAOImpl implements AdminDAO {
	File original = new File("hostel.txt");
	File tempFile = new File("temp.txt");
	File fus=new File("users.txt");
    Scanner sc = new Scanner(System.in);
	Hostel hostel = null;
	List<Hostel> rooms = new ArrayList<Hostel>();
	List<Hostel> tempList = new ArrayList<Hostel>();
	FileInputStream fis = null;
	FileOutputStream fos = null;
	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	
	
	@Override
	public void addRooms() {
	   try {
		fos = new FileOutputStream(original);
		   oos = new ObjectOutputStream(fos);
		   int i=1;
		   while(i==1)
		   {
			   System.out.println("Enter Room No: ");
			   String r=sc.next();
			   while(!Pattern.matches("\\d{3}", r))
			   {
				   System.err.println("Enter 3 digit room number only: ");
				   r = sc.next();
			   }
			   
			   int roomNo = Integer.parseInt(r);
			   
			   System.out.println("Enter Room Type(single,double,triple): ");
			   
			   String roomType = sc.next();
			   while(!Pattern.matches("^[single,double,triple]+$", roomType))
			   {
				   System.err.println("Enter only single or double or triple: ");
				   roomType = sc.next();
			   }
			   System.out.println("Enter ac OR nonac: ");
			   String acNonac = sc.next();
			   while(!Pattern.matches("^[ac,nonac]+$",acNonac))
			   {
				   System.err.println("Enter only ac or non ac: ");
				   acNonac = sc.next();
				   
			   }
			   System.out.println("Enter Room Fare: ");
			   
			   String fa=sc.next();
			   while(!Pattern.matches("[0-9]+$", fa))
			   {
				   System.err.println("Enter only digits : ");
				   fa = sc.next();
			   }
			   
			   int roomFare = Integer.parseInt(fa);
			   
			   System.out.println("Enter Room Availability: ");
			   String availability=sc.next();
			   while(!Pattern.matches("[a-zA-Z]+$", availability))
			   {
				   System.err.println("Enter only alphabets : ");
				   availability = sc.next();
			   }
			   
			   hostel = new Hostel(roomNo,roomType,acNonac,roomFare,availability);
			   rooms.add(hostel);
			   System.out.println("Enter 1 add more rooms and enter other than 1 to stop ");
			   i=sc.nextInt();
			   
		   }
		   oos.writeObject(rooms);
		   oos.flush();
		   System.out.println("Rooms added Successfully");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   finally{
		   try {
			fos.close();
			   oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
		
		
	}

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
	public void updateFare(int roomNo) {
		try {
			List<Hostel> rooms = new ArrayList<Hostel>();
			List<Hostel> tempList = new ArrayList<Hostel>();
			fis = new FileInputStream(original);
			ois = new ObjectInputStream(fis);
			rooms = (List<Hostel>)ois.readObject();
			for(Hostel h:rooms)
			{
				if(h.getRoomNo()==roomNo)
				{
					System.out.println("|=======select update filed======|");
					System.out.println("==================================");
					System.out.println("|           1.roomType           |");
					System.out.println("|           2.ACNONAC            |");
					System.out.println("|           3.roomFare           |");
					System.out.println("|           4.Availability       |");
					System.out.println("==================================");
			        int choice = sc.nextInt();
			        switch(choice)
			        {
			        case 1:System.out.println("Enter updated room type:");
			               h.setRoomType(sc.next());
			               break;
			        case 2:System.out.println("Enter updated acNonac:");
			               h.setAcNonac(sc.next());
			               break;
			        case 3:System.out.println("Enter updated room fare:");
			               h.setRoomFare(sc.nextInt());
			               break;
			        case 4:System.out.println("Enter updated room availability:");
		                    h.setAvailability(sc.next());
		                    break;
			        
			        default: System.out.println("select your choice 1 to 4 only:");
			        }
			        tempList.add(h);
				}
				else
				{
					tempList.add(h);
				}
				fos = new FileOutputStream(tempFile);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(tempList);
				oos.flush();
				original.delete();
				tempFile.renameTo(original);
				
				
			}
		} catch (ClassNotFoundException | IOException e) {
		
			e.printStackTrace();
		}
		finally
		{
			try {
				fis.close();
				ois.close();
				fos.close();
				oos.close();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		}
		System.out.println("Updated Successfully");
		
	}

	@Override
	public void deleteRoom(int roomNo) {
		try {
			List<Hostel> rooms = new ArrayList<Hostel>();
			List<Hostel> tempList = new ArrayList<Hostel>();
			fis = new FileInputStream(original);
			ois = new ObjectInputStream(fis);
			rooms = (List<Hostel>)ois.readObject();
			for(Hostel h:rooms)
			{
				if(h.getRoomNo()==roomNo)
				{
					
				}
				else
				{
					tempList.add(h);
				}
				fos = new FileOutputStream(tempFile);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(tempList);
				oos.flush();
				original.delete();
				tempFile.renameTo(original);
				
				
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
				fos.close();
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Deleted Successfully");
		
		
			}

	

	
	
}
