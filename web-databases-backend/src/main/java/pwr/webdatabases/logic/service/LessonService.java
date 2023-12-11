package pwr.webdatabases.logic.service;

import pwr.webdatabases.logic.model.LessonTo;
import pwr.webdatabases.logic.model.TeacherLessonTo;

import java.util.List;

public interface LessonService extends GenericService<LessonTo> {

    List<LessonTo> findAllByStudentId(Long studentId);
    public List<TeacherLessonTo> findAllByTeacherId(Long teacherId);
}
