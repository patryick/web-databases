package pwr.webdatabases.logic.service.impl;

import org.springframework.stereotype.Service;
import pwr.webdatabases.data.model.LessonEntity;
import pwr.webdatabases.data.model.StudentEntity;
import pwr.webdatabases.data.repository.jpa.LessonJpaRepo;
import pwr.webdatabases.data.repository.jpa.StudentJpaRepo;
import pwr.webdatabases.logic.mapper.GenericMapper;
import pwr.webdatabases.logic.mapper.LessonMapper;
import pwr.webdatabases.logic.model.LessonTo;
import pwr.webdatabases.logic.model.StudentLessonTo;
import pwr.webdatabases.logic.model.TeacherLessonTo;
import pwr.webdatabases.logic.service.LessonService;

import java.util.List;

@Service
public class LessonServiceImpl extends GenericServiceImpl<LessonEntity, LessonTo> implements LessonService {

    private final StudentJpaRepo studentJpaRepo;
    private final LessonJpaRepo repo;

    public LessonServiceImpl(LessonJpaRepo repo, StudentJpaRepo studentJpaRepo) {
        super(repo);
        this.repo = repo;
        this.studentJpaRepo = studentJpaRepo;
    }

    @Override
    public List<StudentLessonTo> findAllByStudentId(Long studentId) {

        StudentEntity studentEntity = studentJpaRepo.findById(studentId).orElse(null);
        if (null == studentEntity) {
            throw new RuntimeException("Student with id: " + studentId + " not found");
        }
        Long classId = studentEntity.getClassEntity().getId();


        return repo.findAllByClassEntityId(classId).stream()
            .map(c -> {
                StudentLessonTo lesson = new StudentLessonTo();
                lesson.setName(c.getLessonName());
                lesson.setTeacher(c.getTeacher().getName());
                lesson.setDay(c.getLessonDay());
                lesson.setStartTime(c.getLessonStartTime());
                lesson.setEndTime(c.getLessonEndTime());
                return lesson;
            })
            .toList();
    }

    @Override
    public List<TeacherLessonTo> findAllByTeacherId(Long teacherId) {

        return repo.findAllByTeacherId(teacherId).stream()
            .map(c -> {
                TeacherLessonTo lesson = new TeacherLessonTo();
                lesson.setName(c.getLessonName());
                lesson.setTime(c.getLessonDay() + ", " + c.getLessonStartTime());
                return lesson;
            })
            .toList();
    }

    @Override
    protected GenericMapper<LessonEntity, LessonTo> getMapper() {
        return LessonMapper.INSTANCE;
    }

    @Override
    protected boolean existsInDb(LessonTo object) {
        return false;
    }
}
