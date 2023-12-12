package pwr.webdatabases.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import pwr.webdatabases.auth.data.model.User;

@Entity(name = "TEACHER")
public class TeacherEntity extends AbstractEntity {

    @OneToOne
    private ClassEntity classEntity;
    @OneToOne
    private TeacherEntity teacher;
    @OneToOne
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

}
