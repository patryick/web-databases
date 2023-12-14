package pwr.webdatabases.data.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import pwr.webdatabases.data.enums.GradeValueEnum;

import java.time.LocalDate;
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
    private LocalDate date;
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

    public Integer getGradeValue() {
        return gradeValue.getValue();
    }

    public void setGradeValue(Integer gradeValue) {
        this.gradeValue = GradeValueEnum.of(gradeValue);
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
