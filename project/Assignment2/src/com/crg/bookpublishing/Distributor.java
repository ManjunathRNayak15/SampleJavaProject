package com.crg.bookpublishing;

import java.util.LinkedList;
import java.util.Scanner;
/*
 * class to authenticate Distributor and give the book Id and price by the distributor
 */
public class Distributor {
		Distributor(){
		}
		String distributorName,password,email,distributorId;
		Distributor(String distributorName,String password,String email,String distributorId){
			this.distributorName=distributorName;
			this.password=password;
			this.email=email;
			this.distributorId = distributorId;
		}
		LinkedList<Distributor> ll = new LinkedList<Distributor>();
		Scanner takenInput = new Scanner(System.in);
		/*
		 * method to add distributor
		 */
		void addDistrbutor(){
			ll.add(new Distributor("james","1234","james@123","91ISO4567"));
			ll.add(new Distributor("mick","5678","mick@123","91ISO5678"));
			ll.add(new Distributor("jimmy","7890","jimmy@123","91ISO0987"));
			ll.add(new Distributor("sean","0987","sean@123","91ISO6789"));
			ll.add(new Distributor("sean","zxcvb","asdfg","91ISO1245"));
		}
		/*
		 * method to authenticate distributor
		 */
		String distrbutorAuth() {
			System.out.print("\nEnter the Distributor EmailId : ");
			String email1 = takenInput.next();
			System.out.print("\nEnter the Password : ");
			String password1 = takenInput.next();
			for(int i=0;i<ll.size();i++) {
				if(ll.get(i).email.equals(email1) && ll.get(i).password.equals(password1)) {
					return ll.get(i).distributorId;
				}
			}
			System.out.println("Invalid Email or Password");
			distrbutorAuth();
			return null;
		}
		/*
		 * method which helps the distributor to read the story and ratings given by editor. set a Price for the book with an unique book ID
		 */
		void distributeStory(String rating,Story s,int choice2) {
			String b1 = distrbutorAuth();
			if(!(b1.equals(null))) {
				if(rating.equals("0")) {
					System.out.println("\tNo Stories To Publish");
					Mainclass.entry(s, 1, choice2,rating);
				}else {
					System.out.println("1.See the Ratings and Read the Story\t2.Exit");
					String choice = takenInput.next();
					switch(choice){
						case "1":System.out.println("Ratings given for the Story : "+rating);
						System.out.println("Story : "+s.content);break;
						case "2":Mainclass.entry(s, 1, choice2,rating);break;
						default :System.out.println("Invalid Input ");
						Mainclass.entry(s, 1, choice2,rating);break;
					}
					int w=1;
					goback: do {
					System.out.println("\nSet price for the Story or Book");
					try {
						double bPrice = takenInput.nextDouble();
						System.out.println("\n\nPrice of book : "+bPrice);
						int ratings = Integer.parseInt(rating);
						Book book = new Book(s.author,s.title,s.genre,bPrice,ratings);
						int p=1;
						do{
						System.out.println("Enter a Book Id");
						String id = takenInput.next();
						String bookId =b1+id;
						 if(!(book.pq.containsKey(bookId))) {
							 System.out.println(bookId);
							 book.addNewBook(bookId,book);
							 p=2;
						 }else {
							 System.out.println("ID already Present Enter a New Id");
						 }
						}while(p==1);
					}catch(Exception e) {
						System.out.println("Invalid Input Price");
						continue goback;
					}
					}while(w==2);
				}
			}else {
						System.out.println("Invalid Input");
		}
	}
}
