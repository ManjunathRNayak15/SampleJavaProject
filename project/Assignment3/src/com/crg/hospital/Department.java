package com.crg.hospital;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
/*
 * class in which administrator checks the department and add if needed
 */
public class Department {
	String d_Id,d_Name;
	String choice;
	Department(String DepartmentId,String d_Name){
		this.d_Id=DepartmentId;
		this.d_Name=d_Name;
	}
	Department(){
		
	}
	@Override
	public String toString() {
		return d_Id+"\t\t"+d_Name;
	}
	HashMap<String, Department> hm = new HashMap<String, Department>();
	Scanner sc = new Scanner(System.in);
	Staff stf = new Staff();
	/*
	 * method add department to collection
	 */
	void addDepartment() {
		hm.put("DEPT12",new Department("DEPT12","Cardiology"));
		hm.put("DEPT13",new Department("DEPT13","Urology"));
		hm.put("DEPT14",new Department("DEPT14","Gynaecology"));
	}
	/*
	 * method to add new department
	 */
	HashMap<String, Department> addNewDepartment(String d_Id2, String d_Name2) {
		hm.put(d_Id2, new Department(d_Id2,d_Name2));
		return hm;
	}
	/*
	 * method to display present departments
	 */
	void displayDepartments(HashMap<String, Department> hm2) {
		Set<String> s = hm2.keySet();
		Iterator<String> it = s.iterator();
		System.out.println("Department ID   Department Name");
		while(it.hasNext()) {
			System.out.println(hm2.get(it.next()));
		}
		System.out.println("Select the Department by it's Id");
		d_Id= sc.next();
		staffInfo(d_Id);
	}
	/*
	 * method to give options to see departments and add department 
	 */
	public void departmentInfo(String h_Id) {
		addDepartment();
		int i=1;
		goback:do {
				System.out.println("1.See Department\t2.Add Department");
				choice = sc.next();
				switch(choice) {
				case "1":i=2;
				displayDepartments(hm);
				break;
				case "2":i=2;
				System.out.println("Enter the Department ID : ");
				d_Id = sc.next();
				System.out.println("Enter the Department Name : ");
				d_Name=sc.next();
				HashMap<String, Department> hm1 = addNewDepartment(d_Id,d_Name);
				displayDepartments(hm1);
				break;
				default :System.out.println("Invalid Input");
				continue goback;
				}
		}while(i==1);
	}
	/*
	 * method to give option to see staff's or add staff by department Id
	 */
	 void staffInfo(String d_Id2) {
		System.out.println("1.See Staff's\t2.Add Staff");
		choice = sc.next();
		switch(choice) {
		case "1":stf.displayStaffs(d_Id2);
		break;
		case "2":stf.addStaffInfo(d_Id2);
		break;
		default : System.out.println("Invalid Input");
		}
	}
}
