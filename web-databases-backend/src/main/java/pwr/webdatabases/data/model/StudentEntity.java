package pwr.webdatabases.data.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import pwr.webdatabases.auth.data.model.User;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "STUDENT")
public class StudentEntity extends AbstractEntity {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    @JsonIgnoreProperties("student")
    private List<GradeEntity> grades;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
    @JsonIgnoreProperties("student")
    private List<AbsenceEntity> absences;
    @ManyToOne
    @JsonIgnoreProperties("student")
    private ClassEntity classEntity;
    @OneToOne
    @JsonIgnoreProperties("student")
    private User user;
    private LocalDateTime dateOfBirth;

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<GradeEntity> getGrades() {
        return grades;
    }

    public void setGrades(List<GradeEntity> grades) {
        this.grades = grades;
    }

    public List<AbsenceEntity> getAbsences() {
        return absences;
    }

    public void setAbsences(List<AbsenceEntity> absences) {
        this.absences = absences;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
