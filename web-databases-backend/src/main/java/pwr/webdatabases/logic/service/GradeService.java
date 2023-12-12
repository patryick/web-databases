package pwr.webdatabases.logic.service;

import pwr.webdatabases.logic.model.GradeTo;

public interface GradeService {

    GradeTo saveGrade(GradeTo grade);
    GradeTo updateGrade(GradeTo grade, Long gradeId);
    void deleteGrade(Long id);
}
