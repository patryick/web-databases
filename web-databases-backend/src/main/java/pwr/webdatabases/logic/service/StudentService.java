package pwr.webdatabases.logic.service;

import pwr.webdatabases.logic.model.StudentLessonDetailsTo;

public interface StudentService {

    StudentLessonDetailsTo findStudentLessonDetailsByIdAndLessonId(Long lessonId, Long studentId);
}
