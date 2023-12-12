package pwr.webdatabases.logic.model;

import java.util.List;

public class TeacherLessonDetailsTo extends TeacherLessonTo {

    private List<StudentNameTo> students;

    public List<StudentNameTo> getStudents() {
        return students;
    }

    public void setStudents(List<StudentNameTo> students) {
        this.students = students;
    }
}
