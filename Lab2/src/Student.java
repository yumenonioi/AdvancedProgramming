public class Student {
    private int ID;
    private int studyYear;
    private String name;
    private String prenume;
    private String preferences;
    private String[] preference;

    // Getters

    public int getID() {
        return ID;
    }

    public int getStudyYear() {
        return studyYear;
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

    public void setStudyYear(int studyYear) {
        this.studyYear = studyYear;
    }

    public void setPreferences(String preferences) {
        this.preferences = preferences;
    }

    public void setPreference(String preferenes) {
        preference = preferences.split("\\.");
    }

    // Methods

    @Override
    public String toString(){
        return this.ID + "@" + name + "@" + prenume;
    }
}
