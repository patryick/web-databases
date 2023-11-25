package pwr.webdatabases.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import pwr.webdatabases.data.enums.GradeValueEnum;
import java.time.LocalDateTime;

@Entity(name = "GRADE")
public class GradeEntity extends AbstractEntity {

    @ManyToOne
    private TeacherEntity teacher;
    @ManyToOne
    private StudentEntity student;
    @ManyToOne
    private GradeEntity grade;
    private GradeValueEnum gradeValue;
    private LocalDateTime date;

    public TeacherEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherEntity teacher) {
        this.teacher = teacher;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public GradeEntity getGrade() {
        return grade;
    }

    public void setGrade(GradeEntity grade) {
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
