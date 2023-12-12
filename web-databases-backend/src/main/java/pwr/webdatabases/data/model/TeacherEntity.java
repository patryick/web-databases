package pwr.webdatabases.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import pwr.webdatabases.auth.data.model.User;

@Entity(name = "TEACHER")
public class TeacherEntity extends AbstractEntity {

    @OneToOne
    private LessonEntity lesson;
    @OneToOne
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LessonEntity getLesson() {
        return lesson;
    }

    public void setLesson(LessonEntity lesson) {
        this.lesson = lesson;
    }

    @Override
    public String toString() {
        return "TeacherEntity{" +
            "lesson=" + lesson +
            ", user=" + user +
            '}';
    }
}
