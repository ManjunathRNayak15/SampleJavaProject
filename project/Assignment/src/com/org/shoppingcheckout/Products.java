package com.org.shoppingcheckout;

import java.util.*;
/*
 * this class is to add products and move to cart for checkout.
 */
public class Products {
	String productName;
	double price;
	String model;
	static HashMap<String, Products> hm = new HashMap<String, Products>();
	Products(String productName,double price,String model){
		this.productName = productName;
		this.price=price;
		this.model=model;
	}
	public Products() {
	}
	
	static Scanner sc = new Scanner(System.in);
	@Override
	public String toString() {
		return "\n"  + productName + "\t " + price + "\t " + model;
	}
	public static void updateCart(HashMap<String, Products> hm) {
		/*
		 * Method to update cart for checkout.
		 */
		System.out.println("Enter the product ID to move it to cart");
		String id = sc.next();
		Products p1=null;
		try {
			if(p1==hm.get(id)){
				System.out.println("Invalid Input");
				updateCart(hm);
		}else {
			p1 = hm.get(id);
				Checkout.amount(p1,hm);
			}
		}catch(Exception e) {
			System.out.println("Invalid Input");
			updateCart(hm);
		}
		sc.close();
	}
	public static void shopProducts(int i) {
		/*
		 * method to add products and check for update cart by user or add products by admin.
		 */
		hm.put("MI12",new Products("			redmi		",15000,"6pro"));
		hm.put("AP34",new Products("			Apple		",56000,"i7"));
		hm.put("HP56",new Products("			hp		",35000,"240"));
		hm.put("AC78",new Products("			Acer		",63000,"Swift3"));
		System.out.println("ProductID\t\tproductName\t\tPrice\t\tModel");
		Set<String> s = hm.keySet();
		Iterator<String> it = s.iterator();
		while(it.hasNext()) {
			String pKey = it.next();
			System.out.println(pKey + hm.get(pKey).toString());
		}
		if(i==1) {
			updateCart(hm);
		}
		else {
			Admin.addProduct(hm);
		}		
	}
}
