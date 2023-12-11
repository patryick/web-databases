package pwr.webdatabases.logic.model;

public class LessonTo extends AbstractTo {

    private TeacherTo teacher;
    private ClassTo classTo;
    private String name;

    public TeacherTo getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherTo teacher) {
        this.teacher = teacher;
    }

    public ClassTo getClassTo() {
        return classTo;
    }

    public void setClassTo(ClassTo classTo) {
        this.classTo = classTo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
