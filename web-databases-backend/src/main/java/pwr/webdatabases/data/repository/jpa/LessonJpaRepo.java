package pwr.webdatabases.data.repository.jpa;

import pwr.webdatabases.data.model.LessonEntity;

import java.util.List;

public interface LessonJpaRepo extends JpaRepo<LessonEntity> {

    List<LessonEntity> findAllByClassEntityId(Long classId);
    List<LessonEntity> findAllByTeacherId(Long teacherId);
}
