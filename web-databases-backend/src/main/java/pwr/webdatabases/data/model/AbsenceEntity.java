package pwr.webdatabases.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity(name = "ABSENCE")
public class AbsenceEntity extends AbstractEntity {

    @ManyToOne
    private StudentEntity student;
    @ManyToOne
    private LessonEntity lesson;
    private LocalDate date;

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "AbsenceEntity{" +
            "student=" + student +
            ", lesson=" + lesson +
            ", date=" + date +
            '}';
    }
}
