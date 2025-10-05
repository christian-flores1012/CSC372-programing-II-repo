package cta1BankSuperClass.Shape;

public class Circle extends Shape {
	
	//variable specific to Circle
	private double radius;

	//parameterized constructor
	public Circle(double radius) {
		this.radius = radius;
		this.area = findArea(this);
		this.perimeter = findPerimeter(this);
	}
	
	//getter
	public double getRadius() {return this.radius;}
	
	//calculates area of current Circle object
	public double area() {
		return findArea(this);
	}
	
	//calculates perimeter of current Circle object
	public double perimeter() {
		return findPerimeter(this);
	}
	
	@Override
	
	//prints out area and perimeter values
	public String toString() {
		return "Circle\nArea: " + f.format(area) + "\nPerimeter: " + f.format(perimeter) + "\n\n" ;
	}
	
	//helper methods
	
	// finds area of circle
	private double findArea(Circle shape) {
		return Math.PI * radius * radius ;
	}
	
	//finds circumference of circle
	private double findPerimeter(Circle shape) {
		return 2 * Math.PI * radius ;
	}
	
	

}
