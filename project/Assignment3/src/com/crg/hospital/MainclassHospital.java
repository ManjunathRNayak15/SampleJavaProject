package com.crg.hospital;
import java.util.Scanner;
/*
 * Main class to Start the Application
 */
public class MainclassHospital {
	static Scanner scanInput = new Scanner(System.in);
	/*
	 * Main method
	 */
	public static void main(String[] args) {
		start();
	}
	/*
	 * Method which gives Option for the User
	 */
	static void start() {
		Hospital hospital = new Hospital();
		Receptionist receptionist = new Receptionist();
		int loopBreaker = 1;
		String hospId;
		goback:do {
			System.out.println("Choose Options");
			System.out.println("1..Staff\t2.Administrator\t3.Exit");
			String choice = scanInput.next();
			switch(choice) {
			case "1":
				loopBreaker=2;
				System.out.println("Receptionist/Doctor");
				hospId = hospital.addHospital(choice);
				receptionist.patientsRecords(hospId);
				break;
			case "2":loopBreaker=2;
				boolean b = adminAuth();
				if(b)
				hospital.addHospital(choice);
				else
					System.out.println("Inavlid UserName or Password\n");
					adminAuth();
				break;
			case "3":loopBreaker=2;
			System.out.println("\t\t\t********THANK YOU**********");
			System.exit(1);
				break;
			default : System.out.println("Inavlid Input");
				continue goback;
			}
		}while(loopBreaker==1);
	}
	/*
	 * method to validate the Administrator
	 */
	private static boolean adminAuth() {
		System.out.print("Enter Admin UserName : ");
		String adminName = scanInput.next();
		System.out.print("\nEnter the Password : ");
		String adminPassword = scanInput.next();
		if(adminName.equalsIgnoreCase("Guru")&&adminPassword.equals("1234")) {
			return true;
		}
		return false;
	}
}
