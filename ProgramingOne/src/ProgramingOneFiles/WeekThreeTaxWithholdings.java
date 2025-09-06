package ProgramingOneFiles;
import java.util.*;
import java.text.DecimalFormat;

public class WeekThreeTaxWithholdings{

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");
		
		System.out.print("What is your weekly base pay? "); //ask user for weekly pay
		
		double pay = scnr.nextDouble(); //sets pay to user weekly pay
		double total = 0.0;
		
		
		
		if (pay < 500.0) { // calculates withholdings using formula
			total = 0.1*pay;
		}
		else if (pay < 1500.0) {
			total = 0.1*500.0 + 0.15*(pay-500.0);
		}
		else if (pay < 2500.0) {
			total = 0.1*500.0 + 0.15*(1000) + 0.2*(pay-1500.0);
		}
		else {
			total = 0.1*500.0 + 0.15*(1000) + 0.2*(1000.0) + 0.3*(pay-2500.0);
		}
		
		System.out.println("Your weekly tax withholdings are " + df.format(total/pay*100) + "%($" + total + ")" ); //prints out withholdings
	
	
	scnr.close();
	}

}