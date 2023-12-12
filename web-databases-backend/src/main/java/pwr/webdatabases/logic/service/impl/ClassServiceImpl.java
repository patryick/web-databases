package pwr.webdatabases.logic.service.impl;

import org.springframework.stereotype.Service;
import pwr.webdatabases.data.repository.jpa.ClassJpaRepo;
import pwr.webdatabases.logic.service.ClassService;

@Service
public class ClassServiceImpl implements ClassService {

    private final ClassJpaRepo classJpaRepo;

    public ClassServiceImpl(ClassJpaRepo classJpaRepo) {
        this.classJpaRepo = classJpaRepo;
    }
}
