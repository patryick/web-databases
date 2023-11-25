package pwr.webdatabases.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity(name = "TEACHER")
public class TeacherEntity extends AbstractEntity {

    @OneToOne
    private ClassEntity classEntity;
    private String name;
    private String surname;

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
