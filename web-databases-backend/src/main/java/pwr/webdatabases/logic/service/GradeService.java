package pwr.webdatabases.logic.service;

import pwr.webdatabases.logic.model.GradeDetailsTo;
import pwr.webdatabases.logic.model.GradeTo;

public interface GradeService {

    GradeDetailsTo saveGrade(GradeTo grade);
    GradeDetailsTo updateGrade(GradeTo grade, Long gradeId);
    void deleteGrade(Long id);
}
