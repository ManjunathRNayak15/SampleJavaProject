package com.crg.hospital;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/*
 * class which has persons basic information
 */
public class Person {
	String personTitle,givenName,middleName,familyName;
	Date birthDate;
	String gender,address;
	BigInteger phone;
	Scanner takeInput = new Scanner(System.in);
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
	ArrayList<Person> al = new ArrayList<Person>();
	Person(String personTitle,String givenName,String middleName,String familyName,
			Date birthDate,String gender,String address,BigInteger phone){
		this.personTitle = personTitle;
		this.givenName = givenName;
		this.middleName = middleName;
		this.familyName = familyName;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
	}
	Person() {
	}
}
