package pwr.webdatabases.logic.model;

import java.util.List;

public class LessonDetailsTo extends AbstractTo {

    private String name;
    private String time;
    private List<StudentTo> studentsList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<StudentTo> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<StudentTo> studentsList) {
        this.studentsList = studentsList;
    }
}
