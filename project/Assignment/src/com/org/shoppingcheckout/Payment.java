
package com.org.shoppingcheckout;
import java.util.Scanner;

public class Payment {
	public static void payThrough(){
		Scanner sc = new Scanner(System.in);
		System.out.println("0.credit payment");
		System.out.println("1.cash on delivery");
		int t = sc.nextInt();
		if(t==0) {
			System.out.println("Enter the credit card details");
			Card.cardInsert();
		}else if(t==1) {
			System.out.println("\t Cash on Delivery Mode Accepted \n \t Delivery to be Expected within 4Days\n");
			System.out.println("Enter 1 to continue Shopping");
			String choice = sc.next();
			if(choice.equals("1")) {
				Products.shopProducts(1);
			}else {
			System.out.println("\t\t**********THANK YOU************");
			}
		}else {
			payThrough();
		}
		sc.close();
	}
}