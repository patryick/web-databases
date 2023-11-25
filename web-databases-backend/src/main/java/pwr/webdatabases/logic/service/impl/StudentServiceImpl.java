package pwr.webdatabases.logic.service.impl;

import org.springframework.stereotype.Service;
import pwr.webdatabases.data.model.StudentEntity;
import pwr.webdatabases.data.repository.jpa.StudentJpaRepo;
import pwr.webdatabases.logic.mapper.GenericMapper;
import pwr.webdatabases.logic.mapper.StudentMapper;
import pwr.webdatabases.logic.model.StudentTo;
import pwr.webdatabases.logic.service.StudentService;

@Service
public class StudentServiceImpl extends GenericServiceImpl<StudentEntity, StudentTo> implements StudentService {

    public StudentServiceImpl(StudentJpaRepo repo) {
        super(repo);
    }

    @Override
    protected GenericMapper<StudentEntity, StudentTo> getMapper() {
        return StudentMapper.INSTANCE;
    }

    @Override
    protected boolean existsInDb(StudentTo object) {
        return false;
    }
}
