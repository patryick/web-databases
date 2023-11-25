package pwr.webdatabases.logic.model;

import pwr.webdatabases.data.enums.GradeValueEnum;
import java.time.LocalDateTime;

public class GradeTo extends AbstractTo {

    private TeacherTo teacher;
    private StudentTo student;
    private GradeTo grade;
    private GradeValueEnum gradeValue;
    private LocalDateTime date;

    public TeacherTo getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherTo teacher) {
        this.teacher = teacher;
    }

    public StudentTo getStudent() {
        return student;
    }

    public void setStudent(StudentTo student) {
        this.student = student;
    }

    public GradeTo getGrade() {
        return grade;
    }

    public void setGrade(GradeTo grade) {
        this.grade = grade;
    }

    public GradeValueEnum getGradeValue() {
        return gradeValue;
    }

    public void setGradeValue(GradeValueEnum gradeValue) {
        this.gradeValue = gradeValue;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
