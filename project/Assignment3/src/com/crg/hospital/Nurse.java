package com.crg.hospital;
/*
 * class in which nurse see the prescription and take care of the patient
 */
public class Nurse extends Staff {
/*
 * method in which nurse see the prescription, take care of the patient and display a message
 */
	public void patientPrescription(String prescription, String patient_Id) {
		System.out.println("Enter 1 read the Prescription and take action");
		String c = takeInput.next();
		if(c.equals("1")) {
			System.out.println("Patient Id : "+patient_Id);
			System.out.println("Prescription given : "+prescription);
			System.out.println("Action taken by the Nurse");
			MainclassHospital.start();
		}else {
			MainclassHospital.start();
		}
	}
}
