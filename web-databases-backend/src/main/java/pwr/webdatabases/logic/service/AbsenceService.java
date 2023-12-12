package pwr.webdatabases.logic.service;

import pwr.webdatabases.logic.model.AbsenceTo;

import java.util.List;

public interface AbsenceService {

    List<AbsenceTo> findAllByStudentId(Long studentId);
    AbsenceTo saveAbsence(AbsenceTo absence);
    AbsenceTo updateAbsence(AbsenceTo absence, Long id);
    void deleteAbsence(Long absenceId);
}
