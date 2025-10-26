package cta6;
import java.util.Comparator;

public class NameComp implements Comparator<Student> {

	@Override
    public int compare(Student studentOne, Student studentTwo) {
		//compares students name strings
        return studentOne.getName().compareToIgnoreCase(studentTwo.getName());
    }

}
