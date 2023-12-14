package pwr.webdatabases.data.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import pwr.webdatabases.data.enums.GradeValueEnum;
import java.time.LocalDateTime;

@Entity(name = "GRADE")
public class GradeEntity extends AbstractEntity {

    @ManyToOne
    @JsonIgnoreProperties("grades")
    private TeacherEntity teacher;
    @ManyToOne
    @JsonIgnoreProperties("grades")
    private StudentEntity student;
    @ManyToOne
    @JsonIgnoreProperties("grades")
    private LessonEntity lesson;
    private GradeValueEnum gradeValue;
    private LocalDateTime date;
    private String details;

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

    public LessonEntity getLesson() {
        return lesson;
    }

    public void setLesson(LessonEntity lesson) {
        this.lesson = lesson;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
