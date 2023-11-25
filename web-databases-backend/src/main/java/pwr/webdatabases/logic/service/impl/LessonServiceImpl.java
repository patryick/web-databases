package pwr.webdatabases.logic.service.impl;

import org.springframework.stereotype.Service;
import pwr.webdatabases.data.model.LessonEntity;
import pwr.webdatabases.data.repository.jpa.LessonJpaRepo;
import pwr.webdatabases.logic.mapper.GenericMapper;
import pwr.webdatabases.logic.mapper.LessonMapper;
import pwr.webdatabases.logic.model.LessonTo;
import pwr.webdatabases.logic.service.LessonService;

@Service
public class LessonServiceImpl extends GenericServiceImpl<LessonEntity, LessonTo> implements LessonService {

    public LessonServiceImpl(LessonJpaRepo repo) {
        super(repo);
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
