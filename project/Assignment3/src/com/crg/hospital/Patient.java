package com.crg.hospital;
import java.math.BigInteger;
import java.util.Date;
import java.util.Vector;
/*
 * class to add Patients and display Patients Information
 */
public class Patient extends Person{
	String patientId,sickness;
	int patientAge;
	Date admissionDate;
	String prescriptions,specialreqs;
	String allergies;
	String patientFullName;
	Vector<Patient> patientsRecord = new Vector<Patient>();
	public Patient(String personTitle, String givenName, String middleName, String familyName, Date birthDate,
			String gender, String address, BigInteger phone, String patientId, String sickness, int patientAge, 
			Date admissionDate, String prescriptions2, String allergies2, String specialreqs2) {
		this.patientId=patientId;
		this.sickness=sickness;
		this.patientAge=patientAge;
		this.admissionDate=admissionDate;
		this.prescriptions=prescriptions2;
		this.allergies=allergies2;
		this.specialreqs=specialreqs2;
		this.personTitle = personTitle;
		this.givenName = givenName;
		this.middleName = middleName;
		this.familyName = familyName;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.patientFullName = givenName + middleName + familyName;
	}
	public Patient() {
	}
	/*
	 * method to add Patient Information
	 */
	Vector<Patient> addPatientInfo(String hospId) {
			try {
				System.out.print("\nEnter the Person Title : ");
				personTitle = takeInput.next();
				System.out.print("\nEnter the Patient Given Name : ");
				givenName = takeInput.next();
				System.out.print("\nEnter the Patient Middle Name : ");
				middleName = takeInput.next();
				System.out.print("\nEnter the Patient Family Name : ");
				familyName = takeInput.next();
				System.out.print("\nEnter the Patient Birth Date (DD-MON-YYYY): ");
				String date = takeInput.next();
				birthDate = dateFormat.parse(date);
				System.out.print("\nEnter the Patient Address : ");
				address = takeInput.next()+takeInput.nextLine();
				System.out.print("\nEnter the Patient Gender(Male(or)Female(or)TransGender) : ");
				gender = takeInput.next();
				System.out.print("\nEnter the Patient Phone Number : ");
				phone = takeInput.nextBigInteger();
				System.out.print("\nEnter the Patient ID : ");
				patientId = takeInput.next();
				System.out.print("\nEnter the Patient Sickness : ");
				sickness = takeInput.next();
				System.out.print("\nEnter the Patient Age : ");
				patientAge = takeInput.nextInt();
				System.out.print("\nEnter the Patient date accepted(DD-MON-YYYY): ");
				String date1 = takeInput.next();
				admissionDate = dateFormat.parse(date1);
				System.out.println("Enter The Patient allergies [give space between each]");
				allergies = takeInput.next()+takeInput.nextLine();
				System.out.println("Enter The Patient special requests [give space between each]");
				specialreqs = takeInput.next()+takeInput.nextLine();
				long phn = phone.longValue();
				double calc = phn/1000000000;
				if((gender.equalsIgnoreCase("Male")||gender.equalsIgnoreCase("Female")||
						gender.equalsIgnoreCase("TransGender"))
						&&calc>1&&calc<10) {
					Patient pt1 = new Patient(personTitle,givenName,middleName,familyName,birthDate,gender,address,phone, 
							patientId,sickness,patientAge,admissionDate,prescriptions, allergies,specialreqs);
					patientsRecord.add(pt1);System.out.println("Patient Added Sucessfully");
					return patientsRecord;
				}else {
					 calc=1/0;
				}
			}catch(Exception e) {
				System.out.println("Invalid Input");
				addPatientInfo(hospId);
			}
			return patientsRecord;
	}
	/*
	 * method to display patients Information
	 */
	public Vector<Patient> displayPatientInfo(Vector<Patient> patientsRecord1) {
		if(patientsRecord.size()>0) {
		System.out.println("Full Name\tSickness\tPatient Id\tAllergies");
		for(int i=0;i<patientsRecord1.size();i++) {
			System.out.println((patientsRecord.get(i)).info());
		}
		return patientsRecord;
		}
		System.out.println("No Patients TO Display");
		return patientsRecord;
	}
	/*
	 * method which return patients info
	 */
	String info() {
		return patientFullName+"\t"+sickness+"\t"+patientId+"\t"+allergies;
	}
}
