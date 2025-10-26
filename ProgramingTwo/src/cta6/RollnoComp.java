package cta6;
import java.util.Comparator;

public class RollnoComp implements Comparator<Student> {

	@Override
    public int compare(Student studentOne, Student studentTwo) {
		//compares students rollno integers
        return Integer.compare(studentOne.getRollno(), studentTwo.getRollno());
    }
}
