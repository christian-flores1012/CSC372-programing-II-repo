package ProgramingOneFiles;
import java.util.Scanner;
import java.lang.Math;

public class CSC320moduleFour {

	public static void main(String[] args) {

		
		Scanner scnr = new Scanner(System.in);
		
		int reps = 5; // stores number of values in case it needs to be changed later and prevents infinite loop
		
		double[] info = new double[reps]; // creates an empty array of doubles to hold values
		
		for (int i=0; i < reps; i++) { //Asks user for every number
			System.out.print("Enter floating point number " + (i+1) + ": ");
			info[i] = scnr.nextDouble();
		}
		
		System.out.println("Results:");// Prints all the solutions
		System.out.println("Total: " + calculateTotal(info));
		System.out.println("Average: " + calculateAverage(info));
		System.out.println("Maximum: " + calculateMaximum(info));
		System.out.println("Minimum: " + calculateMinimum(info));
		System.out.println("20% Interest on Total: " + calculateInterest(info, 20));
		
		scnr.close();

	}
	
	// helper methods
	
	static double calculateTotal(double[] info) {
		double total = 0;
		
		for(int i = 0; i < info.length; i++) { //adds all values in the array
			total += info[i];
		}
		
		return total;
	}
	
	static double calculateAverage(double[] info) {
		double total = 0;
		
		for(int i = 0; i < info.length; i++) { //adds all values
			total += info[i];
		}
		
		return (total/info.length); //divides total by number of values
	}
	
	static double calculateMinimum(double[] info) {
		double min = info[0];
		
		for(int i = 0; i < info.length; i++) { // goes trough every value of array
			min = Math.min(min, info[i]);
		}
		
		return min;
	}
	
	static double calculateMaximum(double[] info) {
		double max = info[0];
		
		for(int i = 0; i < info.length; i++) { // goes trough every value of array
			max = Math.max(max, info[i]); 
		}
		
		return max;
	}
	
	static double calculateInterest(double[] info, double interestPercent) {
		double total = 0;
		
		for(int i = 0; i < info.length; i++) { // goes trough every value of array
			total += info[i];
		}
		
		return (total*(interestPercent/100)); // calculate interest
	}
}







