package com.crg.bookpublishing;

import java.util.Scanner;
import java.util.Vector;
/*
 * class by which the writer gets a chance to write the story
 */
public class Story {
	String author,title,content,genre,contNo;
	String choice;

	Writer wt = new Writer();
	Editor ed = new Editor();
	ProofReader pr = new ProofReader();
	int i=0;
	Story(String author,String contNo,String title,String genre,String content){
		this.author = author;
		this.title = title;
		this.content = content;
		this.genre = genre;
		this.contNo = contNo;
	}
	public Story() {
		
	}
	/*
	 * Overridden methos which returns author name ,story title and genre.
	 */
	@Override
	public String toString() {
		return author+"\t"+title+"\t"+genre;//+"\n"+content;
	}
	/*
	 * method to add story details and the story
	 */
	void addStory() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in) ;
		System.out.print("Enter The Author's Name : ");
		author = sc.next();
		System.out.print("\nEnter the Contact Number : ");
		contNo = sc.next();
		System.out.print("\nEnter The Title : ");
		title = sc.next()+sc.nextLine();
		System.out.print("\nGenre of the Story : ");
		genre = sc.next();
		System.out.print("\nWrite the Story and write 'Endstory' to finish the Story\n\n");
		content = sc.next();
		String word;
		while(sc.hasNext()){
			word = sc.next();
			if(word.equalsIgnoreCase("Endstory")) {
				break;
			}
			content = content +" "+word;
		}
		Story st = new Story(author,contNo,title, genre,content);
		updateStory(st);
		wt.addAnotherStory(st);
	}
	/*
	 * method to update the story and give option to view the story to the writer
	 */
	void updateStory(Story st){
		Vector<Story> v = new Vector<Story>();
		v.add(st);
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in) ;
		System.out.println("1.To view Stories\t 2.Add Another Story\t3.Exit");
		choice = sc.next();
		if(choice.equals("1")){
			System.out.println(v.get(i).content+"\n\n");
			System.out.println("Enter 1 to proceed it to Review");
			String storyId = sc.next();
			int id = Integer.parseInt(storyId);
			if(id==1) {
				if(pr.pfReview(st)) {
					chooseEditor(st);
				}else {
					wt.draftStory();
				}
			}else {
				System.out.println("Enter valid Input");
			}
		}else if(choice.equals("2")){
			addStory();
		}else if(choice.equals("3")){
			wt.draftStory();
		}else {
			System.out.println("Invalid Input");
		}
	}
	/*
	 * method to choose the editor
	 */
	private void chooseEditor(Story st) {
		int a = 1;
		ed.choosenEditor(st,a);
	}
}
