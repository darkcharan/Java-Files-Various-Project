package com.daoimpl;

import java.io.EOFException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.beans.SaveraDiagnoticTestBeans;
import com.beans.SaveraDoctorBeans;
import com.beans.SaveraPatientBeans;
import com.beans.SaveraReportsBeans;
import com.controller.SaveraHospitalManagement;
import com.dao.SaveraDao;

public class SaveraDaoimpl implements SaveraDao {
	static Scanner sc = new Scanner(System.in);
	int  testFee = 0;

	public void frontOffice() {

		System.out.println("*********************");
		System.out.println("Front Office Details");
		System.out.println("*********************");
		System.out.println("1.Patient Registration");
		System.out.println("2.New Appointment");
		System.out.println("3.Patient Query");
		System.out.println("4.patient details");
		System.out.println("Enter your choice");
		int ch = sc.nextInt();

		switch (ch) {
		case 1:
			System.out.println("1.New Patient Registration");
			System.out.println("2.Existing Patient Registration");
			
			System.out.println("Enter your choice ");
			int ch1 = sc.nextInt();
			if (ch1 == 1) {
				newPatientRegistration();

			} else if (ch1 == 2) {
				existingPatientRegistration();
			}
			break;
		case 2:
			bookAppointment();

			break;
		case 3:
			patientQuery();

			break;

		case 4:
			patientDetails();
			break;

		}
	}

