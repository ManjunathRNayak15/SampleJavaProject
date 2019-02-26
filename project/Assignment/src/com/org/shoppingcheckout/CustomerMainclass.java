package com.org.shoppingcheckout;
/*
 * @Author Manjunath R , CRG Solutions pvt ltd
 * Mainclass to start the application and add customer
 */
public class CustomerMainclass {
	String name;
	String password;
	String address;
	CustomerMainclass(String name,String password,String address){
		this.name = name;
		this.password = password;
		this.address = address;
	}
	public static void main(String[] agrs) {
		LoginSignup ls = new LoginSignup();
		ls.addCustomer();
		ls.userAdmin();
	}
}