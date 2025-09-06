package ProgramingOneFiles;
import java.util.*;

public class Automobile {
	
	private String make; //creates class variables
	private String model;
	private String color;
	private Integer year;
	private Integer mileage;
	
	private static List<Automobile> inventory = new ArrayList<>(); //array list holds car inventory
	
	 public Automobile(){
		//sets all to null
	}
	
	 public Automobile(String make, String model, Integer year, String color, Integer mileage) {
		 this.make = make; // sets variables
		 this.model = model;
		 this.color = color;
		 this.year = year;
		 this.mileage =  mileage;

		 
	 }
	 
	 public static String addAutomobile(Automobile car) { // adds car to array list
		 try {
			 inventory.add(car);
			 return "Vehicle added succesfully\n";
		 }
		 catch (Exception e){
			 return "Failed to add vehicle: " + e.getMessage();
		 }
	 }
	 
	 public static String removeAutomobile(Automobile car) { //removes automobile from array list
		 try {
			  inventory.remove(car);
			 return "Vehicle removed succesfully\n";
		 }
		 catch (Exception e){
			 return "Failed to removed vehicle: " + e.getMessage();
		 }
	 }
	 
	 public String getMake(Automobile car) { return car.make; } // methods to retrieve car information
	 public String getModel(Automobile car) { return car.model; }
	 public String getColor(Automobile car) { return car.color; }
	 public int getYear(Automobile car) { return car.year; }
	 public int getMileage(Automobile car) { return car.mileage; }
	 
	 public String updateInfo(String make, String model, Integer year, String color, Integer mileage) {
		 String result = "";
		 
		 if (make != null) { //updates info if null is not passed
			 try {
				 this.make = make;
				 result += "Make updated succesfully\n";
			 }
			 catch (Exception e){
				 result += "Failed to update Make: " + e.getMessage() + "\n";
			 }
		 }
		 
		 if (model != null) {
			 try {	
				 this.model = model;
				 result += "Model updated succesfully\n";
			 }
			 catch (Exception e){
				 result += "Failed to update Model: " + e.getMessage() + "\n";
			 }
		 }
		 
		 if (color != null) {
			 try {	
				  this.color = color;
				  result += "Color updated succesfully\n";
			 }
			 catch (Exception e){
				 result += "Failed to update Color: " + e.getMessage() + "\n";
			 }
		 }
		 
		 if (year != null) {
			 try {	
				 this.year = year; 
				 result += "Year updated succesfully\n";
				 }
			 catch (Exception e){
				 result += "Failed to update Year: " + e.getMessage() + "\n";
			 }
		 }
		 
		 if (mileage != null) {
			 try {	
				 this.mileage = mileage;
				 result += "Milage updated succesfully\n";
			 }
			 catch (Exception e){
				 result += "Failed to update Milage: " + e.getMessage() + "\n";
			 }
		 }
		 
		 return result;
	 }


	 
	 public String getInfo() { // gets string with info for one car
		return "Make: " + make + "\nModel: " + model + "\nColor: " + 
				color + "\nYear: " + year + "\nMiles: " + mileage + "\n";
				
	 }
	 
	 public static void clearInfo() { // clears inventory array list of all vehicles
		 inventory.clear(); 
	 }
	  
	 public static String printAll() { // gets a string with info for all cars
		 String str = "";
		 for(Automobile car : inventory) {
			 str += car.getInfo() + "\n";
		 }
		 return str;
	 }
	
}
