package finalProject;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

public class FinalMain {

	public static void main(String[] args) {
		
		//variables
		int studentCount = 0;
		String name;
		String address;
		double GPA = 0;
		
		//linked list
		List<FinalStudent> students = new LinkedList<>();
		
		//scanner
		Scanner scnr = new Scanner(System.in);
		
		//loop length
		while (true) {
		    try {
		        System.out.print("How many students would you like to enter?: ");
		        studentCount = Math.abs(scnr.nextInt());
		        scnr.nextLine();
		        break; 
		    } catch (InputMismatchException e) {
		        System.out.println("Error: Please enter valid int value.");
		        //clear invalid input
		        scnr.nextLine(); 
		    }
		}
		
		System.out.println();
		
		//main loop
		for(int i = 0; i < studentCount; i++) {
			System.out.print("Enter student name: ");
			name = scnr.nextLine().trim();
			System.out.print("Enter student address: ");
			address = scnr.nextLine().trim();
			
			//double input validation
            while (true) {
                try {
                    System.out.print("Enter student GPA: ");
                    GPA = Math.abs(scnr.nextDouble());
                    scnr.nextLine(); 
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Error: Please enter valid double value.");
                    scnr.nextLine(); 
                }
            }
            
		    System.out.println();
		    //add student to linked list
		    FinalStudent st1 = new FinalStudent(name,address,GPA);
		    students.add(st1);
		}
		
		//sort students by name (ascending order)
		Collections.sort(students);
		
		//write info to file
		File out = new File("final.txt"); 
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(out))) {
			//loops trough every student
			writer.write("Students:\n\n");
		    for (FinalStudent s : students) {
		        writer.write(s.toString());
		        writer.newLine(); 
		    }
		    
		    System.out.println("File write successful.");

		} catch (IOException e) {
		    System.out.println("Error writing file: " + e.getMessage());
		}

		
		
		scnr.close();
	}

}
