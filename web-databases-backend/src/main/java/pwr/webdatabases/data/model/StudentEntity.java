package pwr.webdatabases.data.model;

import jakarta.persistence.*;
import pwr.webdatabases.auth.data.model.User;

import java.time.LocalDateTime;

@Entity(name = "STUDENT")
public class StudentEntity extends AbstractEntity {

    @ManyToOne
    private ClassEntity classEntity;
    private String name;
    private String surname;
    private LocalDateTime dateOfBirth;

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

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
