package pwr.webdatabases.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity(name = "LESSON")
public class LessonEntity extends AbstractEntity {

    @ManyToOne
    private TeacherEntity teacher;
    @ManyToOne
    private ClassEntity classEntity;
    private String lessonName;
    private String lessonDay;
    private String lessonStartTime;
    private String lessonEndTime;

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

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String subject) {
        this.lessonName = subject;
    }

    public String getLessonDay() {
        return lessonDay;
    }

    public void setLessonDay(String day) {
        this.lessonDay = day;
    }

    public String getLessonStartTime() {
        return lessonStartTime;
    }

    public void setLessonStartTime(String startTime) {
        this.lessonStartTime = startTime;
    }

    public String getLessonEndTime() {
        return lessonEndTime;
    }

    public void setLessonEndTime(String endTime) {
        this.lessonEndTime = endTime;
    }
}
