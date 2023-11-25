package pwr.webdatabases.logic.model;

public class TeacherTo extends AbstractTo {

    private ClassTo classEntity;
    private String name;
    private String surname;

    public ClassTo getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassTo classEntity) {
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
