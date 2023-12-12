package pwr.webdatabases.logic.service.impl;

import org.springframework.stereotype.Service;
import pwr.webdatabases.data.repository.jpa.GradeJpaRepo;
import pwr.webdatabases.logic.model.GradeTo;
import pwr.webdatabases.logic.service.GradeService;

@Service
public class GradeServiceImpl implements GradeService {

    private final GradeJpaRepo gradeJpaRepo;

    public GradeServiceImpl(GradeJpaRepo gradeJpaRepo) {
        this.gradeJpaRepo = gradeJpaRepo;
    }

    @Override
    public GradeTo saveGrade(GradeTo grade) {
        return null;
    }

    @Override
    public GradeTo updateGrade(GradeTo grade, Long gradeId) {
        return null;
    }

    @Override
    public void deleteGrade(Long id) {

    }
}
