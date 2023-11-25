package pwr.webdatabases.data.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity(name = "CLASS")
public class ClassEntity extends AbstractEntity {

    @OneToOne
    private TeacherEntity teacher;
    private String name;
}
