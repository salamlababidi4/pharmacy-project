/*
 * Pharmacy.java
 *
 * 12/4/2023
 *
 * Copyright (c) Author Salam Lababidi
 * All Rights Reserved
 */

package myPharma;

import java.util.ArrayList; //imports ArrayList class from java util package

/*public class Pharmacy*/
public class Pharmacy {
	
	/*private data fields: */
	private String name; //represents the name of the pharmacy
	private Medicine [] medicines; //array of medicines
	private int overTheCounterQuantity; //represents the total quantity of over the counter medicines in the pharmacy
	private int prescriptionQuantity; //represents the total quantity of prescription medicines in the pharmacy
	private int numberOfMedicines; //represents the number of different medicines in the array
	private static int MaxNumberOfMedicines = 100; //represents the capacity of the medicines array. Default is 100
	
	/*With-arg constructor Pharmacy that will create a new pharmacy given with a given 
   	 *name and set all the other values to their default*/
	public Pharmacy( String name ) {
		
		/*calls setName mutator method and sets the parameter name to its corresponding data field*/
		setName(name);
		
		/*array of medicines with size equal to the maximum number of medicines*/
		medicines = new Medicine[MaxNumberOfMedicines];
		
		/*setting 0 as a default value to overTheCounterQuantity*/
		overTheCounterQuantity = 0;
		
		/*setting 0 as a default value to prescriptionQuantity*/
		prescriptionQuantity = 0;

		/*setting 0 as a default value to numberOfMedicines*/
		numberOfMedicines = 0;
	
	}

	/*method that will accept a new medicine of any type and 
	 *checks if the medicine already exists in the array of medicines or not*/
	public void addMedicine ( Medicine newMedicine ) {
		
		int check = 0; //represents the number that checks if newMedicine already exists in array of medicines or not ( 0 if not )
		
		/*for loop that will repeat until i reaches numberOfMedicines*/
		for ( int i = 0; i < numberOfMedicines; i++){
			
			/*if statement that checks if newMedicine exists in the array of medicines using the method equals that is previously written in Medicine class*/
			if ( newMedicine.equals(medicines[i]))
				
				/*if condition is true, check is incremented by 1*/
				check++;
		
		}
		
		/*If the new medicine does not exist in the array the method will add 
		 *this medicine to the array of medicines and adjusts the 
		 *corresponding data fields*/
		if ( check == 0) {
			
			/*. If the array is full the method should 
			 *display an error message telling the user that the medicine could not 
			 *be added*/
			if( numberOfMedicines == MaxNumberOfMedicines )
			
				System.out.println("Error! Medicine cannot be added");
			
			/*else the array is not full and numberOfMedicines is less than the MaxNumberOfMedicines*/
			else {
				
				/*adding newMedicine to the array of medicines*/
				medicines[numberOfMedicines] = newMedicine;
				
				numberOfMedicines++; //we increment numberOfMedicines after we add Medicine successfully
				
				/*Displays message that medicine is added successfully*/
				System.out.println("New medicine is added successfully");
				
				/*if newMedicine is an instance of the Prescription class*/
				if ( newMedicine instanceof Prescription )
					
					/*we increment prescriptionQuantity by the quantity number of newMedicine*/
					prescriptionQuantity += newMedicine.getQuantity();
				
				/*else newMedicine is an instance of the OverTheCounter class*/
				else
					/*we increment overTheCounterQuantity by the quantity number of newMedicine*/
					overTheCounterQuantity += newMedicine.getQuantity();
			
			}
		
		}
		
		/* If the medicine already exists in the array*/
		else {
			/* the method will display a 
			 *message telling the user that the medicine already exists and the 
			 *array remains unchanged*/
			System.out.println("Medicine already exists!");
		
		}
		
	}
	
	/*The raisePrises method that will raise the price of all the medicines by a 
	specific percentage. If the percentage is negative the method will reduce the 
	price by the specified percentage.
	*/
	public void raisePrices ( double percentage ) {
		/*local variables 
		 *oldPrice representing price before adding percentage
		 *newPrice representing price after adding percentage
		 */
		double oldPrice, newPrice; 
		
		percentage /= 100; //dividing percentage by 100 to use it later in the equation
		
		/*for loop in order to go over all medicines inside the medicines array*/
		for ( int i = 0; i < numberOfMedicines ; i++) {
			
			/*getting old price of medicine inside medicines array at index i*/
			oldPrice = medicines[i].getPrice();
			
			/*formula of raising prices*/
			newPrice = oldPrice + oldPrice * percentage;
			
			/*setting newPrice as the price to the medicine at index i*/
			medicines[i].setPrice(newPrice);
		
		}
	
	}
	
