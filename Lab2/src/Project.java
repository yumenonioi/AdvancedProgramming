import java.util.Date;

public abstract class Project {
    protected String name;
    protected Date deadline;

    // Getters

    public String getName() {
        return name;
    }

    public Date getDeadline() {
        return deadline;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }



}
