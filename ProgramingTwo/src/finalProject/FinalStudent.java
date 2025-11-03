package finalProject;

public class FinalStudent implements Comparable<FinalStudent> {
	
	//variables
	private String name;
	private String address;
	private double GPA = 0;
	
	//parameterized constructor
	public FinalStudent(String name, String address, double GPA) {
		this.name = name;
		this.address = address;
		this.GPA = GPA;
	}
	
	//getters
	public String getName() { return name;}
	public String getAddress() { return address;}
	public double getGPA() { return GPA;}
	
	//toString
	@Override
	
	public String toString() {
		return "Student Name: " + name + "\nAddress: " + address + "\nGPA: " + GPA + "\n";
	}

	//compareTo
    @Override
    
    public int compareTo(FinalStudent other) {
        return this.name.compareTo(other.name);
    }
	
	
	

}
