package pwr.webdatabases.logic.service.impl;

import org.springframework.stereotype.Service;
import pwr.webdatabases.data.model.TeacherEntity;
import pwr.webdatabases.data.repository.jpa.TeacherJpaRepo;
import pwr.webdatabases.logic.mapper.GenericMapper;
import pwr.webdatabases.logic.mapper.TeacherMapper;
import pwr.webdatabases.logic.model.TeacherTo;
import pwr.webdatabases.logic.service.TeacherService;

@Service
public class TeacherServiceImpl extends GenericServiceImpl<TeacherEntity, TeacherTo> implements TeacherService {

    public TeacherServiceImpl(TeacherJpaRepo repo) {
        super(repo);
    }

    @Override
    protected GenericMapper<TeacherEntity, TeacherTo> getMapper() {
        return TeacherMapper.INSTANCE;
    }

    @Override
    protected boolean existsInDb(TeacherTo object) {
        return false;
    }
}
