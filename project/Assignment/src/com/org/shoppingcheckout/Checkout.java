package com.org.shoppingcheckout;
/*
 * class to amount calculations and give access to shop again.
 */
import java.util.HashMap;
import java.util.Scanner;

public class Checkout {
	static double cost = 0;
	public static void calculate(Products p1,String choice) {
		/*
		 * calculate the total amount inclusive of all tax.
		 */
		cost = cost + p1.price;
		System.out.print("Products cost : "+cost);
		double tax =cost*14/100;
		System.out.print("\nTotal Tax :"+tax);
		cost  = cost + tax;
		System.out.print("\nTotal Amount to be Paid :"+cost+"\n");
		if(choice.equals("1")) {
		cost = 0;
		}
	}

	public static void amount(Products p1,HashMap<?, ?> hm) {
		/*
		 * give options for proceed to check out or update cart
		 */
		@SuppressWarnings("resource")
		Scanner sc  = new Scanner(System.in);
		System.out.println("1.Proceed To CheckOut\n2.Update Cart");
		String choice = sc.next();
		if(choice.equals("1")||choice.equals("2")) {
			calculate(p1,choice);
		}
		if(choice.equals("1")) {
			payThrough();
		}else if(choice.equals("2")) {
			Products.shopProducts(1);
		}else {
			System.out.println("Invalid Input");
			amount(p1,hm);
		}
	}
	public static void payThrough(){
		/*
		 * check payment option and if cash on delivery process it through.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("0.credit payment\n1.cash on delivery\n2.Exit");
		String t = sc.next();
		if(t.equals("0")) {
			System.out.println("Enter the credit card details");
			Card.cardInsert();
		}else if(t.equals("1")) {
			System.out.println("\t Cash on Delivery Mode Accepted \n \t Delivery to be Expected within 4 Days\n");
			System.out.println("Enter 1 to Continue Shopping \n 2 to Sign out \n Else any to exit");
			String choice = sc.next();
			if(choice.equals("1")) {
				Products.shopProducts(1);
			}else if(choice.equals("2")){
				LoginSignup ls = new LoginSignup();
				ls.userAdmin();
			}else {
			System.out.println("\t\t**********THANK YOU************");
			}
		}else if(t.equals("2")){
			LoginSignup ls = new LoginSignup();
			ls.userAdmin();
		}else {
			payThrough();
		}
		sc.close();
	}

}
