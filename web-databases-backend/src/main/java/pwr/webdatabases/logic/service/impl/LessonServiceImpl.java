package pwr.webdatabases.logic.service.impl;

import org.springframework.stereotype.Service;
import pwr.webdatabases.data.model.LessonEntity;
import pwr.webdatabases.data.model.StudentEntity;
import pwr.webdatabases.data.repository.jpa.LessonJpaRepo;
import pwr.webdatabases.data.repository.jpa.StudentJpaRepo;
import pwr.webdatabases.logic.mapper.LessonMapper;
import pwr.webdatabases.logic.model.*;
import pwr.webdatabases.logic.service.LessonService;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    private final StudentJpaRepo studentJpaRepo;
    private final LessonJpaRepo lessonJpaRepo;
    private final LessonMapper lessonMapper = LessonMapper.INSTANCE;

    public LessonServiceImpl(StudentJpaRepo studentJpaRepo, LessonJpaRepo lessonJpaRepo) {
        this.studentJpaRepo = studentJpaRepo;
        this.lessonJpaRepo = lessonJpaRepo;
    }

    @Override
    public List<StudentLessonTo> findAllByStudentId(Long studentId) {

        StudentEntity studentEntity = studentJpaRepo.findById(studentId).orElse(null);
        if (null == studentEntity) {
            throw new RuntimeException("Student with id: " + studentId + " not found");
        }
        Long classId = studentEntity.getClassEntity().getId();

        return lessonMapper.toDetailsToList(lessonJpaRepo.findAllByClassEntityId(classId));
    }


    @Override
    public List<TeacherLessonTo> findAllByTeacherId(Long teacherId) {

        return lessonMapper.toRawToList(lessonJpaRepo.findAllByTeacherId(teacherId));
    }

    @Override
    public TeacherLessonDetailsTo findDetailsById(Long lessonId) {

        LessonEntity entity = lessonJpaRepo.findById(lessonId).orElse(null);
        if (entity == null) {
            throw new RuntimeException("Lesson with id: " + lessonId + " not found");
        }
        return lessonMapper.toStudentsTo(entity);
    }
}
