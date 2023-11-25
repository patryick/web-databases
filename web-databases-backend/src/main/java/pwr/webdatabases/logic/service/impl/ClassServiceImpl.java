package pwr.webdatabases.logic.service.impl;

import org.springframework.stereotype.Service;
import pwr.webdatabases.data.model.ClassEntity;
import pwr.webdatabases.data.repository.jpa.ClassJpaRepo;
import pwr.webdatabases.logic.mapper.ClassMapper;
import pwr.webdatabases.logic.mapper.GenericMapper;
import pwr.webdatabases.logic.model.ClassTo;
import pwr.webdatabases.logic.service.ClassService;

@Service
public class ClassServiceImpl extends GenericServiceImpl<ClassEntity, ClassTo> implements ClassService {

    public ClassServiceImpl(ClassJpaRepo repo) {
        super(repo);
    }

    @Override
    protected GenericMapper<ClassEntity, ClassTo> getMapper() {
        return ClassMapper.INSTANCE;
    }

    @Override
    protected boolean existsInDb(ClassTo object) {
        return false;
    }
}