	private void patientDetails() {

		FileInputStream fis12 = null;
		ObjectInputStream ois12 = null;
		try {
			fis12 = new FileInputStream("patient.ser");
			ois12 = new ObjectInputStream(fis12);

			while (true) {
				
				
				
				
				System.out.println(ois12.readObject());
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO: handle exception
		}

		frontOffice();
	}

	private void patientQuery() {

		System.out.println("*************************");
		System.out.println("     Patient Query       ");
		System.out.println("*************************");

		System.out.println("1.Patient ID");
		System.out.println("2.Patient Name");
		System.out.println("Enter your choice ");
		int choice=sc.nextInt();
		if(choice==1)
		{
			System.out.println("Enter Patient Id");
			String patientID=sc.next();
			searchByPatientId(patientID);
		}
		else 
		{
			System.out.println("Enter Patient Name");
			String patientName=sc.next();
			searchByPatientName(patientName);
		}







		/*FileInputStream fis = null;
		ObjectInputStream ois = null;
		// SaveraPatientBeans spb=null;

		try {
			fis = new FileInputStream("patient.ser");
			ois = new ObjectInputStream(fis);
			System.out.println("Enter patient id");
			String pid = sc.next();
			System.out.println("Enter patient Name");
			String pName = sc.next();
			System.out.println("Enter mobile Number");
			double mn = sc.nextDouble();
			System.out.println("Enter specialization name");
			String spName = sc.next();
			while (true) {




					// System.out.println(ois.readObject());

				SaveraPatientBeans spb = (SaveraPatientBeans) ois.readObject();

				if (spb.getPatientId().equals(pid)
						| spb.getPatientName().equals(pName)
						| spb.getMobileNumber() == mn) {
					System.out.println(spb.getPatientId() + "\t"
							+ spb.getPatientName() + "\t" + spb.getAddress()
							+ "\t" + spb.getMobileNumber());
					frontOffice();
				} else {
					System.out
					.println("The Patient Details are not Found......");
					break;

				}
			}
		}

		catch (EOFException e) {

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			fis.close();
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 */	


	}

	private void searchByPatientName(String patientName) {



		int count = 0;

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		SaveraPatientBeans spb = null;
		try {

			fis = new FileInputStream("patient.ser");
			ois = new ObjectInputStream(fis);

			while (true) {

				spb = (SaveraPatientBeans) ois.readObject();

				if (patientName.equals(spb.getPatientName()))

				{
					System.out.println("***************************");
					System.out.println("|     Patient Details      |");
					System.out.println("***************************");
					System.out.format("|Patient Id:              "
							+ spb.getPatientId() + "|\n");
					System.out.format("|Patient Name:        "
							+ spb.getPatientName() + "|\n");
					System.out.format("|Patient Age:            " + spb.getAge()
							+ "|\n");
					System.out.format("|Address:           " + spb.getAddress()
							+ "|\n");
					System.out.format("|MobileNo:      "
							+ spb.getMobileNumber() + "|\n");
					System.out.format("|Problem Description:"
							+ spb.getProblemDescription() + "|\n");
					System.out.println("**************************|");
					count++;
					break;

				}
			}

		} catch (EOFException e) {

		}

		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (count == 0) {
			System.out.println("Sorry Patient Details are not found!.....");

		}
		frontOffice();

	}

	private void searchByPatientId(String patientID) {



		int count = 0;

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		SaveraPatientBeans spb = null;
		try {

			fis = new FileInputStream("patient.ser");
			ois = new ObjectInputStream(fis);

			while (true) {

				spb = (SaveraPatientBeans) ois.readObject();

				if (patientID.equals(spb.getPatientId()))

				{
					System.out.println("***************************");
					System.out.println("|     Patient Details      |");
					System.out.println("***************************");
					System.out.format("|Patient Id:              "
							+ spb.getPatientId() + "|\n");
					System.out.format("|Patient Name:        "
							+ spb.getPatientName() + "|\n");
					System.out.format("|Patient Age:            " + spb.getAge()
							+ "|\n");
					System.out.format("|Address:           " + spb.getAddress()
							+ "|\n");
					System.out.format("|MobileNo:      "
							+ spb.getMobileNumber() + "|\n");
					System.out.format("|Problem Description:"
							+ spb.getProblemDescription() + "|\n");
					System.out.println("**************************|");
					count++;
					break;

				}
			}

		} catch (EOFException e) {

		}

		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (count == 0) {
			System.out.println("Sorry Patient Details are not found!.....");

		}
		frontOffice();

	}


	private void existingPatientRegistration() {

		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream("patient.ser");
			ois = new ObjectInputStream(fis);
			SaveraPatientBeans spb = null;
			System.out.println("Enter patient id");
			String pid = sc.next();
			System.out.println("Enter patient Name");
			String pName = sc.next();
			System.out.println("Enter mobile Number");
			double mn = sc.nextDouble();
			System.out.println("Enter specialization name");
			String spName = sc.next();
			while (true) {
				// System.out.println(ois.readObject());

				spb = (SaveraPatientBeans) ois.readObject();

				// System.out.println(ois.readObject());

				if (spb.getPatientId().equals(pid)
						| spb.getPatientName().equals(pName)
						| spb.getMobileNumber() == mn) {
					System.out.println(spb.getPatientId() + "\t"
							+ spb.getPatientName() + "\t" + spb.getAddress()
							+ "\t" + spb.getMobileNumber());
					frontOffice();
				} else {
					System.out
					.println("The Patient Details are not Found......");
					frontOffice();
				}
			}
		}

		catch (EOFException e) {

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			fis.close();
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void newPatientRegistration() {


		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		SaveraPatientBeans spb = null;

		String patientName="";
		String age;
		String gender;
		String mobileNumber;
		String address;
		String emailId;
		String problemDescription;

		int ch11 = 1;
		try {
			File f = new File("patient.ser");
			if(!f.exists())
			{
				
				Random generator = new Random();
				f.createNewFile();
				fos = new FileOutputStream(f);
				oos = new ObjectOutputStream(fos);


				while (ch11 == 1) {
					ArrayList al = new ArrayList();

					spb = new SaveraPatientBeans();

					/*
					 * System.out.println("Enter patient Id");
					 * spb.setPatientId(sc.next());
					 */

					int num = generator.nextInt(90000) + 10000;
					String pid = "SVRPT" + num;
					spb.setPatientId(pid);
					System.out.println("Patient Id: " + pid);

					System.out.println("Enter patient Name ");


					patientName = sc.next();
					while (!patientName.matches("[A-Z][a-zA-Z]*")) {
						System.err.println("Enter Patient Name Start with Capital Letter only characters!");
						patientName = sc.next();
					}



					System.out.println("Enter Age");
					//spb.setAge(sc.nextDouble());
					age=sc.next();
					while
						(!age.matches("^(([0-9][1-9])|([1-9][0-9])|[1-9])$")) {
						age = sc.next();
						System.err.println("Enter Age Between 1 to 99 ");

					}



					System.out.println("Enter Gender");
					spb.setGender(sc.next());
					/*gender=sc.next();

                while (!gender.matches("male")) {
                    System.err.println("Enter gender male/female or
Male/Female or F/M");
                    age = sc.next();
                }*/

					System.out.println("Enter mobile number");
					//spb.setMobileNumber(sc.nextLong());
					mobileNumber=sc.next();
					while (!mobileNumber.matches("\\d{10}")) {
						System.err.println("Enter 10 digit mobile number Only!");
						mobileNumber = sc.next();
					}


					System.out.println("Enter Address");
					spb.setAddress(sc.next());
					System.out.println("Enter Email Id");
					//spb.setEmailId(sc.next());
					emailId=sc.next();
					while
						(!emailId.matches("^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$"))
					{
						System.err.println("Enter Valid Email ID ");
						emailId = sc.next();
					}


					System.out.println("Enter problem description");
					spb.setProblemDescription(sc.next());

					System.out
					.println(" please pay registration fee of 300 Rs");
					String regFee = sc.next();
					
					
					if (regFee .equals("300")) {
						//spb.setPatientName(patientName);
						spb.setPatientName(patientName);
						spb.setEmailId(emailId);
						spb.setRegFee(regFee);



						System.out
						.println("************Savera Hospital***************");
						System.out
						.println("************Fee Receipt*******************");
						System.out
						.println("Received with thanks from Mr/Mrs "
								+ spb.getPatientName());
						System.out
						.println(" a sum of Rs. 300 /- towards consultation fee");

						System.out
						.println("Your Details are successfully saved..");

						spb.setAge(Integer.parseInt(age));
						//spb.setGender(gender);
						spb.setMobileNumber(Long.parseLong(mobileNumber));

						oos.writeObject(spb);

						System.out
						.println("Do you want register more patients press 1 else 0");

						ch11 = sc.nextInt();
					}
					/*else if(regFee<300)

					{
						System.out.println("Please pay "+(300-regFee));
						frontOffice();


					}*/

					if (ch11 == 0)

					{
						frontOffice();
					}

				}
				// oos.writeObject(al);
				frontOffice();
			}
			else
			{
				File temp = new File("tempreg.ser");
				temp.createNewFile();
				fis = new FileInputStream(f);
				ois = new ObjectInputStream(fis);

				fos = new FileOutputStream(temp);
				oos = new ObjectOutputStream(fos);
				try
				{
					while(true)
					{
						SaveraPatientBeans sp = (SaveraPatientBeans)
								ois.readObject();
						oos.writeObject(sp);

					}
				}

				catch (EOFException e) {

				}

				Random generator = new Random();
				while (ch11 == 1) {
					ArrayList al = new ArrayList();

					spb = new SaveraPatientBeans();

					/*
					 * System.out.println("Enter patient Id");
					 * spb.setPatientId(sc.next());
					 */

					int num = generator.nextInt(90000) + 10000;
					String pid = "SVRPT" + num;
					spb.setPatientId(pid);
					System.out.println("Patient Id: " + pid);

					System.out.println("Enter patient Name ");
					//spb.setPatientName(sc.next());


					patientName = sc.next();
					while (!patientName.matches("[A-Z][a-zA-Z]*")) {
						System.err.println("Enter Patient Name Start with Capital Letter only characters!");
						patientName = sc.next();
					}



					System.out.println("Enter Age");
					//spb.setAge(sc.nextDouble());
					age=sc.next();
					while
						(!age.matches("^(([0-9][1-9])|([1-9][0-9])|[1-9])$")) {
						System.err.println("Enter Age Between 1 to 99 ");
						age = sc.next();
					}



					System.out.println("Enter Gender");
					spb.setGender(sc.next());
					/*gender=sc.next();

                    while (!gender.matches("male")) {
                        System.err.println("Enter gender male/female
or Male/Female or F/M");
                        age = sc.next();
                    }*/

					System.out.println("Enter mobile number");
					//spb.setMobileNumber(sc.nextLong());
					mobileNumber=sc.next();
					while (!mobileNumber.matches("\\d{10}")) {
						System.err.println("Enter 10 digit mobile number Only!");
						mobileNumber = sc.next();
					}


					System.out.println("Enter Address");
					spb.setAddress(sc.next());
					System.out.println("Enter Email Id");
					//spb.setEmailId(sc.next());
					emailId=sc.next();
					while
						(!emailId.matches("^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$"))
					{
						System.err.println("Enter Valid Email ID ");
						emailId = sc.next();
					}


					System.out.println("Enter problem description");
					spb.setProblemDescription(sc.next());
					
					spb.setPatientName(patientName);
					spb.setEmailId(emailId);
					System.out
					.println(" please pay registration fee of 300 Rs");
					String regFee = sc.next();
					if (regFee.equals("300")) {
						//spb.setPatientName(patientName);
						
						
						spb.setRegFee(regFee);


						System.out
						.println("************Savera Hospital***************");
						System.out
						.println("************Fee Receipt*******************");
						System.out
						.println("Received with thanks from Mr/Mrs "
								+ spb.getPatientName());
						System.out
						.println(" a sum of Rs. 300 /- towards consultation fee");

						System.out
						.println("Your Details are successfully saved..");

						spb.setAge(Integer.parseInt(age));
						//spb.setGender(gender);
						spb.setMobileNumber(Long.parseLong(mobileNumber));

						oos.writeObject(spb);

						System.out
						.println("Do you want register more patients press 1 else 0");

						ch11 = sc.nextInt();
					}
				/*	else if(regFee<300)

					{
						System.out.println("Please pay "+(300-regFee));
						frontOffice();


					}*/

				

				}
				f.delete();
				temp.renameTo(f);
				// oos.writeObject(al);
			
				frontOffice();
			}

		}
		catch (IOException | ClassNotFoundException e) {
			// TODO: handle exception
		}


	}

	public void doctor() {

		System.out
		.println("1.Patient Prescription Details\n2.Diagnostic Test Details\n3.View Test");
		System.out.println("Enter your choice");
		int choice = sc.nextInt();
		if (choice == 1) {
			patientPrescriptionDetails();
		} else if (choice == 2) {
			diagnosticDetails();
		} else if (choice == 3) {
			viewAvailableTest();
		} else {
			System.out.println("Please enter right choice");
			doctor();
		}

	}

	private void viewAvailableTest() {

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("test.ser");
			ois = new ObjectInputStream(fis);

			while (true) {
				System.out.println(ois.readObject());
			}

		} catch (IOException | ClassNotFoundException e) {
			// e.printStackTrace();
		}
		doctor();
	}

	private void diagnosticDetails() {

		System.out.println("Enter patient Id");
		String pid = sc.next();

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		FileInputStream fis1 = null;
		ObjectInputStream ois1 = null;

		try {
			fis = new FileInputStream("patient.ser");
			ois = new ObjectInputStream(fis);

			fis1 = new FileInputStream("test.ser");
			ois1 = new ObjectInputStream(fis1);

			while (true) {

				SaveraPatientBeans spb = (SaveraPatientBeans) ois.readObject();

				if (spb.getPatientId().equals(pid)) {

					try {
						while (true)

						{
							System.out.println(ois1.readObject());

						}
					} catch (EOFException e) {

					}

					calculateTestFee();
					System.out
					.println("Do you want do any more Test press 1 else press 0");
					int press = sc.nextInt();
					if (press == 1) {
						calculateTestFee();
					} else {
						System.out.println("Total Fee:" + testFee);
						doctor();
					}
				}

			}

			/*
			 * if(sdb.getDiagnoticTestName().equals("MRI")) {
			 * testFee=testFee+500;
			 * 
			 * System.out.println("testFee is "+testFee);
			 * 
			 * 
			 * } if(sdb.getDiagnoticTestName().equals("LipidTest")) {
			 * testFee=testFee+500;
			 * 
			 * System.out.println("testFee is "+testFee); break;
			 * 
			 * }if(sdb.getDiagnoticTestName().equals("UltraSound")) {
			 * testFee=testFee+1500;
			 * 
			 * System.out.println("testFee is "+testFee); break;
			 * 
			 * }
			 */

		}

		catch (IOException | ClassNotFoundException e) {

		}

	}

	private void calculateTestFee() {

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("test.ser");
			ois = new ObjectInputStream(fis);

			SaveraDiagnoticTestBeans sdb = (SaveraDiagnoticTestBeans) ois
					.readObject();
			/*
			 * System.out.println("1."+sdb);
			 * System.out.println("2."+ois.readObject());
			 * System.out.println("3."+ois.readObject());
			 * System.out.println("4."+ois.readObject());
			 * System.out.println("5."+ois.readObject());
			 */
			while (true) {
				System.out.println("Enter the Test Name ");
				sdb.setDiagnoticTestName(sc.next());
				if (sdb.getDiagnoticTestName().equals("MRI")) {
					testFee = testFee + 500;
					System.out.println("Fees is: " + testFee);
				} else if (sdb.getDiagnoticTestName().equals("UltraSound")) {
					testFee = testFee + 1500;
					System.out.println("Fees is: " + testFee);
				} else if (sdb.getDiagnoticTestName().equals("UrineTest")) {
					testFee = testFee + 600;
					System.out.println("Fees is: " + testFee);
				} else if (sdb.getDiagnoticTestName().equals(
						"CompleteBloodTest")) {
					testFee = testFee + 2000;
					System.out.println("Fees is: " + testFee);
				} 
				System.out
				.println("Do you want do any more Test press 1 else press 0");
				int press = sc.nextInt();
				if (press == 0) {
					break;
				}
			}
			System.out.println("Total Fee:" + testFee);
			doctor();
		} catch (EOFException e) {

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}



	private void patientPrescriptionDetails() {

		System.out.println("Enter patient Id");
		String pid = sc.next();
		System.out.println("Enter patient Name");
		String pName = sc.next();
		System.out.println("Enter Mobile Number");
		long mNumber = sc.nextLong();

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		FileInputStream fis1 = null;
		ObjectInputStream ois1 = null;
		String problemDescription = "";
		
		try {
			fis = new FileInputStream("patient.ser");
			ois = new ObjectInputStream(fis);
			fis1 = new FileInputStream("doctor.ser");
			ois1 = new ObjectInputStream(fis1);

			while (true) {
				SaveraPatientBeans spb = (SaveraPatientBeans) ois.readObject();
				SaveraDoctorBeans sdb = (SaveraDoctorBeans) ois1.readObject();
				//System.out.println(ois.readObject());
				if (spb.getPatientId().equals(pid)
						| spb.getPatientName().equals(pName)
						| spb.getMobileNumber() == mNumber) {
					System.out.print(spb.getPatientId() + "\t"
							+ spb.getPatientName() + "\t" + spb.getAddress()
							+ "\t" + spb.getMobileNumber() + "\t"
							+ spb.getProblemDescription());
					problemDescription = spb.getProblemDescription();
				}

				if (problemDescription.equalsIgnoreCase("fever")
						| problemDescription.equalsIgnoreCase("heart")) {

					if (sdb.getSpecializationName().equals("Cardiology")) {
						System.out.print("\t" + sdb.getDoctorName());
						System.out.println();

						System.out.println("Enter Problem Prescription");
						String problemPrescription = sc.next();

						System.out.println("Hello Mr/Ms.\t"
								+ spb.getPatientName()
								+ "\tYour Prescription is\t"
								+ problemPrescription);

					}

				} else if (problemDescription.equalsIgnoreCase("eyesight")) {

					if (sdb.getSpecializationName().equals("Orthology")) {
						System.out.print("\t" + sdb.getDoctorName());
						System.out.println();

						System.out.println("Enter Problem Prescription");
						String problemPrescription = sc.next();

						System.out.println("Hello Mr/Ms.\t"
								+ spb.getPatientName()
								+ "\tYour Prescription is\t"
								+ problemPrescription);

					}

				} else if (problemDescription.equalsIgnoreCase("skinproblem")) {

					if (sdb.getSpecializationName().equals("Dermotology")) {
						System.out.print("\t" + sdb.getDoctorName());
						System.out.println();
						System.out.println("Enter Problem Prescription");
						String problemPrescription = sc.next();

						System.out.println("Hello Mr/Ms.\t"
								+ spb.getPatientName()
								+ "\tYour Prescription is\t"
								+ problemPrescription);

					}

				}
				if (problemDescription.equalsIgnoreCase("stomachpain")) {

					if (sdb.getSpecializationName().equals("Gynecology")) {
						System.out.print("\t" + sdb.getDoctorName());
						System.out.println();

						System.out.println("Enter Problem Prescription");
						String problemPrescription = sc.next();

						System.out.println("Hello Mr/Ms.\t"
								+ spb.getPatientName()
								+ "\tYour Prescription is\t"
								+ problemPrescription);

					}

				}

			}

		}
		catch (IOException | ClassNotFoundException e) {

		}
		doctor();

	}

	public void admin() {

		System.out.println("1.Diagnostics Test Maintenance");
		System.out.println("2.User Maintinance");
		System.out.println("3.Doctor Registration");
		System.out.println("4.View Doctor Details");
		System.out.println("Enter your choice ");
		int ch1 = sc.nextInt();

		/* while (true) { */
		if (ch1 == 1) {
			System.out.println("1.Insert Test");
			System.out.println("2.View Test");
			System.out.println("3.Delete Test");
			System.out.println("4.Update Test");
			System.out.println("5.Admin menu");
			System.out.println("6.Main menu");

			System.out.println("Enter your choice ");
			int ch2 = sc.nextInt();

			if (ch2 == 1) {

				insertTest();
			} else if (ch2 == 2) {
				viewTest();

			} else if (ch2 == 3) {
				deleteTest();
			} else if (ch2 == 4) {
				updateTest();

			} else if (ch2 == 5) {
				admin();
			} else {
				SaveraHospitalManagement.main(null);
			}
		}

		else if (ch1 == 2) {

			userMaintenance();

		}

		else if (ch1 == 3) {
			doctorRegistrationDetails();
		}
		else
		{
			viewDoctorDetails();
		}


			
	



		
		
		
	}

	private void viewDoctorDetails() {

		
		
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try
		{
			fis=new FileInputStream("doctor.ser");
			ois=new ObjectInputStream(fis);
			
			while(true)
			{
				System.out.println(ois.readObject());
			}
			
		}
		catch(IOException | ClassNotFoundException e)
		{
			
		}
		admin();
	}

	private void doctorRegistrationDetails() {

		
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		SaveraDoctorBeans sdb = null;
		// ArrayList al = new ArrayList();
		int choice = 1;
		String doctorName;
		String specializationName;
		String age="";
		String mobileNumber;
		String address;
		String emailId;
		String certificationDate;


		try {
			File temp = new File("tempreg.ser");
			File f = new File("doctor.ser");
			if(!f.exists())
			{
				f.createNewFile();
				fos = new FileOutputStream(f);
				oos = new ObjectOutputStream(fos);
				Random generator = new Random();

				while (choice == 1) {
					sdb = new SaveraDoctorBeans();

					System.out.println("Register Doctor Details");
					/*
					 * System.out.println("Enter Doctor Id");
					 * sdb.setDoctorId(sc.next());
					 */

					int num = generator.nextInt(90000) + 10000;
					String did = "SVRDR" + num;
					sdb.setDoctorId(did);
					System.out.println("Doctor Id: " + did);
					System.out.println("Enter Registration Number");
					sdb.setRegistrationNumber(sc.nextLong());
					System.out.println("Enter Doctor Name");
					//sdb.setDoctorName(sc.next());
					doctorName=sc.next();
					while (!doctorName.matches("[A-Z][a-zA-Z]*")) {
						System.err.println("Enter Doctor Name Start with Capital Letter");
						doctorName = sc.next();
					}







					System.out.println("Enter specialization");
					//sdb.setSpecializationName(sc.next());
					specializationName=sc.next();

					while (!specializationName.matches("[A-Z][a-zA-Z]*")) {
						System.err.println("Enter Specialization Name Start with Capital Letter");
						specializationName = sc.next();
					}

					System.out.println("Enter certification Date");
					//sdb.setCertificationDate(sc.next());
					certificationDate=sc.next();

					while
						(!certificationDate.matches("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$"))
					{
						System.err.println("Enter certification  date in the form of dd/mm/yyyy");
						certificationDate = sc.next();
					}

					System.out.println("Enter Age");
					//sdb.setAge(sc.nextInt());
					//    ^(([2-9][2-9])|([2-9][2-9])|[2-9])$

					while (!age.matches("[2-7][0-9]")) {
						age = sc.next();
						System.err.println("Enter Age Between 20 to 99");

					}

					System.out.println("Enter Gender");
					sdb.setGender(sc.next());
					System.out.println("Enter mobile Number");
					//sdb.setMobileNumber(sc.nextLong());
					mobileNumber=sc.next();

					while (!mobileNumber.matches("\\d{10}")) {
						System.err.println("Enter 10 digit mobile Number Only!");

						mobileNumber = sc.next();
					}

					System.out.println("Enter  Address");
					//sdb.setAddress(sc.next());
					address=sc.next();
					while (!address.matches("[A-Z][a-zA-Z]*")) {
						System.err.println("Enter Address Start with Capital Letter");

						address = sc.next();
					}


					System.out.println("Enter Email Id");
					//sdb.setEmailId(sc.next());

					emailId=sc.next();
					while
						(!emailId.matches("^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$"))
					{
						System.err.println("Enter Valid Email ID");
						emailId = sc.next();
					}

					System.out.println("Enter password");
					String password=sc.next();
					System.out.println(" Confirm Password");
					String confirmPassword=sc.next();

					/*System.out.println("Enter password");
					String password=(String) sdb.setPassword(sc.next());
					System.out.println("Confirm password");
					sdb.setConfirmPassWord(sc.next());*/
					if(password.equals(confirmPassword))
					{

						sdb.setDoctorName(doctorName);
						sdb.setSpecializationName(specializationName);
						sdb.setCertificationDate(certificationDate);
						sdb.setAge(Integer.parseInt(age));
						sdb.setMobileNumber(Long.parseLong(mobileNumber));
						sdb.setAddress(address);
						sdb.setEmailId(emailId);
						sdb.setPassword(password);
						sdb.setConfirmPassWord(confirmPassword);
						oos.writeObject(sdb);

						System.out
						.println("Do you want register More Doctor Details press 1 else 0");

						choice = sc.nextInt();
					}
					else 
					{
						System.out.println("OOPS!  Password and Confirm Password not matches!");
						
					}
				}
				admin();

			}

			else
			{

				temp.createNewFile();
				fis = new FileInputStream(f);
				ois = new ObjectInputStream(fis);

				fos = new FileOutputStream(temp);
				oos = new ObjectOutputStream(fos);
				try
				{
					while(true)
					{
						SaveraDoctorBeans sd =
								(SaveraDoctorBeans)ois.readObject();
						oos.writeObject(sd);

					}
				}

				catch (EOFException e) {

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Random generator = new Random();

				while (choice == 1) {
					sdb = new SaveraDoctorBeans();

					System.out.println("Register Doctor Details");
					/*
					 * System.out.println("Enter Doctor Id");
					 * sdb.setDoctorId(sc.next());
					 */

					int num = generator.nextInt(90000) + 10000;
					String did = "SVRDR" + num;
					sdb.setDoctorId(did);
					System.out.println("Doctor Id: " + did);
					System.out.println("Enter Registration Number");
					sdb.setRegistrationNumber(sc.nextLong());
					System.out.println("Enter Doctor Name");
					//sdb.setDoctorName(sc.next());
					doctorName=sc.next();
					while (!doctorName.matches("[A-Z][a-zA-Z]*")) {
						System.err.println("Enter Doctor Name Start with Capital Letter");

						doctorName = sc.next();
					}







					System.out.println("Enter specialization");
					//sdb.setSpecializationName(sc.next());
					specializationName=sc.next();

					while (!specializationName.matches("[A-Z][a-zA-Z]*")) {
						System.err.println("Enter Specialization Name Start with Capital Letter");

						specializationName = sc.next();
					}

					System.out.println("Enter certification Date");
					//sdb.setCertificationDate(sc.next());
					certificationDate=sc.next();

					while
						(!certificationDate.matches("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$"))
					{
						System.err.println("Enter certification date in the form of dd/mm/yyyy");

						certificationDate = sc.next();
					}

					System.out.println("Enter Age");
					//sdb.setAge(sc.nextInt());
					//    ^(([2-9][2-9])|([2-9][2-9])|[2-9])$

					while (!age.matches("[2-7][0-9]")) {
						System.err.println("Enter Age Between 20 to 99");
						age = sc.next();
					}

					System.out.println("Enter Gender");
					sdb.setGender(sc.next());
					System.out.println("Enter mobile Number");
					//sdb.setMobileNumber(sc.nextLong());
					mobileNumber=sc.next();

					while (!mobileNumber.matches("\\d{10}")) {
						System.err.println("Enter 10 digit mobile Number Only!");

						mobileNumber = sc.next();
					}

					System.out.println("Enter  Address");
					//sdb.setAddress(sc.next());
					address=sc.next();
					while (!address.matches("[A-Z][a-zA-Z]*")) {
						System.err.println("Enter Address Start with Capital Letter");

						address = sc.next();
					}


					System.out.println("Enter Email Id");
					//sdb.setEmailId(sc.next());

					emailId=sc.next();
					while
						(!emailId.matches("^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$"))
					{
						System.err.println("Enter Valid Email ID");
						emailId = sc.next();
					}

					System.out.println("Enter password");
					sdb.setPassword(sc.next());
					System.out.println("Confirm password");
					sdb.setConfirmPassWord(sc.next());
					sdb.setDoctorName(doctorName);
					sdb.setSpecializationName(specializationName);
					sdb.setCertificationDate(certificationDate);
					sdb.setAge(Integer.parseInt(age));
					sdb.setMobileNumber(Long.parseLong(mobileNumber));
					sdb.setAddress(address);
					sdb.setEmailId(emailId);
					oos.writeObject(sdb);
					f.delete();
					temp.renameTo(f);

					System.out
					.println("Do you want register More Doctor Details press 1 else 0");

					choice = sc.nextInt();
				}
				admin();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	private void userMaintenance() {

		System.out.println("Enter doctor  id"
				);
		String did = sc.next();

		System.out.println("1.Search");
		System.out.println("2.Update");
		System.out.println("3.Delete");
		System.out.println("Enter your choice ");
		int ch = sc.nextInt();
		if (ch == 1) {
			searchDoctor(did);

		} else if (ch == 2) {
			updateDoctor(did);

		} else if (ch == 3) {

			deleteDoctor(did);

		} else
			System.out.println("Please enter right choice");
	}

	private void deleteDoctor(String did) {

		File f = null;
		File temp = null;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			f = new File("doctor.ser");
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			temp = new File("Temp.ser");
			temp.createNewFile();
			fos = new FileOutputStream(temp);
			oos = new ObjectOutputStream(fos);

			while (true) {

				SaveraDoctorBeans b = (SaveraDoctorBeans) ois.readObject();

				if (!did.equals(b.getDoctorId())) {
					oos.writeObject(b);

				}

			}

		} catch (EOFException e) {

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(f.delete());
		System.out.println(temp.renameTo(f));
		admin();
	}

	private void updateDoctor(String did) {

		System.out.println("1.Doctor Name");
		System.out.println("2.Mobile Number");
		// System.out.println("3.New PassWord");
		System.out.println("Enter your choice ");
		int k = sc.nextInt();

		if (k == 1) {

			updateDoctorName(did);
		}
		if (k == 2) {

			updateDoctorMobileNumber(did);

		}
	}

	private void updateDoctorMobileNumber(String did) {

		System.out.println("Enter new doctor MobileNumber");
		long newMNumber = sc.nextLong();

		// Scanner sc = new Scanner(System.in);

		// System.out.println("Enter new specia");
		File f = null;
		File temp = null;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			f = new File("doctor.ser");
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			temp = new File("Temp.ser");
			temp.createNewFile();
			fos = new FileOutputStream(temp);
			oos = new ObjectOutputStream(fos);

			while (true) {

				SaveraDoctorBeans b = (SaveraDoctorBeans) ois.readObject();
				// System.out.println(ois.readObject());

				if (did.equals(b.getDoctorId())) {

					b.setMobileNumber(newMNumber);
					// oos.writeObject(b);

				}

				oos.writeObject(b);
			}

		} catch (EOFException e) {

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		f.delete();
		temp.renameTo(f);
		admin();
	}

	private void updateDoctorName(String did) {

		System.out.println("Enter new doctor Name");
		String newDName = sc.next();

		File f = null;
		File temp = null;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			f = new File("doctor.ser");
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			temp = new File("Temp.ser");
			temp.createNewFile();
			fos = new FileOutputStream(temp);
			oos = new ObjectOutputStream(fos);

			while (true) {

				SaveraDoctorBeans b = (SaveraDoctorBeans) ois.readObject();

				if (did.equals(b.getDoctorId())) {

					b.setDoctorName(newDName);
					// oos.writeObject(b);

				}

				oos.writeObject(b);
			}

		} catch (EOFException e) {

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(f.delete());
		System.out.println(temp.renameTo(f));
		admin();

	}

	private void searchDoctor(String did) {
		int count = 0;

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		SaveraDoctorBeans sdb = null;
		try {

			fis = new FileInputStream("doctor.ser");
			ois = new ObjectInputStream(fis);

			while (true) {

				sdb = (SaveraDoctorBeans) ois.readObject();

				if (did.equals(sdb.getDoctorId()))

				{
					System.out.println("***************************");
					System.out.println("|     Doctor Details      |");
					System.out.println("***************************");
					System.out.format("|Doctor Id:              "
							+ sdb.getDoctorId() + "|\n");
					System.out.format("|Reg No:               "
							+ sdb.getRegistrationNumber() + "|\n");
					System.out.format("|Doctor Name:        "
							+ sdb.getDoctorName() + "|\n");
					System.out.format("|Specialization:"
							+ sdb.getSpecializationName() + "|\n");
					System.out.format("|Doctor Age:            " + sdb.getAge()
							+ "|\n");
					System.out.format("|Address:           " + sdb.getAddress()
							+ "|\n");
					System.out.format("|MobileNo:      "
							+ sdb.getMobileNumber() + "|\n");
					System.out.println("**************************|");
					count++;
					break;

				}
			}

		} catch (EOFException e) {

		}

		catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		if (count == 0) {
			System.out.println("Sorry Doctor Details are not found!.....");

		}
		admin();

	}

	private void viewTest() {

		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("test.ser");
			ois = new ObjectInputStream(fis);

			while (true) {
				System.out.println(ois.readObject());
			}

		} catch (IOException | ClassNotFoundException e) {
			// e.printStackTrace();
		}
		admin();
	}

	private void updateTest() {

		System.out.println("Enter Test Name  to update");
		String testName = sc.next();

		System.out.println("Enter new Test cost");
		double testCost = sc.nextDouble();

		Scanner sc = new Scanner(System.in);

		// System.out.println("Enter new specia");
		File f = null;
		File temp = null;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			f = new File("test.ser");
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			temp = new File("Temp.ser");
			temp.createNewFile();
			fos = new FileOutputStream(temp);
			oos = new ObjectOutputStream(fos);

			while (true) {

				SaveraDiagnoticTestBeans b = (SaveraDiagnoticTestBeans) ois
						.readObject();
				// System.out.println(ois.readObject());

				if (testName.equals(b.getDiagnoticTestName())) {

					b.setDiagnoticTestCost(testCost);
					// oos.writeObject(b);

				}

				oos.writeObject(b);
			}

		} catch (EOFException e) {

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		f.delete();
		temp.renameTo(f);
		admin();

	}

	private void deleteTest() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Test Name to delete");
		String bid = sc.next();

		File f = null;
		File temp = null;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			f = new File("test.ser");
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			temp = new File("Temp.ser");
			temp.createNewFile();
			fos = new FileOutputStream(temp);
			oos = new ObjectOutputStream(fos);

			while (true) {

				SaveraDiagnoticTestBeans b = (SaveraDiagnoticTestBeans) ois
						.readObject();

				if (!bid.equals(b.getDiagnoticTestName())) {
					oos.writeObject(b);

				}

			}

		} catch (EOFException e) {

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		f.delete();
		temp.renameTo(f);
		admin();

	}

	private void insertTest() {

		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {

			fos = new FileOutputStream("test.ser");
			oos = new ObjectOutputStream(fos);
			ArrayList al = null;
			SaveraDiagnoticTestBeans sdb = null;

			int ch = 1;
			while (ch == 1) {
				// al = new ArrayList();
				sdb = new SaveraDiagnoticTestBeans();

				System.out.println("Enter Diagnotic Test Name");
				sdb.setDiagnoticTestName(sc.next());
				System.out.println("Enter Diagnotic Test Cost");
				sdb.setDiagnoticTestCost(sc.nextDouble());
				System.out.println("Enter specialization");
				sdb.setSpecialization(sc.next());

				oos.writeObject(sdb);
				System.out
				.println("Do you want to insert more tests press 1 else 0");
				ch = sc.nextInt();
			}

			// oos.writeObject(al);

		} catch (IOException e) {

		}
		admin();

	}

	public void reports() {




		System.out.println("================================");
		System.out.println("|   Welcome To Report Section  |");
		System.out.println("================================");
		System.out.println("|    1.Specialization Report   |");
		System.out.println("|    2.Fee Report              |");
		System.out.println("|    3.Patients Report         |");
		System.out.println("================================");
		System.out.println("Enter your choice ");
		int ch=sc.nextInt();
		switch(ch){
		case 1:	specializationReport();
		break;
		case 2:	feeReport();
		break;

		case 3:	patientsReport();
		break;
		}
	}
	private void patientsReport() {


		System.out.println("Enter From Date(dd/mm/yyyy)");
		String fromDate=sc.next();
		System.out.println("Enter To Date(dd/mm/yyyy)");
		String toDate=sc.next();
		FileInputStream fis=null;
		ObjectInputStream ois=null;

		try
		{

			fis=new FileInputStream("appointmentReports.ser");
			ois=new ObjectInputStream(fis);


			while(true)
			{
	/*	SaveraReportsBeans srb=(SaveraReportsBeans)ois.readObject();
		//System.out.println(srb.getDate()+"\t"+srb.getPatientName()+"\t"+srb.getDoctorName()+"\t"+srb.getSpecialization()+"\t"+srb.getAmountFee());
			 
				//System.out.println(ois.readObject());
*/	
			System.out.println(ois.readObject());	
			}
		}
		catch(IOException | ClassNotFoundException e)
		{

		}
		reports();

	}

	private void feeReport() {

		System.out.println("Enter From Date(dd/mm/yyyy)");
		String fromDate=sc.next();
		System.out.println("Enter To Date(dd/mm/yyyy)");
		String toDate=sc.next();
		FileInputStream fis=null;
		ObjectInputStream ois=null;

		try
		{

			fis=new FileInputStream("appointmentReports.ser");
			ois=new ObjectInputStream(fis);


			while(true)
			{
		SaveraReportsBeans srb=(SaveraReportsBeans)ois.readObject();
		System.out.println(srb.getDate()+"\t"+srb.getPatientName()+"\t"+srb.getDoctorName()+"\t"+srb.getSpecialization()+"\t"+srb.getAmountFee());
			 
				//System.out.println(ois.readObject());
			}
		}
		catch(IOException | ClassNotFoundException e)
		{

		}
		reports();
		

	}

	public void specializationReport() {

		System.out.println("1.Cardiology");
		System.out.println("2.Orthology");
		System.out.println("3.Dermotology");
		System.out.println("4.Gynecology");
		System.out.println("Enter your choice");
		int ch=sc.nextInt();
		String specialization="";
		if(ch==1)
		{

			specialization="Cardiology";
		}
		else if(ch==2)
		{
			specialization="Orthology";
		}
		else if(ch==3)
		{
			specialization="Dermotology";
		}
		else
		{
			specialization="Gynecology";
		}



		System.out.println("Enter From Date(dd/mm/yyyy)");
		String fromDate=sc.next();
		System.out.println("Enter To Date(dd/mm/yyyy)");
		String toDate=sc.next();
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try
		{
			fis=new FileInputStream("appointmentReports.ser");
			ois=new ObjectInputStream(fis);
			while(true)
			{
				SaveraReportsBeans srb=(SaveraReportsBeans)ois.readObject();
				/*if(srb.getSpecialization().equalsIgnoreCase(specialization))
		{*/
				System.out.println("****************************");
				System.out.println("  Specialization Report     ");
				System.out.println("****************************");
				System.out.println("Specialization Name\tPatient Name\t AppointmentDate\t AppointmentTime");
				System.out.println(specialization+"\t"+srb.getPatientName()+"\t"+srb.getDate()+"\t"+srb.getTime());
				break;
			}

		}
		catch(IOException | ClassNotFoundException e)
		{


		}
		reports();
		



	}

	/*public void getReport() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("C:\\Users\\hp\\workspace\\Abhi\\patientDetails.ser");
			ois = new ObjectInputStream(fis);
			while(true){
			System.out.println("Enter the From Date: ");
			String fromDate = sc.next();
			System.out.println("Enter the to date: ");
			String toDate = sc.next();
			SaveraPatientBeans spb=(SaveraPatientBeans)ois.readObject();
			System.out.println("Patient Name: "+spb.getPatientName()+"\nAppointment  Date: "+spb.getDate()+"\nAppointment Time: "+spb.getTime());
			String givenDate = spb.getDate();
			String pattern = "dd-MM-yyyy";
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			try {
				Date from = format.parse(fromDate);
				Date to = format.parse(toDate);
				Date given = format.parse(givenDate);

				if(given.after(from) && given.before(to)){
					System.out.println("Given date is in the interval");
					return;
				}
			System.out.println("Given date is not in the interval");
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public void feeReport() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		FileInputStream fis1 = null;
		ObjectInputStream ois1 = null;

		try {
			fis = new FileInputStream("appointmentReports.ser");
			ois = new ObjectInputStream(fis);
			fis1 = new FileInputStream("C:\\Users\\hp\\workspace\\Abhi\\patient.ser");
			ois1 = new ObjectInputStream(fis1);
			while(true){
				System.out.println("Enter the From Date: ");
				String fromDate = sc.next();
				System.out.println("Enter the to date: ");
				String toDate = sc.next();
				System.out.println("1.All            ");
				System.out.println("2.Doctor         ");
				System.out.println("3.Specialization ");
				System.out.println("Enter the type of report you want ");
				String type=sc.next();
				SaveraPatientBeans spb=(SaveraPatientBeans) ois.readObject();
				SaveraDoctorBeans sdb=(SaveraDoctorBeans)ois1.readObject();
				String specialization=null;
				if(specialization.equals("Cardiology")){
					SpecializationId=1;
				}if(specialization.equals("Endocrinology")){
					SpecializationId=2;
				}if(specialization.equals("Dermatalogy")){
					SpecializationId=3;
				}if(specialization.equals("Gynecology")){
					SpecializationId=4;
				}if(specialization.equals("Surgeon")){
					SpecializationId=5;
				}
				if(type.equals("All")){
							System.out.println("Appointment Date: "+spb.getDate()+"\nPatient Name: "+spb.getPatientName()+"\nDoctor Name: "+sdb.getDoctorName()+"\nSpecialization Name: "+sdb.getSpecializationName()+"\nAmount Paid: "+spb.getRegFee());
				} else if(type.equals("Doctor")){
					System.out.println("Doctor Name: "+sdb.getDoctorName()+"\nPatient Name "+spb.getPatientName()+"\nSpecialization Name: "+sdb.getSpecializationName()+"\nAppointment Date: "+spb.getDate()+"\nAmount Collected: "+fees);
				}else if(type.equals("Specialization")){
					System.out.println("\nSpecialization Id: "+SpecializationId+"\nSpecialization Name: "+sdb.getSpecializationName()+"\nPatient Name: "+spb.getPatientName()+"\nAppointment Date: "+spb.getDate()+"\nAmount Collected: "+fees);
				}
				String givenDate = spb.getDate();
				String pattern = "dd-MM-yyyy";
				SimpleDateFormat format = new SimpleDateFormat(pattern);

				try {
					Date from = format.parse(fromDate);
					Date to = format.parse(toDate);
					Date given = format.parse(givenDate);

					if(given.after(from) && given.before(to)){
						System.out.println("Given date is in the interval");
						return;
					}
				System.out.println("Given date is not in the interval");
				} catch (ParseException e) {
					e.printStackTrace();
				}

			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	public void patientsReport() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		FileInputStream fis1 = null;
		ObjectInputStream ois1 = null;

		try {
			fis = new FileInputStream("C:\\Users\\hp\\workspace\\Abhi\\patientDetails.ser");
			ois = new ObjectInputStream(fis);
			fis1 = new FileInputStream("C:\\Users\\hp\\workspace\\Abhi\\patient.ser");
			ois1 = new ObjectInputStream(fis1);
			while(true){
				System.out.println("Enter the From Date: ");
				String fromDate = sc.next();
				System.out.println("Enter the to date: ");
				String toDate = sc.next();
				SaveraPatientBeans spb=(SaveraPatientBeans) ois.readObject();
				SaveraDoctorBeans sdb=(SaveraDoctorBeans)ois1.readObject();
				System.out.println("Patient Name: "+spb.getPatientName()+"Specialization Name: "+sdb.getSpecializationName()+"Appointment Date: "+spb.getDate());
				String givenDate = spb.getDate();
				String pattern = "dd-MM-yyyy";
				SimpleDateFormat format = new SimpleDateFormat(pattern);

				try {
					Date from = format.parse(fromDate);
					Date to = format.parse(toDate);
					Date given = format.parse(givenDate);

					if(given.after(from) && given.before(to)){
						System.out.println("Given date is in the interval");
						return;
					}
				System.out.println("Given date is not in the interval");
				} catch (ParseException e) {
					e.printStackTrace();
				}

			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}finally{

		}
	}
}		
	 */	










	public void bookAppointment() {
		
		System.out.println("New Appointment");

		System.out.println("Enter patient Id");
		String patientId = sc.next();
		String appointmentDate = "";

		System.out.println("Select  specialization");
		System.out.println("1.Cardiology");
		System.out.println("2.Orthology");
		System.out.println("3.Dermotology");
		System.out.println("4.Gynecology");
		int choice = sc.nextInt();
		String specialization = null;

		if (choice == 1) {
			specialization = "Cardiology";

		} else if (choice == 2) {
			specialization = "Orthology";

		} else if (choice == 3) {
			specialization = "Dermotology";

		} else if (choice == 4) {
			specialization = "Gynecology";

		}

		String time = "";
		FileInputStream fis1 = null;
		ObjectInputStream ois1 = null;
		FileInputStream fis2 = null;
		ObjectInputStream ois2 = null;
		SaveraDoctorBeans sdb=null;
		try {

			fis1 = new FileInputStream("doctor.ser");
			ois1 = new ObjectInputStream(fis1);
			while (true) {
				 sdb = (SaveraDoctorBeans) ois1.readObject();

				if (sdb.getSpecializationName().equalsIgnoreCase(specialization)) {

					System.out.println("Doctor Name \t specialization");
					System.out.println(sdb.getDoctorName() + "\t"
							+ sdb.getSpecializationName());

					System.out.println("Enter Date");
					appointmentDate = sc.next();
					System.out.println("Appointment Time");

					System.out.println("1.9AM to 10AM");
					System.out.println("2.10AM to 11AM");
					System.out.println("3.11AM to 12PM");
					System.out.println("4.12PM to 1PM");
					System.out.println("5.2PM to 3PM");
					System.out.println("6.3PM to 4PM");
					System.out.println("7.4PM to 5PM");
					System.out.println("Enter your choice ");
					int chTime = sc.nextInt();

					if (chTime == 1) {
						time = "9AM to 10AM";
					}
					if (chTime == 2) {
						time = "10AM to 11AM";
					}
					if (chTime == 3) {
						time = "11AM to 12PM";
					}
					if (chTime == 4) {
						time = "12PM to 1PM";
					}
					if (chTime == 5) {
						time = "2PM to 3PM";
					}

					if (chTime == 6) {
						time = "3PM to 4PM";
					}

					if (chTime == 7) {
						time = "4PM to 5PM";
					}


				}

			}
		} catch (Exception e) {

		}
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		FileInputStream fis11 = null;
		ObjectInputStream ois11 = null;
		
		try {
			fis = new FileInputStream("patient.ser");
			ois = new ObjectInputStream(fis);
			fis1=new FileInputStream("doctor.ser");
			ois1=new ObjectInputStream(fis1);
			
			fos=new FileOutputStream("appointmentReports.ser");
			oos=new ObjectOutputStream(fos);
			while (true) {

				SaveraPatientBeans spb = (SaveraPatientBeans) ois.readObject();
				//SaveraDoctorBeans sdb = (SaveraDoctorBeans) ois.readObject();

				if(spb.getPatientId().equals(patientId))
				{
					
					System.out.println(spb.getPatientId() + "\t"+spb.getPatientName());

					System.out.println("Hello Mr/Ms \t" + spb.getPatientName()
							+ "\n your slot is booked in " + appointmentDate
							+ " at\t" + time);


					int ch11 = 1;
					try {
						File temp = new File("tempReports.ser");
						File f = new File("appointmentReports.ser");
						if(!f.exists())
						{

							f.createNewFile();
							fos = new FileOutputStream(f);
							oos = new ObjectOutputStream(fos);



							ArrayList al = new ArrayList();

							SaveraReportsBeans srb=new SaveraReportsBeans();
							String  patientId1=spb.getPatientId();
							String patientName=spb.getPatientName();
							String doctorName=sdb.getDoctorName();
							String specializationName=sdb.getSpecializationName();
							String date=appointmentDate;
							String time1=time;

							String amountFee=spb.getRegFee();

							

							
							if(spb.getProblemDescription().equalsIgnoreCase("fever"))
							{
								amountFee="300";
							}
							if(spb.getProblemDescription().equalsIgnoreCase("eyesight"))
							{
								amountFee="300";
							}
							if(spb.getProblemDescription().equalsIgnoreCase("stomachpain"))
							{
								amountFee="500";
							}
							if(spb.getProblemDescription().equalsIgnoreCase("heartproblem"))
							{
								amountFee="1000";
							}
							srb.setPatientID(patientId1);
							srb.setPatientName(patientName);
							srb.setDoctorName(doctorName);
							srb.setSpecialization(specializationName);
							srb.setDate(date);
							srb.setTime(time1);
							srb.setAmountFee(amountFee);
							oos.writeObject(srb);

							oos.writeObject(srb);



							frontOffice();
						}

						else
						{


							temp.createNewFile();
							fis = new FileInputStream(f);
							ois = new ObjectInputStream(fis);

							fos = new FileOutputStream(temp);
							oos = new ObjectOutputStream(fos);
							try
							{
								while(true)
								{
									SaveraReportsBeans sp = (SaveraReportsBeans)
											ois.readObject();
									oos.writeObject(sp);

								}
							}

							catch (EOFException e) {

							}


							ArrayList al = new ArrayList();

							SaveraReportsBeans srb=new SaveraReportsBeans();
							SaveraDoctorBeans sdb1=new SaveraDoctorBeans();
							String patientId1=spb.getPatientId();
							String patientName=spb.getPatientName();
							String doctorName=sdb.getDoctorName();
							String specializationName=sdb.getSpecializationName();
							String date=appointmentDate;
							String time1=time;
							String  amountFee = null;

							//String amountFee=fee;



							if(spb.getProblemDescription().equalsIgnoreCase("fever"))
							{
								amountFee="300";
							}
							if(spb.getProblemDescription().equalsIgnoreCase("eyesight"))
							{
								amountFee="300";
							}
							if(spb.getProblemDescription().equalsIgnoreCase("stomachpain"))
							{
								amountFee="500";
							}
							if(spb.getProblemDescription().equalsIgnoreCase("heartproblem"))
							{
								amountFee="1000";
							}
							srb.setPatientID(patientId1);
							srb.setPatientName(patientName);
							srb.setDoctorName(doctorName);
							srb.setSpecialization(specializationName);
							srb.setDate(date);
							srb.setTime(time1);
							srb.setAmountFee(amountFee);
							oos.writeObject(srb);
							
							
							

							f.delete();
							temp.renameTo(f);
							// oos.writeObject(al);
						
							frontOffice();


						}
					}

					catch (IOException e) {

					}

				}
			
			}
		}
		catch(IOException e)
		{

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}


