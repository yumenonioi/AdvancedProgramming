package projects;

import java.time.LocalDate;

public abstract class Project {
    protected String name = new String();
    protected LocalDate deadline;
    protected int numberOfAppearances = 0;

    // Getters

    public String getName() {
        return name;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public int getNumberOfAppearances() {
        return numberOfAppearances;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setNumberOfAppearances(int numberOfAppearances) {
        this.numberOfAppearances = numberOfAppearances;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
