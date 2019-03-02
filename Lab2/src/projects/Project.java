package projects;

import java.time.LocalDate;

public abstract class Project {
    protected String name = new String();
    protected LocalDate deadline;

    // Getters

    public String getName() {
        return name;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }


}
