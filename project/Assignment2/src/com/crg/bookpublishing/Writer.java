package com.crg.bookpublishing;
/*
 * class where the writer begins after logged in choose to write a story
 */
import java.util.Scanner;

public class Writer {
	Writer(){
		
	}
	String author,title,content,genre,contNo;
	Scanner sc = new Scanner(System.in);
	/*
	 * method to give option for the writer to write story or to exit
	 */
	void draftStory() {
		Story st = new Story();
		System.out.println("Enter 1 to write a Story else any to exit");
		String choice = sc.next();
		if(choice.equals("1")) {
			st.addStory();
		}else {
			Mainclass.entry(st,1,7,"0");
		}
	}
	void addAnotherStory(Story st) {
		
	}
}
