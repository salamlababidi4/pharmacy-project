/*
 * Main.java
 *
 * 12/4/2023
 *
 * Copyright (c) Author Salam Lababidi
 * All Rights Reserved
 */

package myPharma;

import java.util.Scanner; //imports Scanner class from java util package

//Main class
public class Main {
	
	//declaring Scanner
	public static Scanner in1 = new Scanner(System.in);
	
	/*displays the following menu and return the choice of the user:
	 *	1- Add a new medicine
	 *	2- Search for a medicine by name
	 *	3- Search for a medicine by composition
	 *	4- Sell a medicine
	 *	5- Restock a medicine
	 *	6- Display all medicines
	 *	7- Display information
	 *	8- Exist
	*/
	public static int menu(){
	
		int choice; //represents the choice of the user
		
		System.out.println("1- Add a new medicine");
		System.out.println("2- Search for a medicine by  name");
		System.out.println("3- Search for a medicine by composition");
		System.out.println("4- Sell a medicine");
		System.out.println("5- Restock a medicine");
		System.out.println("6- Display all medicines");
		System.out.println("7- Display information");
		System.out.println("8- Exist");
		
		/*do-while loop to check validity of choice*/
		do {
			
			System.out.println("Enter your choice (between 1 and 8): ");
			//user enters his choice of number
			choice = in1.nextInt();
		
		}while(choice < 1 || choice > 8);
		
		return choice; //returns choice
		
	}
	
