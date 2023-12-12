package pwr.webdatabases.logic.service;

import pwr.webdatabases.logic.model.AbsenceDetailsTo;
import pwr.webdatabases.logic.model.AbsenceTo;

import java.util.List;

public interface AbsenceService {

    List<AbsenceDetailsTo> findAllByStudentId(Long studentId);
    AbsenceDetailsTo saveAbsence(AbsenceTo absence);
    AbsenceDetailsTo updateAbsence(AbsenceDetailsTo absence, Long id);
    void deleteAbsence(Long absenceId);
}
