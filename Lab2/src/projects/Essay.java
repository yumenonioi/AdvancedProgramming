package projects;

import enums.Topic;

import java.time.LocalDate;

public class Essay extends Project {
    public Topic topic;

    //consrtuctor
    public Essay(String name, LocalDate deadline, Topic topic) {
        this.name = name;
        this.deadline = deadline;
        this.topic = topic;
    }

    //Getters

    @Override
    public LocalDate getDeadline() {
        return this.deadline;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public Topic getTopic() {
        return topic;
    }

    //Setters

    @Override
    public void setDeadline(LocalDate deadline) {
        super.setDeadline(deadline);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    //toString

    @Override
    public String toString() {
        return name;
    }
}