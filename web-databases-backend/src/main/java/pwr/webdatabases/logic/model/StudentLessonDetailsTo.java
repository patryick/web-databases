package pwr.webdatabases.logic.model;

import java.util.List;

public class StudentLessonDetailsTo extends AbstractTo {

    private String name;
    private String surname;
    private List<GradeDetailsTo> grades;
    private List<AbsenceDetailsTo> absences;

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

    public List<GradeDetailsTo> getGrades() {
        return grades;
    }

    public void setGrades(List<GradeDetailsTo> grades) {
        this.grades = grades;
    }

    public List<AbsenceDetailsTo> getAbsences() {
        return absences;
    }

    public void setAbsences(List<AbsenceDetailsTo> absences) {
        this.absences = absences;
    }
}
