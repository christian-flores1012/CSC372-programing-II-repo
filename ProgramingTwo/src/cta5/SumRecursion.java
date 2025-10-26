package cta5;
import java.util.*;



public class SumRecursion {

	public static void main(String[] args) {
		//scanner
		Scanner scnr = new Scanner(System.in);
		
		int count = 5;// number of values to sum
		double[] values = new double[count];
		
		//prints out value of added values
		System.out.println("Total is " + promptValues(count,scnr,values) ); //asks user for 5 double values
		
		scnr.close();

	}
	
	public static double promptValues(int count, Scanner scnr, double[] values) {
		
		int i = 0;
		
		//input control
		for (i = 0; i < count; i++) {
	        try {
	        		//asks user for numeric value
	            System.out.print("Enter numeric value: ");
	            values[i] = scnr.nextDouble();
	            //if value is numeric turns valid 
	        } catch (Exception e) {
	            System.out.println("Invalid input. Please enter a numeric value.");
	            scnr.nextLine();
	            i--;
	        }
	    	}
	    
	    return sum(values, count - 1);
	    
	    
	}
	
	public static double sum(double[] values, int index) {
		
		 //if the count reaches index 0
	    if (index < 1) {
	        return values[index];
	    } else {
	    		//continues for all count numbers going down
	        return values[index] + sum(values, index - 1);
	    }
		
	}
	



}
