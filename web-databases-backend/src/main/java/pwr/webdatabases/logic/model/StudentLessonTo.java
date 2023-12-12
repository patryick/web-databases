package pwr.webdatabases.logic.model;

public class StudentLessonTo extends TeacherLessonTo {

    private String endTime;
    private String teacher;

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
