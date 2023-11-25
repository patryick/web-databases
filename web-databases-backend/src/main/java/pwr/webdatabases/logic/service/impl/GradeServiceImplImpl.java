package pwr.webdatabases.logic.service.impl;

import org.springframework.stereotype.Service;
import pwr.webdatabases.data.model.GradeEntity;
import pwr.webdatabases.data.repository.jpa.GradeJpaRepo;
import pwr.webdatabases.logic.mapper.GenericMapper;
import pwr.webdatabases.logic.mapper.GradeMapper;
import pwr.webdatabases.logic.model.GradeTo;
import pwr.webdatabases.logic.service.GradeService;

@Service
public class GradeServiceImplImpl extends GenericServiceImpl<GradeEntity, GradeTo> implements GradeService {

    public GradeServiceImplImpl(GradeJpaRepo repo) {
        super(repo);
    }

    @Override
    protected GenericMapper<GradeEntity, GradeTo> getMapper() {
        return GradeMapper.INSTANCE;
    }

    @Override
    protected boolean existsInDb(GradeTo object) {
        return false;
    }
}
