package pwr.webdatabases.logic.service.impl;

import org.springframework.stereotype.Service;
import pwr.webdatabases.data.model.GradeEntity;
import pwr.webdatabases.data.repository.jpa.GradeJpaRepo;
import pwr.webdatabases.logic.mapper.GradeMapper;
import pwr.webdatabases.logic.model.GradeTo;
import pwr.webdatabases.logic.service.GradeService;

import java.util.Objects;

@Service
public class GradeServiceImpl implements GradeService {

    private final GradeJpaRepo gradeJpaRepo;
    private final GradeMapper gradeMapper = GradeMapper.INSTANCE;

    public GradeServiceImpl(GradeJpaRepo gradeJpaRepo) {
        this.gradeJpaRepo = gradeJpaRepo;
    }

    @Override
    public GradeTo saveGrade(GradeTo grade) {

        Objects.requireNonNull(grade);
        grade.setId(null);

        return gradeMapper.toTo(gradeJpaRepo.save(gradeMapper.toEntity(grade)));
    }

    @Override
    public GradeTo updateGrade(GradeTo grade, Long gradeId) {

        Objects.requireNonNull(grade);
        GradeEntity entity = gradeJpaRepo.getReferenceById(gradeId);
        Objects.requireNonNull(entity);
        updateGrade(entity, grade);

        return gradeMapper.toTo(gradeJpaRepo.save(entity));
    }

    private void updateGrade(GradeEntity entity, GradeTo to) {

        if (null != to.getGradeValue()){
            entity.setGradeValue(to.getGradeValue());
        }
        if (null != to.getDate()) {
            entity.setDate(to.getDate());
        }
        if (null != to.getDetails()) {
            entity.setDetails(to.getDetails());
        }
    }

    @Override
    public void deleteGrade(Long id) {

        gradeJpaRepo.deleteById(id);
    }
}
