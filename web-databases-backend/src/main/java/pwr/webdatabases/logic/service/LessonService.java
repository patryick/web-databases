package pwr.webdatabases.logic.service;

import pwr.webdatabases.logic.model.LessonTo;

import java.util.List;

public interface LessonService extends GenericService<LessonTo> {

    List<LessonTo> findAllByStudentId(Long studentId);
    public List<LessonTo> findAllByTeacherId(Long teacherId);
}
