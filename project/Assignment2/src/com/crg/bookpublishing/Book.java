package com.crg.bookpublishing;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
/*
 * class to add books
 */
public class Book {
	String author,title,bookId,genre;
	double bPrice;
	int rating;
	Hashtable<String, Book> pq = new Hashtable<String, Book>();
	Book(String author,String title,String genre,double bPrice,int rating){
		this.author = author;
		this.title = title;
		this.genre =genre;
		this.bPrice = bPrice;
		this.rating = rating;
	}
	/*
	 * Overridden method returns authors name , story title,genre and price
	 */
	@Override
	public String toString() {
		return author+"\t"+title+"\t"+genre+"\t"+bPrice;
	}
	/*
	 * method to add books to the collection
	 */
	void addBook(){
		pq.put("91ISO4567211",new Book("Rajan","The Amazment\t","Thriller",100,4));
		pq.put("91ISO1245241",new Book("Kiran","Hathi mera Sathi","Action",200,3));
		pq.put("91ISO1245212",new Book("Sammy","The Power Within","Mystery",500,2));
		pq.put("91ISO2545256",new Book("sharan","The Inconsistant","biography",200,3));
		pq.put("91ISO1245210",new Book("suresh","I am Possible","Mystery",500,4));
	}
	/*
	 * method to add new book
	 */
	void addNewBook(String bookId,Book bk) {
		addBook();
		pq.put(bookId, bk);
		displayBooks(pq);
	}
	/*
	 * method displays all the books
	 */
	public void displayBooks(Hashtable<String, Book> pq) {
		Set<String> s = pq.keySet();
		Iterator<String> it = s.iterator();
		System.out.println("\n\n\t\t\t****Displayed Books For Sales****");
		System.out.println("\nAuthor\tTitle\tGenre\tPrice");
		while(it.hasNext()) {
			System.out.println(pq.get(it.next()).toString());
		}
	}
}
