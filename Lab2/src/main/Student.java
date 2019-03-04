package main;

import projects.Application;
import projects.Project;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String ID;
    private int yearOfStudy;
    private String lastName = new String();
    private String firstName = new String();
    private String preferences = new String();
    public String[] preference = new String[100];
    public List<Project> preferenceList = new ArrayList<>();

    Student(String ID, int yearOfStudy) {
        this.ID = ID;
        this.yearOfStudy = yearOfStudy;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setYearOfStudy(int studyYear) {
        this.yearOfStudy = studyYear;
    }


    public void setPreferences(List<? extends Project> listOfProjects) {
        for (Project project : listOfProjects) {
            this.preferences = this.preferences + project.getName() + ", ";
            setPreferenceList(project);
        }
        preferences = preferences.substring(0, preferences.length() - 2); // eliminate the last 2 characters from the preferences (", ")
        setPreference(this.preferences);

    }

    private void setPreference(String preferences) {
        preference = preferences.split(", ");
    }

    public void setPreferenceList(Project project) {
        this.preferenceList.add(project);
    }

    public String getID() {
        return ID;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPreferences() {
        return preferences;
    }

    public List<Project> getPreferenceList() {
        return preferenceList;
    }

    @Override
    public String toString() {
        return this.ID;
    }
}
