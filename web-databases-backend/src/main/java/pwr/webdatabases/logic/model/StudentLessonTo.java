package pwr.webdatabases.logic.model;

public class StudentLessonTo extends TeacherLessonTo {

    private String teacherName;
    private String teacherSurname;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSurname() {
        return teacherSurname;
    }

    public void setTeacherSurname(String teacherSurname) {
        this.teacherSurname = teacherSurname;
    }
}
