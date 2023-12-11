package pwr.webdatabases.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity(name = "LESSON")
public class LessonEntity extends AbstractEntity {

    @OneToOne
    private TeacherEntity teacher;
    @ManyToOne
    private ClassEntity classEntity;
    private String name;

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
}
