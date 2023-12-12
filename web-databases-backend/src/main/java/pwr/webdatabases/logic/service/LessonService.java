package pwr.webdatabases.logic.service;

import pwr.webdatabases.logic.model.LessonDetailsTo;

public interface LessonService {

    LessonDetailsTo findLessonDetailsById(Long lessonId);
}
