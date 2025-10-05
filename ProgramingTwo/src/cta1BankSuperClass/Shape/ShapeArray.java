package cta1BankSuperClass.Shape;

public class ShapeArray {

	public static void main(String[] args) {
		
		//creates instances of every shape (rectangle, circle, triangle) with parameters
		Rectangle rectangle = new Rectangle(16, 20);
		Circle circle = new Circle(15);
		Triangle triangle = new Triangle(10,10,15);
		
		//creates an array list that holds Shape object instances
		Shape[] shapes = new Shape[3];
		
		//adds shapes to the array
		shapes[0] = rectangle;
		shapes[1] = circle;
		shapes[2] = triangle;
		
		//loops trough array and uses toSting method for every shape
		for (int i = 0; i < shapes.length; i++) {
			System.out.printf( shapes[i].toString() );
		}

	}

}
