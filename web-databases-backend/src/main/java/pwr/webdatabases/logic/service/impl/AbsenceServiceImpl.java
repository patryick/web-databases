package pwr.webdatabases.logic.service.impl;

import org.springframework.stereotype.Service;
import pwr.webdatabases.data.model.AbsenceEntity;
import pwr.webdatabases.data.repository.jpa.AbsenceJpaRepo;
import pwr.webdatabases.logic.mapper.AbsenceMapper;
import pwr.webdatabases.logic.model.AbsenceDetailsTo;
import pwr.webdatabases.logic.model.AbsenceTo;
import pwr.webdatabases.logic.service.AbsenceService;

import java.util.List;
import java.util.Objects;

@Service
public class AbsenceServiceImpl implements AbsenceService {

    private final AbsenceJpaRepo absenceJpaRepo;
    private AbsenceMapper absenceMapper = AbsenceMapper.INSTANCE;

    public AbsenceServiceImpl(AbsenceJpaRepo absenceJpaRepo) {
        this.absenceJpaRepo = absenceJpaRepo;
    }

    @Override
    public List<AbsenceDetailsTo> findAllByStudentId(Long studentId) {
        return absenceMapper.toToList(absenceJpaRepo.findAllByStudentId(studentId));
    }

    @Override
    public AbsenceDetailsTo saveAbsence(AbsenceTo absence) {

        Objects.requireNonNull(absence);

        return absenceMapper.toTo(absenceJpaRepo.save(absenceMapper.toEntity(absence)));
    }

    @Override
    public AbsenceDetailsTo updateAbsence(AbsenceDetailsTo absence, Long id) {

        Objects.requireNonNull(absence);
        AbsenceEntity entity = absenceJpaRepo.getReferenceById(id);
        Objects.requireNonNull(entity);
        updateAbsence(entity, absence);

        return absenceMapper.toTo(absenceJpaRepo.save(entity));
    }

    private void updateAbsence(AbsenceEntity entity, AbsenceDetailsTo to) {
        if (null != to.getDate()) {
            entity.setDate(to.getDate());
        }
    }

    @Override
    public void deleteAbsence(Long absenceId) {

        absenceJpaRepo.deleteById(absenceId);
    }
}
