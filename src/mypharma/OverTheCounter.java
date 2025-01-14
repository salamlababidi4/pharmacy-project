/*
 * OverTheCounter.java
 *
 * 12/4/2023
 *
 * Copyright (c) Author Salam Lababidi
 * All Rights Reserved
 */

package myPharma;

/*child class OverTheCounter of parent class Medicine*/
public class OverTheCounter extends Medicine{
	
	/*private data field*/
	private int minAge; //t represents the minimum age for which this medicine is allowed to be given
	
	/* With-arg constructor that takes as parameter the name, composition, dose ,
	 *quantity, price and minAge of the medicine and sets the code to its 
	 *corresponding value*/
	public OverTheCounter(String name, String composition, int dose, double price, int quantity, int minAge) {
		
		/*calls super constructor of the class Medicine to assign values to their 
		 *corresponding data fields*/
		super(name, composition, dose, price, quantity);
		/*calls setMinAge mutator method and sets the parameter minAge to its corresponding data field*/
		setMinAge(minAge);
	}
	
	/* With-arg constructor OverTheCounter that takes as parameter the name, composition, dose
	 *and minAge of the medicine and sets the other data field to their default 
	 *values*/
	public OverTheCounter(String name, String composition, int dose, int minAge) {
		
		/*this refers to the constructor OverTheCounter with 6 parameters 
		 *and sets the values to their corresponding data fields*/
		this(name, composition, dose, 10, 0, minAge);
		
	}
	
	/*setter method that sets minimum age*/
	public void setMinAge(int minAge) {
		 /*checks if minAge is positive*/
		if ( minAge > 0 )
			/*if positive assigns int minAge to minAge data field */
			this.minAge = minAge;
		
		else
			/*if negative, assigns 18 the default value to minAge data field*/
			this.minAge = 18;
		
	}

	/*getter method of type int that returns minAge*/
	public int getMinAge() {
	
		return minAge;
	
	}
	
	/*The toString method that returns a string with the description of the 
	 *medicine. Example:
	 *	Over the Counter : 
	 *		name: advil
	 *		composition: ibuprofen
	 *		dose: 500mg
	 *		price: 3.5
	 *		quantity: 20
	 *		minimum Age: 15*/
	public String toString() {
	
		return "Over the Counter :\n" + super.toString() + "\n\tminimum Age: " + getMinAge();
	
	}

}
