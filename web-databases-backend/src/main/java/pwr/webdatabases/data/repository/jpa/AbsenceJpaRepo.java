package pwr.webdatabases.data.repository.jpa;

import pwr.webdatabases.data.model.AbsenceEntity;

import java.util.List;

public interface AbsenceJpaRepo extends JpaRepo <AbsenceEntity> {

    List<AbsenceEntity> findAllByLessonId(Long lessonId);
    List<AbsenceEntity> findAllByStudentId(Long studentId);
}
