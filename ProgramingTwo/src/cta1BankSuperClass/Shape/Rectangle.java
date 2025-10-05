package cta1BankSuperClass.Shape;

public class Rectangle extends Shape {
	
	//variables specific to Rectangle
	private double width;
	private double length;
	
	//parameterized constructor
	public Rectangle(double width, double length) {
		this.width = width;
		this.length = length;
		this.area = findArea(this);
		this.perimeter = findPerimeter(this);
	}
	
	//getters
	public double getWidth() {return this.width;}
	public double getLength() {return this.length;}
	
	//calculates area of current Rectangle object
	public double area() {
		return findArea(this);
	}
	
	//calculates area of current Rectangle object
	public double perimeter() {
		return findPerimeter(this);
	}
	
	@Override
	
	//prints out area and perimeter values
	public String toString() {
		return "Rectangle\nArea: " + f.format(area) + "\nPerimeter: " + f.format(perimeter) + "\n\n" ;
	}

	//helper methods
	
	//calculates area
	private double findArea(Rectangle shape) {
		return ( width * length );
	}
	
	//adds all 4 sides to find perimeter
	private double findPerimeter(Rectangle shape) {
		return (length + width ) * 2;
	}


	
}
