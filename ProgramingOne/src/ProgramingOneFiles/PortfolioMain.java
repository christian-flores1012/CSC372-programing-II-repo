package ProgramingOneFiles;
import java.util.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class PortfolioMain {
	static Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) {
		
		
		
		try {
			
			Automobile car1 = new  Automobile("Toyota", "Camry", 2020 ,"Black" , 40000); // creates new car object
			
			System.out.println(Automobile.addAutomobile(car1) ); // adds car object to array list
			System.out.println("Car1 info------\n" + car1.getInfo() ); // prints car 1 info
			System.out.println(Automobile.removeAutomobile(car1) ); // removes car object from array list
			
			
			
			Automobile car2 = new  Automobile("Dodge", "Charger", 2013 ,"White" , 100000); // creates new car object
			
			System.out.println(Automobile.addAutomobile(car2) ); // adds car object to array list
			System.out.println("Car2 info------\n" + car2.getInfo() ); // prints car 2 info
			
			
			System.out.println(car2.updateInfo(null,null,null, "Red", 100900) ); //updates car 2 color and miles
			System.out.println("Car2 info after Update---------\n" + car2.getInfo() ); // prints car 2 info
			

			
		}
		catch(Exception e) {
			System.out.println("Error in Main: " + e.getMessage());
		}
		
		askPrint(); // ask user if they want to print to file
	}
	
		
	public static void askPrint() {
		while (true) {
			System.out.print("Do you want to print vehicle information to Autos.txt file? Enter Y for yes or N for no ");
			
			try {
				String answer = scnr.next().trim(); // aks if user wants to print
				if (answer.equals("Y") ){
					printToFile();
					break;
				}
				else if (answer.equals("N") ){
					System.out.println("Info will not be printed to Autos.txt");
					break;
				}
				else {
					System.out.println("Invalid Input. Enter Y or N.");
				}
			}
			catch (Exception e) {
				System.out.print("Invalid Input. Enter Y or N." );
				scnr.nextLine();
			}
		}
	}
	
	public static void printToFile() {
	    try (PrintWriter out = new PrintWriter(new FileWriter("Autos.txt", false))) { //print to file overwrites everytime
	        
	        out.println("----- Vehicle Information -----");
	        
	        out.println(Automobile.printAll() );
	        
	        System.out.println("Vehicle information successfully written to Autos.txt");
	    } catch (IOException e) {
	        System.out.println("Error writing to file: " + e.getMessage());
	    }
	}

}

