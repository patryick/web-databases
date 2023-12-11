package pwr.webdatabases.logic.service;

import pwr.webdatabases.logic.model.LessonDetailsTo;
import pwr.webdatabases.logic.model.LessonTo;
import pwr.webdatabases.logic.model.StudentLessonTo;
import pwr.webdatabases.logic.model.TeacherLessonTo;

import java.util.List;

public interface LessonService extends GenericService<LessonTo> {

    List<StudentLessonTo> findAllByStudentId(Long studentId);
    List<TeacherLessonTo> findAllByTeacherId(Long teacherId);
    LessonDetailsTo findDetailsById(Long lessonId);
}
