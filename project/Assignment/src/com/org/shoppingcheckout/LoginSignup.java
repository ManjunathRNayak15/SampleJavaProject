package com.org.shoppingcheckout;
/*
 * this class is to add customer info and check user login/signup and authenticate user and give access to shop products
 */
import java.util.HashMap;
import java.util.Scanner;

public class LoginSignup {
	 HashMap<String,CustomerMainclass> hm = new HashMap<String,CustomerMainclass>();
	 Scanner sc = new Scanner(System.in);
	 String choice;
	 String name,password;
	 
	 void addCustomer() {
		 /*
		  * add customers to database
		  */
			hm.put("akash@gmail.com",new CustomerMainclass("akash","1","mysuru"));
			hm.put("ajith@gmail.com",new CustomerMainclass("ajith","2","banglore"));
			hm.put("bharath@gmail.com",new CustomerMainclass("bharath","3","manglore"));
			hm.put("chandru@gmail.com",new CustomerMainclass("chandru","4","belgum"));
	 }
	 void userAdmin() {
		 /*
		  * give option for user or admin login
		  */
		 System.out.println(" \t\t******Choose Option******\t\n ");
			System.out.println("1.User\t2.Admin\t3.Exit");
			choice = sc.next();
			if (choice.equals("1")) {
				signInsignUP();
			}else if (choice.equals("2")) {
				System.out.println("Enter the Following Details");
				System.out.println("Admin ID : \t");
				name = sc.next();
				System.out.println("Password : \t");
				password = sc.next();
				adminAuth(name,password);
			}else if (choice.equals("3")) {
				sc.close();
			}else{
				System.out.println("Invalid Option");
				userAdmin();
			}
	 }
	 private void adminAuth(String name2, String password2) {
		 /*
		  * to authenticate admin details and give access
		  */
		if(name2.equalsIgnoreCase("manju") && password2.equals("root")) {
			System.out.println("1.Add Product");
			System.out.println("2.Exit");
			LoginSignup ls = new LoginSignup();
			choice = sc.next();
			if(choice.equals("1")) {
				Products.shopProducts(2);
			}else if(choice.equals("2")) {
				ls.userAdmin();
			}else {
			System.out.println("\t\tInvalid Input");
			adminAuth(name2,password2);
			}
		}else {
			System.out.println("Admin Name or Password Incorrect");
			userAdmin();
		}
	}
	void signInsignUP() {
		/*
		 * give option for sign in or sign up. if sign take the input details of customer.
		 */
		System.out.println(" \t\t******Choose Option******\t\n ");
		System.out.println("1.SignIn\t2.SignUp\t3.Exit");
		choice = sc.next();
			if (choice.equals("1")) {
				System.out.println("Enter The Email ID\t");
				String email = sc.next();
				System.out.println("Enter The Password");
				password = sc.next();
				signInCheck(email,password);
			}else if (choice.equals("2")) {
				System.out.println("Enter the Following Details");
				System.out.println("EmailID : \t");
				String email = sc.next();
				System.out.println("Name : \t");
				name = sc.next();
				System.out.println("Password : \t");
				password = sc.next();
				System.out.println("Address : \t");
				String address = sc.next();
				hm.put(email,new CustomerMainclass(name,password,address));
				signInsignUP();
			}else if(choice.equals("3")){
				LoginSignup ls = new LoginSignup();
				ls.userAdmin();
			}else {
				System.out.println("Invalid Option");
				signInsignUP();
			}
	}
	private  void signInCheck(String email, String password) {
		/*
		 * to validate the customer info and give access for shopping
		 */
		LoginSignup ls = new LoginSignup();
		CustomerMainclass c = hm.get(email);
		if(hm.containsKey(email)) {
			if(password.equals(c.password)){
				Products.shopProducts(1);
			}
		}else {
			System.out.println("\t\tInvalid Email or Password \n");
			ls.signInsignUP();
		}
	}
}