	/*The searchByNameAndDose method that will search the array for a specific 
	 *medicine having a given name and dose*/
	public int searchByNameAndDose(String name, int dose) {
		
		/*for loop in order to go over all medicines inside medicines array*/
		for ( int i = 0; i < numberOfMedicines; i++ ) {
			
			/*checks if name and dose of medicine in medicines array at index i is equal 
			 *to the given name and given dose*/
			if( medicines[i].getName().equalsIgnoreCase(name) && medicines[i].getDose() == dose) {
				
				/*If found the method will return the index of this medicine in the array.*/
				return i;
			
			}
		
		}
		 /*Otherwise the method will return -1*/
		return -1;
	
	}
	
	/*The searchByName method that will search the array for all medicines 
	 *having a given name (medicines with same name and different dose can be 
	 *present in the array)*/
	public int [] searchByName ( String name ) {
		
		int [] indices; //an array of int representing the indices of the medicines in the array medicines
		/*ArrayList of type integer that will represent the indices of the medicines in the array of medicines once found*/
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		/*for loop in order to go over all medicines inside medicines array*/
		for ( int i = 0; i < numberOfMedicines; i++) {
			
			/*checks if medicine name is equal to the given name*/
			if( medicines[i].getName().equalsIgnoreCase(name)) {
				
				/*if condition is true, the index of this medicine will be added to the ArrayList arrayList*/
				arrayList.add(i);
			
			}
		
		}
		
		/*the size of indices array is that of the size of the arrayList created earlier
	 	 *representing the number of medicines found having the same name as the given name*/
		indices = new int[arrayList.size()];
		
		/*for loop to copy arrayList to indices*/
		for (int i = 0; i < arrayList.size(); i++) {
			
			/*every content of arrayList at a certain index i is being copied to indices at the same index */
			indices[i] = arrayList.get(i);
		
		} 
		
		/*The method returns an array of int representing the indices of those medicines in the array*/
		return indices;
	
	}
	
	/*The searchByComposition method that will search the array of medicines 
	 *for all medicines having the specified composition. The method returns an 
	 *array of int representing the indices of those medicines in the array*/
	public int [] searchByComposition( String composition ) {
		
		int [] indices; //an array of int representing the indices of the medicines in the array medicines
		
		/*ArrayList of type integer that will represent the indices of the medicines in the array of medicines once found*/
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		
		/*for loop in order to go over all medicines inside medicines array*/
		for ( int i = 0; i < numberOfMedicines; i++) {
		
			/*checks if medicine composition is equal to the given composition*/
			if( medicines[i].getComposition().equalsIgnoreCase(composition)) {
				
				/*if condition is true, the index of this medicine will be added to the ArrayList arrayList*/
				arrayList.add(i);
			
			}
		
		}
		
		/*the size of indices array is that of the size of the arrayList created earlier
		 *representing the number of medicines found having the same name as the given name*/
		indices = new int[arrayList.size()];
		
		/*for loop to copy arrayList to indices*/
		for (int i = 0; i < arrayList.size(); i++) {
			
			/*every content of arrayList at a certain index i is being copied to indices at the same index */
			indices[i] = arrayList.get(i);
		
		} 
		/*The method returns an array of int representing the indices of those medicines in the array*/
		return indices;
	
	}
	
