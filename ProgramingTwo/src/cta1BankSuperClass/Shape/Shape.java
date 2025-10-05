package cta1BankSuperClass.Shape;

import java.text.DecimalFormat;


abstract public class Shape {
	
	//formatter for toString method decimal values
	protected DecimalFormat f = new DecimalFormat("0.00");
	
	//variables to track in child classes
	protected double area;
	protected double perimeter;
	
	//methods required for child classes
	abstract public double area();
	abstract public double perimeter();
	
}
