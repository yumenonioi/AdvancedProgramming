package Matching;

import projects.Project;

import java.util.Comparator;

public class OrderingProjects implements Comparator<Project> {
    public int compare(Project a, Project b) {
        return a.getNumberOfAppearances() - b.getNumberOfAppearances();
    }
}