	/*The sellMedicine method that will accept the name and dose of the 
	 *medicine and the required quantity. The method will search for a medicine 
	 *by its specified name and dose*/
	public void sellMedicine( String name, int dose, int quantity ) {
		
		int newQuantity; // representing new quantity
		
		/*if medicine is found and the index of it is returned*/
		if ( searchByNameAndDose(name, dose) != -1 ) {
			
			/*If the medicine is found and the available quantity is greater than 
			 *the required quantity*/
			if ( medicines[searchByNameAndDose(name, dose)].getQuantity() > quantity ) {
				
				/*the quantity of this medicine will be reduced*/
				newQuantity = medicines[searchByNameAndDose(name, dose)].getQuantity() - 1;
				
				/*assigning new quantity to the medicine*/
				medicines[searchByNameAndDose(name, dose)].setQuantity(newQuantity);
				
				/*displays a message telling the user that selling is successful*/
				System.out.println("Selling successful");
				
				/*if medicines at the returned index is an instance of class Prescription*/
				if( medicines[searchByNameAndDose(name, dose)] instanceof Prescription)
					
					/*decrement prescriptionQuantity by the quantity sold*/
					prescriptionQuantity -= quantity;
				
				/*else if medicines at the returned index is an instance of class OverTheCounter*/
				else
				
					/*decrement overTheCounterQuantity by the quantity sold*/
					overTheCounterQuantity -= quantity;
			
			}
			
			/*If the medicine is found but the available quantity is less than the 
			 *required quantity the method will display a message telling the user 
			 *that available quantity is not enough. The array “medicines” remains 
			 *unchanged*/
			else if ( medicines[searchByNameAndDose(name, dose)].getQuantity() < quantity ) {
			
				/*displays a message telling the user that available quantity is not enough*/
				System.out.println("The available quantity is not enough");
			
			}
		
		}
		
		/*If the medicine is not found the method will display a message telling the user that the medicine is not found*/
		else
		
			/*display a message telling the user that the medicine is not found*/
			System.out.println("Medicine is not found");
		
	}
	
	/*The restock method of type boolean that will accept the name and dose of a medicine and search the array of medicines to check if this medicine already exists or not*/
	public boolean restock( String name, int dose, int quantity ) {
	
		/*If the medicine does not exist in the array the method will return false*/
		if ( searchByNameAndDose(name, dose) == -1) {
		
			return false; //method returns false
		
		}
		
		/*else the medicine already exists in the array
		 *the method will add the new quantity to the available quantity of this medicine
		 *and return true*/
		medicines[searchByNameAndDose(name, dose)].setQuantity(medicines[searchByNameAndDose(name, dose)].getQuantity() + quantity);
		
		/*if medicines at the returned index is an instance of class Prescription*/
		if( medicines[searchByNameAndDose(name, dose)] instanceof Prescription )
			
			/* new quantity is added to prescriptionQuantity*/
			prescriptionQuantity += quantity;
		
		/*else medicines at the returned index is an instance of class OverTheCounter*/
		else
		
			/*new quantity is added to overTheCounterQuantity*/
			overTheCounterQuantity += quantity;
		
		/*Displays a message telling the user that restock is successful*/
		System.out.println("Restock Successful");
		
		return true; //method returns true
	
	}
	
	/*getter method of type Medicine[] that returns array of medicines*/
	public Medicine[] getMedicines() {
	
		return medicines;
	
	}

	/*getter method of type int that returns prescriptionQuantity*/
	public int getPrescriptionQuantity() {
	
		return prescriptionQuantity;
	
	}
	
	/*getter method of type int that returns overTheCounterQuantity*/
	public int getOverTheCounterQuantity() {
	
		return overTheCounterQuantity;
	
	}

	/*getter method of type int that returns numberOfMedicines*/
	public int getNumberOfMedicines() {
	
		return numberOfMedicines;
	
	}

	/*getter method of type int that returns MaxNumberOfMedicines*/
	public static int getMaxNumberOfMedicines() {
	
		return MaxNumberOfMedicines;
	
	}
	 
	/*setter method that sets name*/
	public void setName(String name) {
		
		/*assigns String name to name data field*/
		this.name = name;
	
	}
	
	/*setter method that sets maxNumberOfMedicines*/
	public static void setMaxNumberOfMedicines(int maxNumberOfMedicines) {
		
		/*if positive assigns int maxNumberOfMedicines to maxNumberOfMedicines data field*/
		if ( maxNumberOfMedicines > 0 )
		
			MaxNumberOfMedicines = maxNumberOfMedicines;
	
	}
	
	/*The toString method that will return the information about this pharmacy. 
	 *Example: 
	 *	Pharmacy: myPharma
	 *	Number of Medicines: 4
	 *	Over the counter quantity: 70
	 *	Prescription quantity: 50*/
	public String toString() {
	
		return "\tPharmacy: " + name + "\n\tNumber of Medicines: " + getNumberOfMedicines() + "\n\tOver the counter quantity: "
		
				+ getOverTheCounterQuantity() + "\n\tPrescription quantity: " + getPrescriptionQuantity();
	
	}

}
