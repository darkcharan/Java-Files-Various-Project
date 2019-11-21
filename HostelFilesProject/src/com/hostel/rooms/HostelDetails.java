package com.hostel.rooms;

import java.util.List;
import java.util.Scanner;

import com.hostel.DAOImpl.AdminDAOImpl;
import com.hostel.DAOImpl.UserDAOImpl;
import com.hostel.bean.Hostel;
import com.hostel.main.HostelBooking;



public class HostelDetails {
	static Scanner sc = new Scanner(System.in);
	static AdminDAOImpl adminDAO = new AdminDAOImpl();
	static UserDAOImpl userDAO = new UserDAOImpl();

	public static void adminMenu() {
		System.out.println("---------------------");
		System.out.println("|    ADMIN MENU     |");
		System.out.println("---------------------");
		System.out.println("| 1.ADD ROOMS       |");
		System.out.println("| 2.VIEW ROOM       |");
		System.out.println("| 3.VIEW ALL ROOMS  |");
		System.out.println("| 4.UPDATE DETAILS  |");
		System.out.println("| 5.DELETE ROOM     |");
		System.out.println("| 6.BACK            |");
		System.out.println("---------------------");
		System.out.println("Enter Your Choice ?");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			adminDAO.addRooms();
			adminMenu();
			break;
		case 2:
			System.out.println("Enter Room Number ?");
			Hostel room = adminDAO.viewRoom(sc.nextInt());
			System.out.println("ROOMNO"+"\t"+ "ROOMTYPE"+"\t"+"ACNONAC"+"\t"+"ROOMFARE"+"\t"+"AVAILABILITY");
			System.out
					.println("-----------------------------------------------------------------------");
			System.out.println(room+"\t"+"\t"+"\t");
			adminMenu();
			break;
		case 3:
			List<Hostel> rooms = adminDAO.viewAllrooms();
			System.out.println("ROOMNO"+"\t"+"ROOMTYPE"+"\t"+"ACNONAC"+"\t"+"ROOMFARE"+"\t"+"AVAILABILITY");
			System.out
					.println("-----------------------------------------------------------------------");
			for (Hostel i : rooms) {
				System.out.println(i+"\t"+"\t"+"\t");

			}
			adminMenu();
			break;
		case 4:
			System.out.println("Which room number do you want Update ?");
			adminDAO.updateFare(sc.nextInt());
			adminMenu();
			break;
		case 5:
			System.out.println("Which room number do you want to delete?");
			adminDAO.deleteRoom(sc.nextInt());
			adminMenu();
			break;

		case 6:
			HostelBooking.main(null);
			break;
		default:
			System.out.println("Please select choice range 1-7 only");
		}

	}
	
	public static void userMenu() {
		System.out.println("---------------------");
		System.out.println("|    USER MENU      |");
		System.out.println("---------------------");
		System.out.println("| 1.VIEW ALL ROOMS  |");
		System.out.println("| 2.VIEW  ROOM      |");
		System.out.println("| 3.BOOK  ROOM      |");
		System.out.println("| 4.BACK            |");
		System.out.println("---------------------");
		System.out.println("Enter Your Choice ?");
		int choice = sc.nextInt();
		switch (choice) {

		case 1:
			List<Hostel> rooms = userDAO.viewAllrooms();
			System.out.println("ROOMNO"+"\t"+"ROOMTYPE"+"\t"+"ACNONAC"+"\t"+"ROOMFARE"+"\t"+"AVAILABILITY");
			System.out.println("---------------------------------------------------------------------");
			for (Hostel i : rooms) {
				System.out.println(i+"\t"+"\t"+"\t");

			}
			userMenu();
			break;
		case 2:
			System.out.println("Enter Room Number ?");
			Hostel room = userDAO.viewRoom(sc.nextInt());
			System.out.println("ROOMNO"+"\t"+"ROOMTYPE"+"\t"+"ACNONAC"+"\t"+"ROOMFARE"+"\t"+"AVAILABILITY");
			System.out
					.println("-----------------------------------------------------------------------");
			System.out.println(room+"\t"+"\t"+"\t");
			userMenu();
			break;
		case 3:
			System.out.println("Enter Room Number: ");
			userDAO.bookRoom(sc.nextInt());
			break;
		case 4:
			HostelBooking.main(null);
			break;
		default:
			System.out.println("Please select choice range 1-4 only");

		}
	}
	

}
