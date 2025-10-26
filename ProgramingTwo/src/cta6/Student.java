package cta6;

public class Student {
	
	//student info
	private int rollno;
	private String name;
	private String address;
	
	public Student(int rollno, String name, String address) { //constructor
		this.rollno = rollno;
		this.name = name;
		this.address = address;
	}
	
	//getters
	public int getRollno() { return rollno; }
	public String getName() { return name; }
	public String getAddress() { return address; };
	
	
	@Override
	
	public String toString() {
		return "Student Name: " + name + "       Roll Number: " + rollno + "       Address: " + address + "\n";
	}

}
