package projects;

import enums.Language;

import java.util.Date;

public class Application extends Project {
    Language language;

    // Getters


    @Override
    public Date getDeadline() {
        return super.getDeadline();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public Language getLanguage() {
        return language;
    }


    // Setters

    @Override
    public void setDeadline(Date deadline) {
        super.setDeadline(deadline);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
