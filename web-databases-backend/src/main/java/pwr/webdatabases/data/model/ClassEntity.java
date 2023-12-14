package pwr.webdatabases.data.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "CLASS")
public class ClassEntity extends AbstractEntity {

    @OneToMany(mappedBy = "classEntity")
    @JsonIgnoreProperties("classEntity")
    private List<StudentEntity> students;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }
}
