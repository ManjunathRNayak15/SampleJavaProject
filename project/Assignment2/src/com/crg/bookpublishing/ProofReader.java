package com.crg.bookpublishing;
/*
 * class to validate the story if it is already written or not and give feedback
 */
import java.util.ArrayList;

public class ProofReader {
	ArrayList<Story> al = new ArrayList<Story>();
	/*
	 * method to check plagarism and give feedback
	 */
	boolean pfReview(Story s) {
		storyStack();
		int count = 1;
		String[] crumbs1 = s.content.split(" ");
		String[] crumbs2 = al.get(0).content.split(" ");
		for(int i=0;i<crumbs1.length;i++) {
			if(crumbs1[i].length()>3) {
				for(int j=0;j<crumbs2.length;j++) {
					if(crumbs1[i].equals(crumbs2[j])) {
					count++;
					}
				}
			}
		}
		if(60<count*100/crumbs1.length || 60<count*100/crumbs2.length) {
			System.out.println("\n\tPlagarism found\n");
			return false;
		}else {
			int rating = 5-count*5/crumbs1.length;
			System.out.println("Story Can Proceed to Editor \nprofreader Rating :"+rating);
			return true;
		}
	}
	/*
	 * method add Stories as previously stored
	 */
	void storyStack() {
		al.add(new Story("Akash", "9876545678", "Immortals", "", "Immortals are those who never end like chandrashekar azadh, bhagath sigh and many more they fought for the freedom we get now"));
		al.add(new Story("Basava","8765456789", "Invisible Man", "Thriller", "Once upon a time there was a scientist who was very obssesed with the idea of man becoming invisible."));
		al.add(new Story("Chandru", "7898765456", "Soul World", "Mystery", "As they say Soul is the core of every living being on the planet soul holds a special part in the life"));
		al.add(new Story("Darma", "9876567876", "Lucifer the Angel", "fiction", "Lucifer the Devil as they reffered lucifer was not evil always lucifer was an angel and gods favourite son"));
	}
}
