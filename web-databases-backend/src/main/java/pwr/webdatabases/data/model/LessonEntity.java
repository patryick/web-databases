package pwr.webdatabases.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity(name = "LESSON")
public class LessonEntity extends AbstractEntity {

    @ManyToOne
    private TeacherEntity teacher;
    @ManyToOne
    private ClassEntity classEntity;
    private String name;
    private String lessonDay;
    private String startTime;
    private String endTime;

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
