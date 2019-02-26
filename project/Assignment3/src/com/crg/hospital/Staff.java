package com.crg.hospital;

import java.math.BigInteger;
import java.util.Date;
import java.util.Vector;
/*
 * class to add Staff and display staff's information
 */
public class Staff extends Person{
	Date dateJoined;
	String d_Id;
	String education,certification;
	String languages,fullName;
	Staff(String education,String certification,String languages,Date dateJoined,String d_Id,
			String personTitle,String givenName,String middleName,String familyName,
			Date birthDate,String gender,String address,BigInteger phone){
		this.dateJoined=dateJoined;
		this.education=education;
		this.certification=certification;
		this.languages=languages;
		this.d_Id=d_Id;
		this.personTitle = personTitle;
		this.givenName = givenName;
		this.middleName = middleName;
		this.familyName = familyName;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.fullName = givenName + middleName + familyName;
	}	
	Staff(){
	}
	@Override
	public String toString() {
		return "Title : "+personTitle+"\n"+"Full Name : "+fullName+"\n"+"Gender : "+gender+"\n"+"Address : "+
				address+"\n"+"Contact Number : "+phone+"\n"+"Education : "+education+"\n"+
				"Certification : "+certification+"\n"+"Languages : "+languages+"\n"+"Department ID : "+d_Id;
	}
	Vector<Staff> staffRecord = new Vector<Staff>();
	/*
	 * method to add Staff by Administrator
	 */
	void addStaffInfo(String d_Id2) {
		try {
			System.out.print("\nEnter the Person Title : ");
			personTitle = takeInput.next();
			System.out.print("\nEnter the Person Given Name : ");
			givenName = takeInput.next();
			System.out.print("\nEnter the Person Middle Name : ");
			middleName = takeInput.next();
			System.out.print("\nEnter the Person Family Name : ");
			familyName = takeInput.next();
			System.out.print("\nEnter the Person Birth Date (DD-MON-YYYY): ");
			String date = takeInput.next();
			birthDate = dateFormat.parse(date);
			System.out.print("\nEnter the Person Phone Number : ");
			phone = takeInput.nextBigInteger();
			System.out.print("\nEnter the Person Address : ");
			address = takeInput.next()+takeInput.nextLine();;
			System.out.print("\nEnter the Person Gender(Male(or)Female(or)TransGender) : ");
			gender = takeInput.next();
			d_Id=d_Id2;
			System.out.println("Enter the staff joined Date (DD-MON-YYYY)");
			String date1 = takeInput.next();
			birthDate = dateFormat.parse(date1);
			System.out.println("Enter The staff's education details[give space between each]");
			education = takeInput.next()+takeInput.nextLine();
			System.out.println("Enter The staff's certification details [give space between each]");
			certification = takeInput.next()+takeInput.nextLine();
			System.out.println("Enter The staff's lenguages konwn [give space between each]");
			languages = takeInput.next()+takeInput.nextLine();
			long phn = phone.longValue();
			double calc = phn/1000000000;
			if((gender.equalsIgnoreCase("Male")||gender.equalsIgnoreCase("Female")||gender.equalsIgnoreCase("TransGender"))&&calc>1&&calc<10) {
				staffRecord.add(new Staff(education,certification,languages, dateJoined,d_Id,personTitle,
						givenName,middleName,familyName,birthDate,gender,address,phone));
				System.out.println("\nStaff Information Successfully added to Database");
				displayStaffs(d_Id2);
				System.out.println("\n1.Add Another Staff\t2.Exit");
				String c=takeInput.next();
				if(c.equals("1")) {
					addStaffInfo(d_Id2);
				}else {
				MainclassHospital.start();
				}
			}else {
				 calc=1/0;
			}
		}catch(Exception e) {
			System.out.println("Invalid Input");
			addStaffInfo(d_Id2);
		}
	}
	/*
	 * method to display staff's information
	 */
	public void displayStaffs(String d_Id2) {
		if(staffRecord.size()==0) {
			System.out.println("No Staff's to Display");
			System.out.println("Enter 1 to Add Staff");
			String c1=takeInput.next();
			if(c1.equals("1")) {
				addStaffInfo(d_Id2);
			}else {
				MainclassHospital.start();
			}
		}
		for(int i=0;i<staffRecord.size();i++) {
			if(staffRecord.get(i).d_Id.equals(d_Id2)) {
				System.out.println(staffRecord.get(i).toString());
			}
		}
	}
}
