package cta1BankSuperClass.Shape;

public class Triangle extends Shape {
	
	//variables specific to Triangle
	private double side1;
	private double side2;
	private double side3;

	//parameterized constructor
	public Triangle(double side1, double side2, double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		
		//if triangle sides can't form a valid triangle sets area to 0
		if (!isValidTriangle() ) {
			this.area = 0;
		}
		else {
			this.area = findArea(this);
		}
		this.perimeter = findPerimeter(this);
	}
	
	//getters
	public double getSide1() {return this.side1;}
	public double getSide2() {return this.side2;}
	public double getSide3() {return this.side3;}

	//calculates area of current Triangle object
	public double area() {
		return findArea(this);
	}
	
	//calculates perimeter of current Triangle object
	public double perimeter() {
		return findPerimeter(this);
	}
	
	@Override
	
	//prints out area and perimeter values
	public String toString() {
		if (area == 0) {
			return "Triangle\nArea: Can't calculate area. Not valid triangle.\nPerimeter: " + f.format(perimeter) + "\n\n" ;
		}
		
		return "Triangle\nArea: " + f.format(area) + "\nPerimeter: " + f.format(perimeter) + "\n\n" ;
		
	}
	
	//helper methods
	
	private double findArea(Triangle shape) {
		//heron's formula
		double semiPerimeter = (side1 + side2 + side3) / 2 ;
		double a = semiPerimeter - side1 ;
		double b = semiPerimeter - side2 ;
		double c = semiPerimeter - side3 ;
		double d = semiPerimeter * a * b * c ;
		
		return Math.sqrt(d);
	}
	
	//adds all sides
	private double findPerimeter(Triangle shape) {
		return side1 + side2 + side3 ;
	}
	
	//checks if triangle sides form a valid triangle
    private boolean isValidTriangle() {
        return side1 + side2 > side3 &&
               side1 + side3 > side2 &&
               side2 + side3 > side1;
    }
	

}
