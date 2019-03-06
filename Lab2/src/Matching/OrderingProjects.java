package Matching;

import projects.Project;

import java.util.Comparator;
/** @author Cristian and Cristina */
public class OrderingProjects implements Comparator<Project> {
	/**
     * <p>In order to sort the objects (projects) in a vector, we will need the method <i>compare()</i>
     * from the <i>Comparator</i> interface
     * </p>
     * @param a - the first project
     * @param b - the second project
     * @return It returns a value:
     * <p> - <0 if the first number of appearances is smaller than the second one </p>
     * <p> - =0 if the first number of appearances is equal to the second one </p>
     * <p> - >0 if the first number of appearances is greater than the second one </p>
     */
	@Override
	public int compare(Project a, Project b) {
        return a.getNumberOfAppearances() - b.getNumberOfAppearances();
    }
}
