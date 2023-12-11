package pwr.webdatabases.logic.service.impl;

import org.springframework.stereotype.Service;
import pwr.webdatabases.data.model.LessonEntity;
import pwr.webdatabases.data.model.StudentEntity;
import pwr.webdatabases.data.model.TeacherEntity;
import pwr.webdatabases.data.repository.jpa.LessonJpaRepo;
import pwr.webdatabases.data.repository.jpa.StudentJpaRepo;
import pwr.webdatabases.data.repository.jpa.TeacherJpaRepo;
import pwr.webdatabases.logic.mapper.GenericMapper;
import pwr.webdatabases.logic.mapper.LessonMapper;
import pwr.webdatabases.logic.model.LessonTo;
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
    public List<LessonTo> findAllByStudentId(Long studentId) {

        StudentEntity studentEntity = studentJpaRepo.findById(studentId).orElse(null);
        if (null == studentEntity) {
            throw new RuntimeException("Student with id: " + studentId + " not found");
        }
        Long classId = studentEntity.getClassEntity().getId();

        return mapper.toTransferObjectList(repo.findAllByClassEntityId(classId));
    }

    @Override
    public List<LessonTo> findAllByTeacherId(Long teacherId) {

        return mapper.toTransferObjectList(repo.findAllByTeacherId(teacherId));
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
