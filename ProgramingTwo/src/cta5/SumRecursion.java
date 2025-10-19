package cta5;
import java.util.*;



public class SumRecursion {

	public static void main(String[] args) {
		//scanner
		Scanner scnr = new Scanner(System.in);
		//prints out value of added values
		System.out.println("Total is " + add(5,scnr) );
		
		scnr.close();

	}
	
	public static double add(int count, Scanner scnr) {
		
		//track total
		double num = 0;
		//input control
		boolean valid = false;
		
	    while (!valid) {
	        try {
	        		//asks user for numeric value
	            System.out.print("Enter numeric value: ");
	            num = scnr.nextDouble();
	            //if value is numeric turns valid
	            valid = true; 
	        } catch (Exception e) {
	            System.out.println("Invalid input. Please enter a numeric value.");
	            scnr.nextLine(); 
	        }
	    }
	    	
	    //if the count reaches 1 item left
	    if (count <= 1) {
	        return num;
	    } else {
	    		//continues for all count numbers going down
	        return num + add(count - 1, scnr);
	    }
	}
	



}
