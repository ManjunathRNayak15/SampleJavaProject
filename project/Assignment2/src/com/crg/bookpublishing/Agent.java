package com.crg.bookpublishing;
/*
 * class sends the story from editor to Distributors
 */
public class Agent {
	/*
	 * method sends the rating and Story to the distributor
	 */
		void agentSelects(String rating, Story s,int choice){
			Distributor db = new Distributor();
			db.addDistrbutor();
			if(rating.equals("0")) {
				db.distributeStory(rating, s,choice);
			}else {
				Mainclass.entry(s, 1, choice,rating);
			}
		}
}
