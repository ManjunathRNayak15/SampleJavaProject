package com.crg.hospital;

import java.util.ArrayList;
import java.util.Scanner;
/*
 * class to add hospitals and add department option for a given hospital
 */
public class Hospital {
	String hospitalName;
	String h_Address;
	int h_Phone;
	String h_Id,choice,choice1 ;
	Hospital(String hospitalName,String h_Address,int h_Phone){
	this.hospitalName = hospitalName;
	this.h_Address=h_Address;
	this.h_Phone=h_Phone;
	}
	Hospital(){
	}
	Scanner sc = new Scanner(System.in);
	Person p = new Person();
	Patient pt =new Patient();
	Doctor doc = new Doctor();
	Receptionist rp = new Receptionist();
	Department dp = new Department();
	ArrayList< Hospital>al = new ArrayList<Hospital>();
	/*
	 * method to add hospital
	 */
	String addHospital(String choice2) {
		al.add(new Hospital("Hrudayalaya","Banglore",180045678));
		al.add(new Hospital("KR hospital","Mysore",180076252));
		al.add(new Hospital("columbia Asia","Mysore",180098765));
		if(choice2.equals("1")) {
			String hospId = selectHospital(al);
			return hospId;	
		}else {
		selectHospitalAdmin(al);
		return " ";
		}
	}
	/*
	 * method for hospital selection by staff
	 */
	private String selectHospital(ArrayList<Hospital> al2) {
		System.out.println("Select Hospital by it's Id\n");
		System.out.println("Id\tHospital Name");
		for(int i=0;i<al.size();i++) {
		System.out.println(i+"\t"+al.get(i).hospitalName);
		}
		choice = sc.next();
		return choice;
	}
	/*
	 * method for hospital selection by administrator
	 */
	void selectHospitalAdmin(ArrayList<Hospital> al) {
		System.out.println("Select Hospital by it's Id\n");
		System.out.println("Id\tHospital Name");
		for(int i=0;i<al.size();i++) {
		System.out.println(i+"\t"+al.get(i).hospitalName);
		}
		choice = sc.next();
		int i =1;
		do{switch(choice) {
		case "0":System.out.println("1.departments\n2.Exit");
		i=2;
        choice1 = sc.next();
        if(choice1.equals("1")) {
        	dp.departmentInfo(h_Id);
        }else if(choice1.equals("2")) {
        }break;
		case "1":System.out.println("1.departments\n2.Exit");
		i=2;
        choice1 = sc.next();
        if(choice1.equals("1")) {
        	dp.departmentInfo(h_Id);
        }else if(choice1.equals("2")) {
        };break;
		case "2":System.out.println("1.departments\n2.Exit");
        choice1 = sc.next();
        i=2;
        if(choice1.equals("1")) {
        	dp.departmentInfo(h_Id);
        }else if(choice1.equals("2")) {
        };break;
		default:System.out.println("Inavlid Input");
		selectHospital(al);
		}
	}while(i==1);
	}
}