	/*main method*/
	public static void main (String [] args ) {
	
		int choice; //representing choice of user
		char type; //representing the type of medicine
		String name, composition, specialization; //representing name of medicine, composition of medicine, doctor specialization
		int dose, quantity, minAge; //representing dose in mgs, quantity of medicine, minimum age for which the medicine is allowed to be taken
		double price; //representing price of medicine
		
		Pharmacy pharmacy = new Pharmacy("myPharma"); //creates a new pharmacy object called "myPharma"
		
		/*Displays message*/
		System.out.println("Welcome to \" myPharma \" pharmacy system." );
		System.out.println("-----------------------------------------------");
		
		/*The menu will be displayed in a do-while loop until the user chooses number 8*/
		do {
			
			/*displays menu and user's choice will be saved in choice*/
			System.out.println("Choose one the following options:");
			choice = menu();
			
			System.out.println();
			
			/*switch on choice with many cases depending on the user's choice that will display different options*/
			switch( choice ) {
			
			case 1: //if choice = 1, Add a new medicine option is selected
				
				System.out.println("Enter the information of the new medicine:");
				System.out.println();
				
				/*makes the user choose whether the medicine type is prescription or over the counter
				 *and makes sure the user enters a valid type*/
				do {
					
					System.out.println("Choose O or o for over the counter medicine and p or P for \r\n" + "prescription medicine:");
					type = in1.next().toUpperCase().charAt(0);
					
				}while( type != 'O' && type != 'P' );
				
				
				/*implies user to enter name of medicine*/
				System.out.println("name: ");
				name = in1.next();
				
				/*implies user to enter composition of medicine*/
				System.out.println("composition: ");
				composition = in1.next();
				
				/*implies user to enter dose of medicine in mgs*/
				System.out.println("dose");
				dose = in1.nextInt();
				
				/*implies user to enter quantity of medicine*/
				System.out.println("quantity: ");
				quantity = in1.nextInt();
				
				/*implies user to enter the price of the medicine*/
				System.out.println("price: ");
				price = in1.nextDouble();
				
				/*switch on the type of medicine chosen*/
				switch( type ) {
				
				case 'O': //Over The Counter Medicine Option
					
					/*implies user to enter the minimum age*/
					System.out.println("Enter the minimum Age for this medicine: ");
					minAge = in1.nextInt();
					
					/*creates new OverTheCounter object and assigns the parametes as name, composition, dose, price, quantity, minAge*/
					OverTheCounter overTheCounter = new OverTheCounter(name, composition, dose, price, quantity, minAge);
					pharmacy.addMedicine(overTheCounter); //adds the new medicine created to pharmacy
					
					break;
					
				case 'P': //Prescription Medicine Option
					
					/*implies the user to enter the doctor's specialization*/
					System.out.println("Enter the doctor specialization for this medicine: ");
					specialization = in1.next();
					
					/*creates new Prescription object and assigns the parameters as name, composiiton, dose, price, quantity, specialization*/
					Prescription prescription = new Prescription(name, composition, dose, price, quantity, specialization);
					pharmacy.addMedicine(prescription); // adds the new medicine created to pharmacy
					
					break;
					
				}
				
				break;
				
			case 2: //Search for a medicine by name Option
				
				/*implies the user to enter the name of the medicine to be found*/
				System.out.println("Enter the name of the medicine to be found");
				name = in1.next().toLowerCase(); //converts name to lower case
				
				int [] indices = pharmacy.searchByName(name); // the returned array from the searchByName method will be assigned to indices array
				
				/*Displays message*/
				System.out.println(indices.length + " medicine found matching this name.");
				
				/*Displays medicines in the indices array*/
				for ( int i = 0; i < indices.length ; i++) {
					
					System.out.println( (i + 1) + "-" + pharmacy.getMedicines()[indices[i]].toString() );
				
				}
				
				break;
			
			case 3: //Search for a medicine by composition Option
				
				/*implies user to enter composition*/
				System.out.println("Enter the composition to be found: ");
				composition = in1.next().toLowerCase();
				
				int [] indicesC = pharmacy.searchByComposition(composition); //the returned array from searchByComposition method will be assigned to indicesC array
				
				/*Displays message*/
				System.out.println(indicesC.length + " medicine found matching this composition.");
				
				/*Displays medicines in the indicesC array*/
				for ( int i = 0; i < indicesC.length ; i++) {
					
					System.out.println( (i + 1) + "- " + pharmacy.getMedicines()[indicesC[i]].toString() );
				
				}
				
				break;
				
			case 4: //Sell a Medicine Option
				
				/*implies user to enter name of medicine*/
				System.out.println("Enter the name of the medicine: ");
				name = in1.next().toLowerCase();
				
				/*implies user to enter dose of medicine in mgs*/
				System.out.println("Enter the dose: ");
				dose = in1.nextInt();
				
				/*implies user to enter quantity of medicine*/
				System.out.println("Enter the quantity: ");
				quantity = in1.nextInt();
				
				/*calls sellMedicine method to sell medicine of specific name, dose and quantity*/
				pharmacy.sellMedicine(name, dose, quantity);
				
				break;
				
			case 5: //Restock a Medicine Option
				
				/*implies user to enter name of medicine*/
				System.out.println("Enter the name of the medicine: ");
				name = in1.next().toLowerCase();
				
				/*implies user to enter dose of medicine in mgs*/
				System.out.println("Enter the dose: ");
				dose = in1.nextInt();
				
				/*implies user to enter quantity of medicine*/
				System.out.println("Enter the quantity: ");
				quantity = in1.nextInt();
				
				/*calls method restock to restock medicine of specific name, dose and quantity*/
				pharmacy.restock(name, dose, quantity);
				
				break;
				
			case 6: // Display all medicines Option
				
				/*for loop to access all medicines in medicines array and displays them*/
				for ( int i = 0; i < pharmacy.getNumberOfMedicines(); i++) {
					
					System.out.println("Medicine " + (i + 1) + " : " + pharmacy.getMedicines()[i].toString());
					System.out.println("----");
					
				}
				
				break;
				
			case 7: // Display information Option
				
				/*Displays pharmacy information*/
				System.out.println(pharmacy.toString());
				
				break;
				
			}
			
			System.out.println();
			System.out.println("-----------------------------------------------");
			
		}while( choice != 8 );
		
	}

}
