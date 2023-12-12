package pwr.webdatabases.logic.model;

import java.util.List;

public class StudentLessonDetailsTo extends AbstractTo {

    private String name;
    private String surname;
    private List<GradeTo> grades;
    private List<AbsenceTo> absences;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<GradeTo> getGrades() {
        return grades;
    }

    public void setGrades(List<GradeTo> grades) {
        this.grades = grades;
    }

    public List<AbsenceTo> getAbsences() {
        return absences;
    }

    public void setAbsences(List<AbsenceTo> absences) {
        this.absences = absences;
    }
}
