package pwr.webdatabases.logic.service.impl;

import org.springframework.stereotype.Service;
import pwr.webdatabases.data.model.LessonEntity;
import pwr.webdatabases.data.repository.jpa.LessonJpaRepo;
import pwr.webdatabases.logic.mapper.LessonMapper;
import pwr.webdatabases.logic.model.LessonDetailsTo;
import pwr.webdatabases.logic.service.LessonService;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonJpaRepo lessonJpaRepo;
    private final LessonMapper lessonMapper = LessonMapper.INSTANCE;

    public LessonServiceImpl(LessonJpaRepo lessonJpaRepo) {
        this.lessonJpaRepo = lessonJpaRepo;
    }

    @Override
    public LessonDetailsTo findLessonDetailsById(Long lessonId) {

        LessonEntity entity = lessonJpaRepo.findById(lessonId).orElse(null);
        if (entity == null) {
            throw new RuntimeException("Lesson with id: " + lessonId + " not found");
        }
        return lessonMapper.toDetailsTo(entity);
    }
}
