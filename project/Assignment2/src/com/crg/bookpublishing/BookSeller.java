package com.crg.bookpublishing;
/*
 * Class will Display all the Books for sale
 */
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class BookSeller {
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
