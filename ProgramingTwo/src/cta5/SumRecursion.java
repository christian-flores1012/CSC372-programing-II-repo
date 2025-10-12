package cta5;
import java.util.*;



public class SumRecursion {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Total is " + add(5,scnr) );
		
		scnr.close();

	}
	
	public static double add(int count, Scanner scnr) {

		double num = 0;
		boolean valid = false;
		
	    while (!valid) {
	        try {
	            System.out.print("Enter numeric value: ");
	            num = scnr.nextDouble();
	            valid = true; // input is valid
	        } catch (Exception e) {
	            System.out.println("Invalid input. Please enter a numeric value.");
	            scnr.nextLine(); // clear invalid input from the scanner buffer
	        }
	    }

	    if (count <= 1) {
	        return num;
	    } else {
	        return num + add(count - 1, scnr);
	    }
	}
	



}
