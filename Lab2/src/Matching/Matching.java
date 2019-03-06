package Matching;

import main.Problem;
import main.Student;
import projects.Project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Cristian and Cristina
 * <p>This class implements the matching algorithm for allocating students to projects
 */
public class Matching {

    public void Match(Problem problem) {
        String solution = new String();
        solution = "[";
        List<Student> studentsOrder = new ArrayList<>();
        List<Project> projectsOrder = new ArrayList<>();

        studentsOrder = problem.getStudents();

        Collections.sort(studentsOrder, new OrderingStudents());

        for (Student student : studentsOrder) {
            for (Project project : student.getPreferenceList())
                if (projectsOrder.contains(project))
                    continue;
                else
                    projectsOrder.add(project);
        }

        Collections.sort(projectsOrder, new OrderingProjects());

        System.out.println("");

        for (Student student : studentsOrder) {
            for (Project project : projectsOrder) {
                if (student.getPreferenceList().contains(project)) {
                    solution = solution + "(" + student.getID() + ":" + project.getName() + "), ";
                    projectsOrder.remove(project);
                    break;
                } else if (projectsOrder.indexOf(project) == projectsOrder.size() - 1) {
                    solution = null;
                    break;
                }
            }
            if (solution == null) break;
        }

        if (solution == null) {
            System.out.println("No solution was found.");
        } else {
            solution = solution.substring(0, solution.length() - 2) + "]";
            System.out.println("Solution: " + solution);
        }
    }
}
