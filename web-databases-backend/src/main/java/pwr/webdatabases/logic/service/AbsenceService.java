package pwr.webdatabases.logic.service;

import pwr.webdatabases.logic.model.AbsenceDetailsTo;
import pwr.webdatabases.logic.model.AbsenceTo;
import pwr.webdatabases.logic.model.StudentAbsenceTo;

import java.util.List;

public interface AbsenceService {

    List<StudentAbsenceTo> findAllByStudentId(Long studentId);
    AbsenceDetailsTo saveAbsence(AbsenceTo absence);
    AbsenceDetailsTo updateAbsence(AbsenceDetailsTo absence, Long id);
    void deleteAbsence(Long absenceId);
}
