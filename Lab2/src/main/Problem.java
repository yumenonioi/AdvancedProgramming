package main;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Cristian and Cristina
 *  This class implements the preference lists*/
public class Problem {
    private List<Student> studs = new ArrayList<>();
    private String projects = new String();

    /** */
    public void setStudents(List<Student> students) {
        studs = students;
        for(Student student : studs){
            for(int i=0; i<student.preference.length; i++)
                if(!(projects.contains(student.preference[i])))
                    setProjects(student.preference[i]);
        }
    }

    /** */
    public void setProjects(String project) {
        if(projects.length() != 0)
            projects = projects + ", " + project;
        else
            projects = project;
    }

    public List<Student> getStudents() {
        return studs;
    }

    public String getProjects(){
        return projects;
    }

    /** */
    @Override
    public String toString() {
        for(Student student : studs)
            System.out.println(student.getID() + ": " + student.getPreferences());
        return "";
    }
}
