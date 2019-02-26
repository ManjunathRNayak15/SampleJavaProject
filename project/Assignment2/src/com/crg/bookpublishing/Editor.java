package com.crg.bookpublishing;

import java.util.Scanner;
import java.util.Vector;
/*
 * class to authenticate editor and give the editor a chance to give the ratings and suggestions
 */
public class Editor {
	String editorName,editorPassword,email;
	Editor(String editorName,String editorPassword,String email){
		this.editorName=editorName;
		this.editorPassword=editorPassword;
		this.email=email;
	}
	Editor(){
	}
	String choice;
	Scanner sc = new Scanner(System.in);
	Vector<Editor> editorsRecord = new Vector<Editor>();
	/*
	 * method in which the editor reads the story and give feedback
	 */
	void eReview(Story s,int choice2) {
		System.out.println("1.Read the Story\t2.Exit");
		choice = sc.next();
		if(choice.equals("1")) {
			System.out.println(s.content);
			System.out.println("\n\n1.Enter the Ratings 1 to 5\t2.suggest edits");
			choice = sc.next();
			if(choice.equals("1")) {
				System.out.println("Enter the Ratings");
				String rating = sc.next();
				Agent ag = new Agent();
				ag.agentSelects(rating,s,choice2);
			}else if(choice.equals("2")) {
				@SuppressWarnings("unused")
				String suggests = sc.next()+sc.nextLine();
				Mainclass.main(null);
			}else {
				System.out.println("Invalid Input");
				eReview(s,choice2);
			}
		}else {
			System.out.println("Invalid Input");
			eReview(s,choice2);
		}
	}
	/*
	 * method to add editors
	 */
	void addEditor() {
		editorsRecord.add(new Editor("Siddu","qwerty","siddu@123"));
		editorsRecord.add(new Editor("King","asdfg","king@gmail.com"));
		editorsRecord.add(new Editor("Ram","zxcvb","ram@123"));
		editorsRecord.add(new Editor("Venki","poiuy","venki@yahoo"));
	}
	/*
	 * method to choose the editor by the writer
	 */
	void choosenEditor(Story st,int a) {
		addEditor();
		if(a==1) {
			System.out.println("EditorID\tName");
			for(int i=0;i<editorsRecord.size();i++) {
				System.out.println(i+"\t"+editorsRecord.get(i).editorName);	
			}
			System.out.println("Choose Id to Send The Story to That Editor");
			choice = sc.next();
		}else {
			choice = "9";
			st = null;
		}
		int c = Integer.parseInt(choice);
		Mainclass.entry(st, a,c,"0");
	}
	/*
	 * method to send editor the story
	 */
	public void edits(Story st, int choice2) {
		addEditor();
		editorAuth(editorsRecord,choice2,st);
	}
	/*
	 * method to authenticate the editor
	 */
	void editorAuth(Vector<Editor> editorsRecord, int choice2, Story st) {
		System.out.print("Enter the Editor EmailId : ");
		email = sc.next();
		System.out.print("\nEnter the Password : ");
		editorPassword = sc.next();
		int i=10;
		boolean b = false;
		for(i=0;i<editorsRecord.size();i++) {
			if(editorsRecord.get(i).email.equals(email) && editorsRecord.get(i).editorPassword.equals(editorPassword)) {
				b = true;
				break;
			}
			b=false;
		}if(b) {
			if(choice2==i) {
				eReview(st,choice2);
			}else {
				System.out.println("No Story to Review");
			}
		}
		else {
				System.out.println("Invalid Email or Password");
				editorAuth(editorsRecord,choice2,st);
		}
	}
}
