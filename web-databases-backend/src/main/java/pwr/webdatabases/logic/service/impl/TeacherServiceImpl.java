package pwr.webdatabases.logic.service.impl;

import org.springframework.stereotype.Service;
import pwr.webdatabases.data.repository.jpa.TeacherJpaRepo;
import pwr.webdatabases.logic.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherJpaRepo teacherJpaRepo;

    public TeacherServiceImpl(TeacherJpaRepo teacherJpaRepo) {
        this.teacherJpaRepo = teacherJpaRepo;
    }
}
