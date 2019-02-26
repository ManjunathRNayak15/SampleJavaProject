package com.org.shoppingcheckout;

public class Customer {
	String name;
	String password;
	Customer(String name,String password){
		this.name = name;
		this.password = password;
	}
	public static void main(String[] agrs) {
		LoginSignup ls = new LoginSignup();
		ls.addCustomer();
		ls.userAdmin();
	}
}