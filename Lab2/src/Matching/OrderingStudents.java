package Matching;

import main.Student;

import java.util.Comparator;

public class OrderingStudents implements Comparator<Student> {
    public int compare(Student a, Student b) {
        return a.preference.length - b.preference.length;
    }
}
