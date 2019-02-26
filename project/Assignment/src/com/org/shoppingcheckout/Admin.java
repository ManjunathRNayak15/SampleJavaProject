package com.org.shoppingcheckout;
/*
 * This class is to give Admin authorization to add Products.
 */
import java.util.HashMap;
import java.util.Scanner;

public class Admin {
	/*
	 * This method to add the Product details
	 */
	static Scanner sc = new Scanner(System.in);
	
	public static void addProduct(HashMap<String, Products> hm) {
		System.out.println("Enter the Following Details...");
		System.out.println("Enter Product Key");
		String pkey = sc.next();
		System.out.println("Enter Product Name");
		String pName = sc.next();
		System.out.println("Enter Product Price");
		double price = sc.nextDouble();
		System.out.println("Enter Product model");
		String model = sc.next();
		hm.put(pkey, new Products(pName,price,model));
		System.out.println("Product added Successfully\n");
		addagain(hm);
	}
	static void addagain(HashMap<String,Products> hm) {
		/*
		 * this method is to verify to add product or exit
		 */
		System.out.println("1.Add Product\n2.Exit");
		String choice = sc.next();
		if(choice.equals("1")) {
			addProduct(hm);
		}
		else if(choice.equals("2")) {
			System.out.println("\t\t**********THANK YOU************");
			LoginSignup ls = new LoginSignup();
			ls.userAdmin();
		}else {
			System.out.println("Invalid Input");
			addagain(hm);
		}
	}
}