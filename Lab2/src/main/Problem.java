package main;

import javax.sound.midi.Soundbank;

public class Problem {
    private Student[] students = new Student[4];


    public void setStudents(Student... studs) {
        System.arraycopy(studs, 0, this.students, 0, studs.length);
    }

    public Student[] getStudents() {
        return students;
    }

    @Override
    public String toString() {
        for(Student student : this.students)
            System.out.println(student.getID() + ": " + student.getPreferences());
        return "";
    }
}
