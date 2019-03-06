package Matching;

import main.Student;

import java.util.Comparator;
/** @author Cristian and Cristina */
public class OrderingStudents implements Comparator<Student> {
    /**
     * <p>In order to sort the objects (students) in a vector, we will need the method <i>compare()</i>
     * from the <i>Comparator</i> interface
     * </p>
     * @param a - the first student
     * @param b - the second student
     * @return It returns a value:
     * <p> - <0 if the first preference list is smaller than the second one </p>
     * <p> - =0 if the first preference list is equal to the second one </p>
     * <p> - >0 if the first preference list is greater than the second one </p>
     */
	@Override
	public int compare(Student a, Student b) {
        return a.preference.length - b.preference.length;
    }
}
