package cta6;
import java.util.*;

public class StudentMain {

	public static void main(String[] args) {
		//array list to hold students
        ArrayList<Student> students = new ArrayList<>();
        //adds 5 entries to array list
        students.add(new Student(28, "Rin", "Hub"));
        students.add(new Student(17, "Jakel", "Kirby"));
        students.add(new Student(56, "Naomi", "New York"));
        students.add(new Student(12, "Pip", "Texas"));
        students.add(new Student(34, "Bero", "Nolan"));

        //print student info in order of insertion
        System.out.println("Student List----------\n");
        students.forEach(System.out::println);
        
        // prints student info sorted by name 
        System.out.println("\nStudents Sorted by Name----------\n");
        SelectionSort.selectionSort(students, new NameComp() );
        students.forEach(System.out::println);
        
        //prints student info sorted  by roll number (ascending)
        System.out.println("\nStudents Sorted by Roll Number------------\n");
        SelectionSort.selectionSort(students, new RollnoComp() );
        students.forEach(System.out::println);

	}

}
