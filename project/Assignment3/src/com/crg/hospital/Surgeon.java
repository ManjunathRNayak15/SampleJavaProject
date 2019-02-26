package com.crg.hospital;
/*
 * class in which surgeon takes care of the patient
 */
public class Surgeon extends Doctor{
	Surgeon(String[] speciality, String[] location) {
		super(speciality, location);
	}
	public Surgeon() {
	}
	/*
	 * method in which surgeon takes care of the patient
	 */
	public void patientInfo(String patient_Id) {
		System.out.println("Enter 1 to See the Patient Details");
		String surgeonChoice = takeInput.next();
		if(surgeonChoice.equals("1")) {
					System.out.println("Action Taken On the Patient by the Surgeon.\n\n");
					MainclassHospital.start();
		}
	}
}
