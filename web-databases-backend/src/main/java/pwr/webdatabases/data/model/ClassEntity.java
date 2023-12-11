package pwr.webdatabases.data.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "CLASS")
public class ClassEntity extends AbstractEntity {

    @ManyToOne
    private TeacherEntity teacher;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "classEntity")
    private List<StudentEntity> students;
    private String name;

    public TeacherEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherEntity teacher) {
        this.teacher = teacher;
    }

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
