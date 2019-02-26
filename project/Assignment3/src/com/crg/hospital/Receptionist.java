package com.crg.hospital;

import java.util.Scanner;
import java.util.Vector;
/*
 * class gives receptionist access to add patient and retrieve patients information
 */
public class Receptionist extends Staff{
	Patient patient = new Patient();
	String scanInput;
	Scanner takeInput = new Scanner(System.in);
	Vector<Patient> patientsRecord;
	/*
	 * method to check patient record
	 */
	public void patientsRecords(String hospitalId) {
		System.out.println("1.Add Patient and see Patient Info\t2.Patients Details\t3.Exit");
		scanInput = takeInput.next();
		switch(scanInput) {
		case "1":
			patientsRecord = patient.addPatientInfo(hospitalId);
			patient.displayPatientInfo(patientsRecord);
			System.out.println("Enter 1 to add Another Patient\t2.Send Patients Records to Doctor");
			String s = takeInput.next();
			if(s.equals("1")) {
				patientsRecords(hospitalId);
			}else if(s.equals("2")){
				informDoc(hospitalId,patientsRecord);
			}
			break;
		case "2" :
			patient.displayPatientInfo(patientsRecord);
			System.out.println("Enter 1 to add Patient\t2.Send Patients Records to Doctor");
			s = takeInput.next();
			if(s.equals("1")) {
				patientsRecords(hospitalId);
			}else if(s.equals("2")){
				informDoc(hospitalId,patientsRecord);
			}else {
				MainclassHospital.start();
			}
			break;
		case "3" :
			MainclassHospital.start();
			break;
		default:System.out.println("Invalid Input ");
			patientsRecords(hospitalId);
		}
	}
	/*
	 * method to inform doc about the patient
	 */
	void informDoc(String hospitalId1, Vector<Patient> patientsRecord1){
		System.out.println("Patient Added and Records sent to the Doctor");
		Doctor doc = new Doctor();
		doc.patientsInfo(hospitalId1,patientsRecord1,false);
	}
}