package pwr.webdatabases.logic.model;

public class AbsenceTo extends AbsenceDetailsTo {

    private Long student;
    private Long lesson;

    public Long getStudent() {
        return student;
    }

    public void setStudent(Long student) {
        this.student = student;
    }

    public Long getLesson() {
        return lesson;
    }

    public void setLesson(Long lesson) {
        this.lesson = lesson;
    }
}
