package pwr.webdatabases.logic.service;

import pwr.webdatabases.logic.model.StudentLessonTo;
import pwr.webdatabases.logic.model.LessonDetailsTo;
import pwr.webdatabases.logic.model.TeacherLessonTo;

import java.util.List;

public interface ScheduleService {

    List<StudentLessonTo> getScheduleForStudent(Long studentId);
    List<TeacherLessonTo> getScheduleForTeacher(Long teacherId);

}
