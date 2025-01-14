/*
 * Prescription.java
 *
 * 12/4/2023
 *
 * Copyright (c) Author Salam Lababidi
 * All Rights Reserved
 */

package myPharma;

/*child class Prescription of parent class Medicine*/
public class Prescription extends Medicine{
	
	/*private data field*/
	private String doctorSpecialization; //represents the specialization of the doctor allowed prescribing this medicine
	
	/*With-arg constructor that takes as parameter the name, composition, dose , 
	 *quantity, price and doctorSpecialization of the medicine and sets the code to 
	 *its corresponding value*/
	public Prescription(String name, String composition, int dose, double price, int quantity, String specialization) {
		
		/*calls super constructor of the class Medicine to assign values to their 
		 *corresponding data fields*/
		super(name, composition, dose, price, quantity);
		
		/*calls setDoctorSpecialization mutator method and sets the parameter specialization to its corresponding data field*/
		setDoctorSpecialization(specialization);
		
	}
	
	/*With-arg constructor Prescription that takes as parameter the name, composition, dose
	 *and doctorSpecialization of the medicine and sets the other data field to 
	 *their default values*/
	public Prescription(String name, String composition, int dose, String specialization) {
		
		/*calls super constructor of the class Medicine to assign values to their 
		 *corresponding data fields*/
		super(name, composition, dose);
		
		/*calls setDoctorSpecialization mutator method and sets the parameter specialization to its corresponding data field*/
		setDoctorSpecialization(specialization);
	
	}
	
	/*setter method that sets doctor specialization*/
	public void setDoctorSpecialization(String doctorSpecialization) {
		
		/*sets the String doctorSpecialization in lower case to the doctorSpecialization data field*/
		this.doctorSpecialization = doctorSpecialization.toLowerCase();
		
	}
	
	/*getter method of type String that returns doctorSpecialization*/
	public String getDoctorSpecialization() {
		
		return doctorSpecialization;
		
	}
	
	/*The toString method that returns a string with the description of the 
	 *medicine. Example: 
	 *	Prescription: 
	 *	name: xanax
	 *	composition: alprazolan
	 *	dose: 50mg
	 * 	price: 15.5
	 *	quantity: 50
	 *	doctor specialization: neurologist*/
	public String toString() {
		
		return "Prescription:\n" + super.toString() + "\n\tdoctor specialization: " + getDoctorSpecialization();
	
	}

}
