package cta6;

public class Student {
	
	//student info
	int rollno;
	String name;
	String address;
	
	public Student(int rollno, String name, String address) { //constructor
		this.rollno = rollno;
		this.name = name;
		this.address = address;
	}
	
	
	@Override
	
	public String toString() {
		return "Student Name: " + name + "       Roll Number: " + rollno + "       Address: " + address + "\n";
	}

}
