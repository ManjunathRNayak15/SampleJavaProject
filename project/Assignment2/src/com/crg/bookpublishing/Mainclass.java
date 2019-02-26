package com.crg.bookpublishing;

import java.util.Scanner;
/*
 * Main class the start the application and gives the login options
 */
public class Mainclass {
	public static void main(String[] args) {
		Story st = null;
		System.out.println("\t*****Welcome To The Book Publishing Page*****");
		entry(st,1,7,"0");
	}
	/*
	 * method gives login options and start the application
	 */
	static void entry(Story st,int b,int choice2, String rating) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int a=2;
		goback:do {
			System.out.println("\n\nChoose Option\n1.Writer\n2.Editor\n3.Distributor\n4.Exit\n");
				String choice = sc.next();
				Editor ed = new Editor();
				Distributor db = new Distributor();
				switch(choice) {
				case "1": 
					Writer wt = new Writer();
					wt.draftStory();
					break;
				case "2": 
					if(b==2) {
						st = null;
						}
					ed.edits(st,choice2);
					break;
				case "3" :
					Agent ag = new Agent();
					db.addDistrbutor();
					if(rating.equals("0")){
					ag.agentSelects( rating,st, choice2);
					}
					db.distributeStory(rating, st,choice2);
					break;
				case "4":
					a=8;
					System.out.println("\t\t********THANK YOU********");
					System.exit(1);
					break;
				default :
					System.out.println("Invalid Input\n");
					continue goback;
			}
		}while(a==2);
	}
}
