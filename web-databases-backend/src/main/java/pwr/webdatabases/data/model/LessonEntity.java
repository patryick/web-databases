package pwr.webdatabases.data.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.time.LocalTime;

@Entity(name = "LESSON")
public class LessonEntity extends AbstractEntity {

    @ManyToOne
    @JsonIgnoreProperties("lessons")
    private TeacherEntity teacher;
    @ManyToOne
    @JsonIgnoreProperties("lessons")
    private ClassEntity classEntity;
    private String name;
    private String lessonDay;
    private LocalTime startTime;
    private LocalTime endTime;
    private String location;

    public TeacherEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherEntity teacher) {
        this.teacher = teacher;
    }

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String subject) {
        this.name = subject;
    }

    public String getLessonDay() {
        return lessonDay;
    }

    public void setLessonDay(String day) {
        this.lessonDay = day;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
