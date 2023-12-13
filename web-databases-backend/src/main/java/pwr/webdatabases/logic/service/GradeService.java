package pwr.webdatabases.logic.service;

import pwr.webdatabases.logic.model.GradeDetailsTo;
import pwr.webdatabases.logic.model.GradeTo;

import java.util.List;

public interface GradeService {

    List<GradeDetailsTo> findAllGradesByStudentId(Long studentId);
    GradeDetailsTo saveGrade(GradeTo grade);
    GradeDetailsTo updateGrade(GradeTo grade, Long gradeId);
    void deleteGrade(Long id);
}
