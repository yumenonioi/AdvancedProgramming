package main;

public class Student {
    private int ID;
    private int yearOfStudy;
    private String name;
    private String prenume;
    private String preferences;
    private String[] preference;

    // Getters

    public int getID() {
        return ID;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public String getName() {
        return name;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getPreferences() {
        return preferences;
    }

    // Setters


    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setYearOfStudy(int studyYear) {
        this.yearOfStudy = studyYear;
    }

    public void setPreferences(String... preferences) {
        for (String preference : preferences)
            this.preferences = this.preferences + preference;

    }

    public void setPreference(String preferenceses) {
        preference = preferences.split(", ");
    }

    // Methods

    @Override
    public String toString() {
        return this.ID + "@" + name + "@" + prenume + "@" + preferences;
    }
}
