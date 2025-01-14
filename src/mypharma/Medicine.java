/*
 * Medicine.java
 *
 * 12/4/2023
 *
 * Copyright (c) Author Salam Lababidi
 * All Rights Reserved
 */

package myPharma;

/*parent class Medicine*/
public class Medicine {
	
	/*private data Fields*/
	private String name; //represents the name of the medicine
	private String composition; // represents the active element of the medicine
	private int dose; //represents the dose of the medicine in mg
	private double price; // represents the price of the medicine
	private int quantity; //represents the available quantity of the medicine
	
	/*With-arg constructor Medicine that takes as parameter the name, composition, dose , 
	 *quantity and price of the medicine*/
	public Medicine(String name, String composition, int dose, double price, int quantity) {
		
		//Setting the parameters to their corresponding data fields
		setName(name); //calls setName mutator method and sets the parameter name to its corresponding data field
		setComposition(composition); //calls setComposition mutator method and sets the parameter composition to its corresponding data field
		setDose(dose); //calls setDose mutator method and sets the parameter dose to its corresponding data field
		setPrice(price); //calls setPrice mutator method and sets the parameter price to its corresponding data field
		setQuantity(quantity); //calls setQuantity mutator method and sets the parameter quantity to its corresponding data field
		
	}
	
	/*With-arg constructor Medicine that takes as parameter the name, composition and 
	 * dose of the medicine and sets the other data field to their default values*/
	public Medicine(String name, String composition, int dose) {
		
		/*this refers to the constructor Medicine with 5 parameters 
		 *and sets the values to their corresponding data fields*/
		this(name, composition, dose, 10, 0);
		
	}
	
	/*setter method that sets name*/
	public void setName(String name) {
		
		/*sets the String name in lower case to the name data field*/
		this.name = name.toLowerCase();
		
	}
	
	/*setter method that sets composition*/
	public void setComposition(String composition) {
		
		/*sets the String composition in lower case to the composition data field*/
		this.composition = composition.toLowerCase();
		
	}
	
	/*setter method that sets dose*/
	public void setDose(int dose) {
		
		/*checks if dose is positive*/
		if( dose > 0)
			/*if positive assigns int dose to dose data field */
			this.dose = dose;
		
		else
			/*if negative, assigns 1000 the default value to dose data field*/
			this.dose = 1000;
		
	}
	
	/*setter method that sets price*/
	public void setPrice(double price) {
		
		/*checks if price is positive*/
		if ( price > 0 )
			/*if positive assigns double price to price data field*/
			this.price = price;
		
		else
			/*if negative, assigns 10 the default value to price data field*/
			this.price = 10;
		
	}
	
	/*setter method that sets quantity*/
	public void setQuantity(int quantity) {
		
		/*checks if quantity is positive*/
		if( quantity > 0 )
			/*if positive assigns int quantity to quantity data field*/
			this.quantity = quantity;
		
		else
			/*if negative assigns 0 default value to quantity data field*/
			this.quantity = 0;
	}
	
	/*getter method of type String that returns name*/
	public String getName() {
		
		return name;
		
	}
	
	/*getter method of type String that returns composition*/
	public String getComposition() {
		
		return composition;
		
	}
	
	/*getter method of type int that returns dose*/
	public int getDose() {
		
		return dose;
		
	}
	
	/*getter method of type double that returns price*/
	public double getPrice() {
		
		return price;
		
	}
	
	/*getter method of type int that returns quantity*/
	public int getQuantity() {
		
		return quantity;
		
	}
	
	/*toString that return a String with the description of the medicine 
	 *according to the following format: 
		name: advil
		composition: ibuprofen
		dose: 500mg
		price: 3.5
		quantity: 20*/
	public String toString() {
		
		return "\tname: " + getName() + "\n\tcomposition: " + getComposition() + "\n\tdose: " + getDose() + "mg\n\tprice: " + getPrice() + "\n\tquantity: " + getQuantity();
	
	}
	
	/*The equals methods that will compare the medicine object to another object 
	 *and return true if the two objects have the same name and dose. False 
	 *otherwise*/
	public boolean equals( Medicine medicine ) {
		
		if ( name == medicine.name && dose == medicine.dose)
			
			return true;
		
		return false;
		
	}
	
}

