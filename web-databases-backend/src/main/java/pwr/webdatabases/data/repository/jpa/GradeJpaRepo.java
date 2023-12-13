package pwr.webdatabases.data.repository.jpa;

import pwr.webdatabases.data.model.GradeEntity;

import java.util.List;

public interface GradeJpaRepo extends JpaRepo <GradeEntity> {

    List<GradeEntity> findAllByLessonId(Long lessonId);
    List<GradeEntity> findAllByStudentId(Long studentId);
}
