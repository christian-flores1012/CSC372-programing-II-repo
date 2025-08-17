package ProgramingOneFiles;
import java.util.*;

public class CSC320CTA5WeeklyTemp {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		
		List<Double> avgTemps = new ArrayList<>(); //creates arrayList for temps
		List<String> weekDays = new ArrayList<>(); // create arrayList for days
		
		weekDays.add("SUNDAY");  // adds all the days
		weekDays.add("MONDAY");
		weekDays.add("TUESDAY");
		weekDays.add("WEDNESDAY");
		weekDays.add("THURSDAY");
		weekDays.add("FRIDAY");
		weekDays.add("SATURDAY");
		
		
		for(int i = 0; i < weekDays.size(); i++) { // ask user for average temps
			System.out.print("What is the average temperature of " + weekDays.get(i) + "? ");
			try {
				avgTemps.add(scnr.nextDouble());

			}
			catch (InputMismatchException e) { // makes sure user enters double
				System.out.println("Input mismatch: please enter a double.");
				scnr.nextLine();
				i--; // repeats question incorrect input
				
			}
			
		}
		
		scnr.nextLine();
		
		while(true) {
			System.out.print("\nEnter a DAY or type WEEK or type END. ");
			
			String userSelection = scnr.nextLine();
			
			if ( weekDays.contains( userSelection.toUpperCase() ) ) { // check if user selected day of the week
				int index = weekDays.indexOf(userSelection.toUpperCase() ); // gets the index of user selection in weeks
				System.out.println("\n" + userSelection.toUpperCase() + ": \nAvg Temp: " + avgTemps.get(index) + " degrees");
			}
			else if(userSelection.toUpperCase().equals("WEEK")) { // checks if user selected the whole week
				double total = 0;
				for(String day: weekDays) { // prints every temperature for every day of the week
					System.out.println("\n" + day + ": \nAvg Temp: " + avgTemps.get(weekDays.indexOf(day) ) + " degrees");
					total += avgTemps.get(weekDays.indexOf(day));
				}
				
				total /= weekDays.size(); // calculates average and sets to only 2 decimal places 
				int decimal = (int)(total*100);
				total = (double)decimal;
				total /= 100;
				
				System.out.println("\nWEEK: \nAvg Temp: " + total + " degrees"); // prints out weekly average
			}
			else if(userSelection.toUpperCase().equals("END")) { // ends program
				System.out.println("Program Ended.");
				break;
			}
			else { // loops again if no valid input found
				System.out.println("Selection Invalid.");
			}
		}
		
		
		scnr.close();
	}
	
	

}
