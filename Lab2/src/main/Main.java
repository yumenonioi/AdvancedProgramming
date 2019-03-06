package main;

import Matching.Matching;
import enums.Language;
import enums.Topic;
import projects.Application;
import projects.Essay;
import projects.Project;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;
import java.time.Month;

/** @author Cristian and Cristina */
public class Main {

    public static void main(String[] args) throws ParseException{

    	
    	Student s1 = new Student("S1", 2);
        Student s2 = new Student("S2", 1);
        Student s3 = new Student("S3", 2);
        Student s4 = new Student("S4", 2);
        
        // adding the same student
    	Student s5 = new Student("S1", 2);
        
        if(s1.equals(s5))
        {
        	System.out.println("There are two students with equal properties ");
        	System.exit(0);
        }
        	
        
        Application a1 = new Application("A1", LocalDate.of(2019, Month.JUNE, 1), Language.JAVA);
        Application a2 = new Application("A2", LocalDate.parse("2019-06-01"), Language.PHP);
        Application a3 = new Application("A3", LocalDate.parse("2019-06-02"), Language.PYTHON);

        Essay e1 = new Essay("E1", LocalDate.parse("2019-05-02"), Topic.ALGORITHMS);
        Essay e2 = new Essay("E2", LocalDate.parse("2019-05-02"), Topic.DATA_STRUCTURES);

        List<Project> listOfProjects = new ArrayList<>();
        List<Student> listOfStudents = new ArrayList<>();


        listOfProjects.add(a1);
        a1.setNumberOfAppearances(a1.getNumberOfAppearances()+1);
        listOfProjects.add(a2);
        a2.setNumberOfAppearances(a2.getNumberOfAppearances()+1);
        listOfProjects.add(a3);
        a3.setNumberOfAppearances(a3.getNumberOfAppearances()+1);
        s1.setPreferences(listOfProjects);

        listOfProjects.clear();
        listOfProjects.add(a1);
        a1.setNumberOfAppearances(a1.getNumberOfAppearances()+1);
        listOfProjects.add(e1);
        e1.setNumberOfAppearances(e1.getNumberOfAppearances()+1);
        s2.setPreferences(listOfProjects);

        listOfProjects.clear();
        listOfProjects.add(a2);
        a2.setNumberOfAppearances(a2.getNumberOfAppearances()+1);
        listOfProjects.add(a3);
        a3.setNumberOfAppearances(a3.getNumberOfAppearances()+1);
        listOfProjects.add(e1);
        e1.setNumberOfAppearances(e1.getNumberOfAppearances()+1);

        s3.setPreferences(listOfProjects);

        listOfProjects.clear();
        listOfProjects.add(a3);
        a3.setNumberOfAppearances(a3.getNumberOfAppearances()+1);
        listOfProjects.add(e2);
        e2.setNumberOfAppearances(e2.getNumberOfAppearances()+1);
        s4.setPreferences(listOfProjects);

        listOfStudents.add(s1);
        listOfStudents.add(s2);
        listOfStudents.add(s3);
        listOfStudents.add(s4);
        Problem problem = new Problem();
        problem.setStudents(listOfStudents);
        System.out.println(problem);

        String preferedProjects = new String();
        preferedProjects = problem.getProjects();
        System.out.println(preferedProjects);

        Matching match = new Matching();

        match.Match(problem);
    }
}
