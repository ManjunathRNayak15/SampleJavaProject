package com.org.shoppingcheckout;
/*
 * this class is to check the card details and verify and to proceed to checkout
 */
import java.util.*;

public class Card {
		int cardNo;
		String expireDate;
		int cvv;
		String holdersName;
		static Scanner sc = new Scanner(System.in);
	public Card(int cardNo, String expireDate, int cvv, String holdersName) {
		this.cardNo = cardNo;
		this.expireDate = expireDate;
		this.cvv = cvv;
		this.holdersName = holdersName;
				}
	
	public static void cardValidation(ArrayList<Card> al) {
		/*
		 * this method is to validate the card details
		 */
		System.out.println("Enter the credit card details");
		System.out.println("Credit card number");
		int cardNum = sc.nextInt();
		System.out.println("Credit card expire date");
		String expireDate = sc.next();
		System.out.println("Credit card cvv");
		int cvv = sc.nextInt();
		System.out.println("Credit card holder name");
		String holderName = sc.next();
		
		switch(cardNum)
		{
		case 123456:Card c=(Card) al.get(0);
		if(cardNum == c.cardNo && expireDate.contentEquals(c.expireDate) && cvv == c.cvv 
				&& holderName.contentEquals(c.holdersName) ) {
			continueShopping();
		}else{
			System.out.println("Invalid Input");
			cardValidation(al);
		};break;
		case 123567:Card c1=(Card) al.get(1);
		if(cardNum == c1.cardNo && expireDate.contentEquals(c1.expireDate) && cvv == c1.cvv 
				&& holderName.contentEquals(c1.holdersName) ) {
			continueShopping();
		}else{
			System.out.println("Invalid Input");
			cardValidation(al);
		};break;
		case 123678:Card c11=(Card) al.get(2);
		if(cardNum == c11.cardNo && expireDate.contentEquals(c11.expireDate) && cvv == c11.cvv 
				&& holderName.contentEquals(c11.holdersName) ) {
			continueShopping();
		}else{
			System.out.println("Invalid Input");
			cardValidation(al);
		};break;
		case 123789:Card c111=(Card) al.get(3);
		if(cardNum == c111.cardNo && expireDate.contentEquals(c111.expireDate) && cvv == c111.cvv 
				&& holderName.contentEquals(c111.holdersName) ) {
			continueShopping();
		}else{
			System.out.println("Invalid Input");
			cardValidation(al);
		};break;
		case 123890:Card c5=(Card) al.get(4);
		if(cardNum == c5.cardNo && expireDate.contentEquals(c5.expireDate) && cvv == c5.cvv 
				&& holderName.contentEquals(c5.holdersName) ) {
			continueShopping();
		}else{
			System.out.println("Invalid Input");
			cardValidation(al);
		};break;
		default: System.out.println("Invalid Input");
		cardValidation(al);
		}
	}
	public static void cardInsert(){
		/*
		 * method to add cards
		 */
		ArrayList<Card> al = new ArrayList<Card>();
		al.add(new Card(123456,"12/24",484,"ajay"));
		al.add(new Card(123567,"12/24",545,"akash"));
		al.add(new Card(123789,"12/24",243,"ajith"));
		al.add(new Card(123678,"12/24",947,"bharat"));
		al.add(new Card(123890,"12/24",647,"chandru"));
		cardValidation(al);
}
	static void continueShopping() {
		/*
		 * this method is to choose to continue shopping or to sign out or exit
		 */
			System.out.println("Paymet Accepted Through Card");
			System.out.println("Enter 1 to Continue Shopping \\n 2 to Sign out \\n Else any to exit");
			String choice = sc.next();
			if(choice.equals("1")) {
				Products.shopProducts(1);
			}else if(choice.equals("2")){
				LoginSignup ls = new LoginSignup();
				ls.userAdmin();
			}else {
			System.out.println("\t\t**********THANK YOU************");
			}
			sc.close();
	}
}
