package pwr.webdatabases.logic.service;

import pwr.webdatabases.logic.model.StudentLessonTo;
import pwr.webdatabases.logic.model.TeacherLessonDetailsTo;
import pwr.webdatabases.logic.model.TeacherLessonTo;

import java.util.List;

public interface LessonService {

    List<StudentLessonTo> findAllByStudentId(Long studentId);
    List<TeacherLessonTo> findAllByTeacherId(Long teacherId);
    TeacherLessonDetailsTo findDetailsById(Long lessonId);
}
