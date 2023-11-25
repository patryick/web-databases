package pwr.webdatabases.logic.model;

public class LessonTo extends AbstractTo {

    private TeacherTo teacher;
    private ClassTo classTo;
    private String subject;
    private String classNumber;

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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }
}
