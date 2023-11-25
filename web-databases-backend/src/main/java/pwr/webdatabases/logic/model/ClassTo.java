package pwr.webdatabases.logic.model;

public class ClassTo extends AbstractTo{

    private TeacherTo teacher;
    private String name;

    public TeacherTo getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherTo teacher) {
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
