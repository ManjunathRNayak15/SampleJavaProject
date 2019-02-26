package com.crg.hospital;

import java.util.Scanner;
import java.util.Vector;
/*
 * class to give access to the doctor to write prescription for the patient
 */
public class Doctor extends Staff{
	String[] doctorSpeciality,location;
	Scanner scanInput  =new Scanner(System.in);
	Nurse nurse  = new Nurse();
	TechnicalStaff technicalStaff = new TechnicalStaff();
	String choice;
	Doctor(String[] doctorSpeciality,String[] location){
		this.doctorSpeciality=doctorSpeciality;
		this.location=location;
	}
	public Doctor() {
	}
	/*
	 * method helps to see patients info and give prescription
	 */
	public void patientsInfo(String hospitalId, Vector<Patient> patientRecord,boolean b) {
		b=docAuth(hospitalId);
		if(b) {
			System.out.println("Full Name\tSickness\tPatient Id\tAllergies");
		for(int i=0;i<patientRecord.size();i++) {
			System.out.println(i+"\t"+patientRecord.get(i).info());
		}
		System.out.println("Select Patient by his/hers Id");
		String patient_Id = scanInput.next();
		System.out.println("Enter 1 to request for patient scan");
		String getScan = scanInput.next();
		if(getScan.equals("1")) {
			System.out.println("Choose the scan type");
			System.out.println("1.MRI\n2.X-Ray\n3.CT Scan");
			String scanType = scanInput.next();
			String scanReport = technicalStaff.patientScan(scanType);
			System.out.println("\nScan report : "+scanReport);
		}
		System.out.println("1.Give Prescription\t2.Forward Patience Details to Surgeon");
		choice = scanInput.next();
		switch(choice) {
		case "1":
			String prescription = scanInput.next()+scanInput.nextLine();
			System.out.println("Enter 1 to send the Prescription to Nurse");
			String c = takeInput.next();
			if(c.equals("1")) {
				nurse.patientPrescription(prescription,patient_Id);
			}
			break;
		case "2":
			Surgeon surgeon = new Surgeon();
			surgeon.patientInfo(patient_Id);
			;break;
		default :System.out.println("Invalid choice Input");
		patientsInfo(hospitalId,patientRecord,b);
		}
		}else {
			System.out.println("No Patients Info");
			MainclassHospital.start();
		}
	}
	/*
	 * method to authenticate doctor according to hospital Id
	 */
	private boolean docAuth(String hospitalId) {
		System.out.println("Enter the Hospital ID");
		String inputHospitalId= scanInput.next();
		if(hospitalId.equals(inputHospitalId)) {
			return true;
		}
		return false;
	}
}
