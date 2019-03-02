package main;

import enums.Language;
import enums.Topic;
import projects.Application;
import projects.Essay;
import projects.Project;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;
import java.time.Month;

public class Main {

    public static void main(String[] args) throws ParseException {

        /*
        Student s[] = new Student[];
        Application a[] = new Application[];
        Essay e[] = new Essay[];
        Scanner input = new Scanner(System.in);

        System.out.printf("Introduceti numarul de aplicatii: ");
        int numberOfApps = input.nextInt();

        for (int i = 1; i <= numberOfApps; i++) {
            System.out.printf("Introduceti numele aplicatiei " + i);
            String nameApp = input.next();
            a[i].setName(nameApp);

            System.out.printf("Introduceti deadline-ului aplicatiei (dd-mm-yyyy) " + i);
            String deadlApp = input.next();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
            Date date = formatter.parse(deadlApp);
            a[i].setDeadline(date);


            System.out.printf("Introduceti limbajul aplicatiei " + i);
            String language = input.next();
            a[i].setLanguage(language);
        }

        System.out.printf("Introduceti numarul de eseuri: ");
        int numberOfEssays = input.nextInt();

        for (int i = 1; i <= numberOfEssays; i++) {
            System.out.printf("Introduceti numele eseului " + i);
            String nameEssay = input.next();
            e[i].setName(nameEssay);

            System.out.printf("Introduceti deadline-ului eseului (dd-mm-yyyy) " + i);
            String deadlEssay = input.next();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
            Date date = formatter.parse(deadlEssay);
            e[i].setDeadline(date);


            System.out.printf("Introduceti topicul eseului " + i);
            String topic = input.next();
            a[i].setLanguage(topic);
        }


        System.out.println("Introduceti numarul de studenti:");
        int numberOfStudents = input.nextInt();

        for (int i = 1; i <=numberOfStudents; i++){
            System.out.println("Introduceti ID-ul studentului " + i);
            String IDStudent = input.next();

            System.out.println("Introduceti anul de studiu al studentului " + i);
            int yearStudent = input.nextInt();

            System.out.println("Introduceti numele studentului " + i);
            String lastNameStudent = input.next();

            System.out.println("Introduceti prenume studentului " + i);
            String firstNameStudent = input.next();

            Student s[i] = new Student(IDStudent, yearStudent, lastNameStudent, firstNameStudent);
        }*/


        Student s1 = new Student("S1", 2);
        Student s2 = new Student("S2", 1);
        Student s3 = new Student("S3",2);
        Student s4 = new Student("S4", 2);

        Application a1 = new Application("A1", LocalDate.of(2019, Month.JUNE, 1), Language.JAVA);
        Application a2 = new Application("A2", LocalDate.parse("2019-06-01"), Language.PHP);
        Application a3 = new Application("A3", LocalDate.parse("2019-06-02"), Language.PYTHON);

        Essay e1 = new Essay("E1", LocalDate.parse("2019-05-02"), Topic.ALGORITHMS);
        Essay e2 = new Essay("E2", LocalDate.parse("2019-05-02"), Topic.DATA_STRUCTURES);

        List<Project> listOfProjects = new ArrayList<>();


        listOfProjects.add(a1);
        listOfProjects.add(a2);
        listOfProjects.add(a3);
        s1.setPreferences(listOfProjects);

        listOfProjects.clear();
        listOfProjects.add(a1);
        listOfProjects.add(e1);
        s2.setPreferences(listOfProjects);

        listOfProjects.clear();
        listOfProjects.add(a2);
        listOfProjects.add(a3);
        listOfProjects.add(e1);

        s3.setPreferences(listOfProjects);

        listOfProjects.clear();
        listOfProjects.add(a3);
        listOfProjects.add(e2);
        s4.setPreferences(listOfProjects);

        Problem problem = new Problem();
        problem.setStudents(s1, s2, s3, s4);
        System.out.println(problem);


         //   List<Object> listOfProjects = new ArrayList<>();
        // add: listOfProjects.add(...)
    }
}
