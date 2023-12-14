package pwr.webdatabases.data.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import pwr.webdatabases.auth.data.model.User;

import java.util.List;

@Entity(name = "TEACHER")
public class TeacherEntity extends AbstractEntity {

    @OneToMany(mappedBy = "teacher")
    @JsonIgnoreProperties("teacher")
    private List<LessonEntity> lessons;
    @OneToOne
    @JsonIgnoreProperties("teacher")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<LessonEntity> getLessons() {
        return lessons;
    }

    public void setLessons(List<LessonEntity> lesson) {
        this.lessons = lesson;
    }

    @Override
    public String toString() {
        return "TeacherEntity{" +
            "lesson=" + lessons +
            ", user=" + user +
            '}';
    }
}
